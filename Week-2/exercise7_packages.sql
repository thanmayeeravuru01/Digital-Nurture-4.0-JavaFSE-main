CREATE OR REPLACE PACKAGE LoanUtils AS
    FUNCTION CalculateEMI(p_amount NUMBER, p_rate NUMBER, p_years NUMBER) RETURN NUMBER;
    PROCEDURE PrintLoanSummary;
END LoanUtils;
/
CREATE OR REPLACE PACKAGE BODY LoanUtils AS

    FUNCTION CalculateEMI(p_amount NUMBER, p_rate NUMBER, p_years NUMBER) RETURN NUMBER IS
        v_emi NUMBER;
        v_r NUMBER := p_rate / (12 * 100); -- Monthly interest rate
        v_n NUMBER := p_years * 12;         -- Total months
    BEGIN
        v_emi := p_amount * v_r / (1 - POWER(1 + v_r, -v_n));
        RETURN ROUND(v_emi, 2);
    END;

    PROCEDURE PrintLoanSummary IS
        CURSOR loan_cur IS
            SELECT l.LoanID, l.LoanAmount, l.InterestRate, c.Name
            FROM Loans l
            JOIN Customers c ON l.CustomerID = c.CustomerID;

        v_loan loan_cur%ROWTYPE;
        v_emi NUMBER;
    BEGIN
        FOR v_loan IN loan_cur LOOP
            v_emi := CalculateEMI(v_loan.LoanAmount, v_loan.InterestRate, 1); -- assuming 1 year
            DBMS_OUTPUT.PUT_LINE('Loan ID: ' || v_loan.LoanID ||
                                 ', Customer: ' || v_loan.Name ||
                                 ', Amount: ' || v_loan.LoanAmount ||
                                 ', EMI: ' || v_emi);
        END LOOP;
    END;

END LoanUtils;
/
BEGIN
    LoanUtils.PrintLoanSummary;
END;
/
CREATE OR REPLACE PACKAGE EmpUtils AS
    PROCEDURE RaiseSalary(p_emp_id IN NUMBER, p_percent IN NUMBER);
    FUNCTION GetDepartmentCount(p_dept IN VARCHAR2) RETURN NUMBER;
END EmpUtils;
/
CREATE OR REPLACE PACKAGE BODY EmpUtils AS

    PROCEDURE RaiseSalary(p_emp_id IN NUMBER, p_percent IN NUMBER) IS
    BEGIN
        UPDATE Employees
        SET Salary = Salary + (Salary * p_percent / 100)
        WHERE EmployeeID = p_emp_id;

        IF SQL%ROWCOUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('Employee not found.');
        ELSE
            DBMS_OUTPUT.PUT_LINE('Salary updated successfully.');
        END IF;
        COMMIT;
    END;

    FUNCTION GetDepartmentCount(p_dept IN VARCHAR2) RETURN NUMBER IS
        v_count NUMBER;
    BEGIN
        SELECT COUNT(*) INTO v_count
        FROM Employees
        WHERE Department = p_dept;
        RETURN v_count;
    END;

END EmpUtils;
/
BEGIN
    EmpUtils.RaiseSalary(1, 15);  -- 15% raise
END;
/
DECLARE
    v_count NUMBER;
BEGIN
    v_count := EmpUtils.GetDepartmentCount('IT');
    DBMS_OUTPUT.PUT_LINE('Total in IT: ' || v_count);
END;
/
