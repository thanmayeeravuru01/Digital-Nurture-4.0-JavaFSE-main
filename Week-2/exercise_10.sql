-- Step 0: Drop objects if they already exist
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE AccountAuditLog';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE LoanEMIErrors';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

BEGIN
    EXECUTE IMMEDIATE 'DROP TRIGGER LogAccountChanges';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

-- Step 1: Audit & Error Log Tables

CREATE TABLE AccountAuditLog (
    AuditID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    AccountID NUMBER,
    OldBalance NUMBER,
    NewBalance NUMBER,
    ChangedAt DATE
);

CREATE TABLE LoanEMIErrors (
    ErrorID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    LoanID NUMBER,
    ErrorMessage VARCHAR2(400),
    LoggedAt DATE
);

-- Step 2: Trigger for Balance Audit

CREATE OR REPLACE TRIGGER LogAccountChanges
BEFORE UPDATE OF Balance ON Accounts
FOR EACH ROW
BEGIN
    INSERT INTO AccountAuditLog (AccountID, OldBalance, NewBalance, ChangedAt)
    VALUES (:OLD.AccountID, :OLD.Balance, :NEW.Balance, SYSDATE);
END;
/

-- Step 3: Cursor with Error Logging for EMI Calculation

DECLARE
    CURSOR emi_cursor IS
        SELECT l.LoanID, c.Name, l.LoanAmount, l.InterestRate, l.StartDate, l.EndDate
        FROM Loans l
        JOIN Customers c ON c.CustomerID = l.CustomerID;

    v_loan_id Loans.LoanID%TYPE;
    v_name Customers.Name%TYPE;
    v_amount Loans.LoanAmount%TYPE;
    v_rate Loans.InterestRate%TYPE;
    v_start Loans.StartDate%TYPE;
    v_end Loans.EndDate%TYPE;
    v_months NUMBER;
    v_emi NUMBER;
    v_err VARCHAR2(400);
BEGIN
    OPEN emi_cursor;
    LOOP
        FETCH emi_cursor INTO v_loan_id, v_name, v_amount, v_rate, v_start, v_end;
        EXIT WHEN emi_cursor%NOTFOUND;

        BEGIN
            v_months := TRUNC(MONTHS_BETWEEN(v_end, v_start));

            IF v_months = 0 THEN
                RAISE_APPLICATION_ERROR(-20006, 'Loan ID ' || v_loan_id || ' has zero duration.');
            END IF;

            v_emi := ROUND((v_amount + (v_amount * v_rate * v_months / 1200)) / v_months, 2);

            IF v_emi > 10000 THEN
                RAISE_APPLICATION_ERROR(-20007, 'Loan ID ' || v_loan_id || ' EMI ₹' || v_emi || ' exceeds ₹10,000.');
            END IF;

            DBMS_OUTPUT.PUT_LINE('Loan ID: ' || v_loan_id || ', Customer: ' || v_name || ', EMI: ₹' || v_emi);

        EXCEPTION
            WHEN OTHERS THEN
                v_err := SQLERRM;
                INSERT INTO LoanEMIErrors (LoanID, ErrorMessage, LoggedAt)
                VALUES (v_loan_id, v_err, SYSDATE);
                DBMS_OUTPUT.PUT_LINE('Error logged for Loan ID ' || v_loan_id || ': ' || v_err);
        END;
    END LOOP;
    CLOSE emi_cursor;
END;
/
