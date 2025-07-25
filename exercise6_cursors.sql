DECLARE
    CURSOR loan_cursor IS
        SELECT c.Name, l.LoanAmount, l.InterestRate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID;

    v_name Customers.Name%TYPE;
    v_amount Loans.LoanAmount%TYPE;
    v_rate Loans.InterestRate%TYPE;
BEGIN
    OPEN loan_cursor;
    LOOP
        FETCH loan_cursor INTO v_name, v_amount, v_rate;
        EXIT WHEN loan_cursor%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE('Customer: ' || v_name ||
                             ', Loan: ' || v_amount ||
                             ', Interest: ' || v_rate || '%');
    END LOOP;
    CLOSE loan_cursor;
END;
/
DECLARE
    CURSOR high_interest_cursor IS
        SELECT l.LoanID, c.Name, l.InterestRate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.InterestRate > 5;

    v_loan_id Loans.LoanID%TYPE;
    v_name Customers.Name%TYPE;
    v_rate Loans.InterestRate%TYPE;
BEGIN
    OPEN high_interest_cursor;
    LOOP
        FETCH high_interest_cursor INTO v_loan_id, v_name, v_rate;
        EXIT WHEN high_interest_cursor%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE('Loan ID: ' || v_loan_id || 
                             ', Customer: ' || v_name || 
                             ', Interest Rate: ' || v_rate || '%');
    END LOOP;
    CLOSE high_interest_cursor;
END;
/
DECLARE
    CURSOR loan_cursor IS
        SELECT l.LoanID, c.Name, l.LoanAmount, l.InterestRate, l.StartDate, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID;

    v_loan_id Loans.LoanID%TYPE;
    v_name Customers.Name%TYPE;
    v_amount Loans.LoanAmount%TYPE;
    v_rate Loans.InterestRate%TYPE;
    v_start_date Loans.StartDate%TYPE;
    v_end_date Loans.EndDate%TYPE;
    v_months NUMBER;
    v_emi NUMBER;
BEGIN
    OPEN loan_cursor;
    LOOP
        FETCH loan_cursor INTO v_loan_id, v_name, v_amount, v_rate, v_start_date, v_end_date;
        EXIT WHEN loan_cursor%NOTFOUND;

        -- Calculate number of months between start and end date
        v_months := MONTHS_BETWEEN(v_end_date, v_start_date);

        -- EMI formula: [P x R x (1+R)^N] / [(1+R)^N - 1]
        -- R = annual interest rate / 12 / 100
        -- N = number of months

        IF v_months > 0 THEN
            DECLARE
                r NUMBER := v_rate / 12 / 100;
            BEGIN
                v_emi := (v_amount * r * POWER(1 + r, v_months)) / (POWER(1 + r, v_months) - 1);
                DBMS_OUTPUT.PUT_LINE('Loan ID: ' || v_loan_id || ', Customer: ' || v_name || 
                                     ', Amount: ' || v_amount || ', EMI: ' || ROUND(v_emi, 2));
            END;
        ELSE
            DBMS_OUTPUT.PUT_LINE('Loan ID: ' || v_loan_id || ', Invalid loan duration.');
        END IF;

    END LOOP;
    CLOSE loan_cursor;
END;
/
