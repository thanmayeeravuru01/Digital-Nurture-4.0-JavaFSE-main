CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    FOR acc IN (
        SELECT AccountID, Balance
        FROM Accounts
        WHERE AccountType = 'Savings'
    ) LOOP
        UPDATE Accounts
        SET Balance = acc.Balance + (acc.Balance * 0.01)
        WHERE AccountID = acc.AccountID;
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly interest applied to all Savings accounts.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error applying interest: ' || SQLERRM);
END;
/
BEGIN
    ProcessMonthlyInterest;
END;
/
SELECT * FROM Accounts;
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_dept IN VARCHAR2,
    p_bonus_percent IN NUMBER
) AS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_bonus_percent / 100)
    WHERE Department = p_dept;

    IF SQL%ROWCOUNT = 0 THEN
        DBMS_OUTPUT.PUT_LINE('No employees found in department: ' || p_dept);
    ELSE
        COMMIT;
        DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT || ' employee(s) updated in department: ' || p_dept);
    END IF;

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error updating bonus: ' || SQLERRM);
END;
/
BEGIN
    UpdateEmployeeBonus('HR', 10);  -- Adds 10% bonus to HR employees
END;
/
SELECT * FROM Employees;
CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account IN NUMBER,
    p_to_account IN NUMBER,
    p_amount IN NUMBER
) AS
BEGIN
    -- Deduct from source account
    UPDATE Accounts
    SET Balance = Balance - p_amount
    WHERE AccountID = p_from_account;

    -- Add to destination account
    UPDATE Accounts
    SET Balance = Balance + p_amount
    WHERE AccountID = p_to_account;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transfer complete.');
END;
/
BEGIN
    TransferFunds(2, 1, 100);  -- Transfer ₹100 from account 2 to 1
END;
/
SELECT * FROM Accounts;
