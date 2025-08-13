
-- Scenario 1: Print Loan Info
BEGIN
    FOR rec IN (
        SELECT c.Name, l.LoanAmount, l.InterestRate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
    )
    LOOP
        DBMS_OUTPUT.PUT_LINE('Customer: ' || rec.Name ||
                             ', Loan: ' || rec.LoanAmount ||
                             ', Interest: ' || rec.InterestRate || '%');
    END LOOP;
END;
/

-- Scenario 2: Calculate EMI for Each Loan
DECLARE
    CURSOR emi_cursor IS
        SELECT l.LoanID, c.Name, l.LoanAmount, l.InterestRate, l.StartDate, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID;

    v_loan_id   Loans.LoanID%TYPE;
    v_name      Customers.Name%TYPE;
    v_amount    Loans.LoanAmount%TYPE;
    v_rate      Loans.InterestRate%TYPE;
    v_start     Loans.StartDate%TYPE;
    v_end       Loans.EndDate%TYPE;
    v_months    NUMBER;
    v_emi       NUMBER;
BEGIN
    OPEN emi_cursor;
    LOOP
        FETCH emi_cursor INTO v_loan_id, v_name, v_amount, v_rate, v_start, v_end;
        EXIT WHEN emi_cursor%NOTFOUND;

        v_months := TRUNC(MONTHS_BETWEEN(v_end, v_start));

        IF v_months = 0 THEN
            DBMS_OUTPUT.PUT_LINE('Loan ID: ' || v_loan_id || ', Customer: ' || v_name || ' has zero duration. EMI cannot be calculated.');
        ELSE
            v_emi := ROUND((v_amount + (v_amount * v_rate * v_months / 1200)) / v_months, 2);
            DBMS_OUTPUT.PUT_LINE('Loan ID: ' || v_loan_id || 
                                 ', Customer: ' || v_name || 
                                 ', Amount: ' || v_amount || 
                                 ', EMI: ' || v_emi);
        END IF;
    END LOOP;
    CLOSE emi_cursor;
END;
/

-- Scenario 3: Raise error if EMI exceeds ₹10,000
DECLARE
    CURSOR emi_cursor IS
        SELECT l.LoanID, c.Name, l.LoanAmount, l.InterestRate, l.StartDate, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID;

    v_loan_id   Loans.LoanID%TYPE;
    v_name      Customers.Name%TYPE;
    v_amount    Loans.LoanAmount%TYPE;
    v_rate      Loans.InterestRate%TYPE;
    v_start     Loans.StartDate%TYPE;
    v_end       Loans.EndDate%TYPE;
    v_months    NUMBER;
    v_emi       NUMBER;
BEGIN
    OPEN emi_cursor;
    LOOP
        FETCH emi_cursor INTO v_loan_id, v_name, v_amount, v_rate, v_start, v_end;
        EXIT WHEN emi_cursor%NOTFOUND;

        v_months := TRUNC(MONTHS_BETWEEN(v_end, v_start));

        IF v_months = 0 THEN
            DBMS_OUTPUT.PUT_LINE('Loan ID: ' || v_loan_id || ', Customer: ' || v_name || ' has zero duration. EMI cannot be calculated.');
        ELSE
            v_emi := ROUND((v_amount + (v_amount * v_rate * v_months / 1200)) / v_months, 2);

            IF v_emi > 10000 THEN
                RAISE_APPLICATION_ERROR(-20005, 'Loan ID: ' || v_loan_id || ' has EMI ' || v_emi || ' which exceeds ₹10,000 limit.');
            END IF;

            DBMS_OUTPUT.PUT_LINE('Loan ID: ' || v_loan_id || 
                                 ', Customer: ' || v_name || 
                                 ', Amount: ' || v_amount || 
                                 ', EMI: ' || v_emi);
        END IF;
    END LOOP;
    CLOSE emi_cursor;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/
