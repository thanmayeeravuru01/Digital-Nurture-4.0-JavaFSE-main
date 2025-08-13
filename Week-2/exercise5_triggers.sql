CREATE TABLE AccountAudit (
    AuditID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    AccountID NUMBER,
    OldBalance NUMBER,
    NewBalance NUMBER,
    ModifiedDate DATE
);
CREATE OR REPLACE TRIGGER TrackAccountChanges
BEFORE UPDATE OF Balance ON Accounts
FOR EACH ROW
BEGIN
    INSERT INTO AccountAudit (AccountID, OldBalance, NewBalance, ModifiedDate)
    VALUES (:OLD.AccountID, :OLD.Balance, :NEW.Balance, SYSDATE);
END;
/
UPDATE Accounts
SET Balance = Balance + 500
WHERE AccountID = 1;
SELECT * FROM AccountAudit;
CREATE OR REPLACE TRIGGER PreventNegativeBalance
BEFORE INSERT OR UPDATE OF Balance ON Accounts
FOR EACH ROW
BEGIN
    IF :NEW.Balance < 0 THEN
        RAISE_APPLICATION_ERROR(-20010, 'Balance cannot be negative.');
    END IF;
END;
/
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (3, 1, 'Savings', -1000, SYSDATE);
UPDATE Accounts
SET Balance = -500
WHERE AccountID = 1;
CREATE TABLE SalaryAudit (
    AuditID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    EmployeeID NUMBER,
    OldSalary NUMBER,
    NewSalary NUMBER,
    ChangeDate DATE
);
CREATE OR REPLACE TRIGGER LogSalaryChanges
AFTER UPDATE OF Salary ON Employees
FOR EACH ROW
BEGIN
    INSERT INTO SalaryAudit (EmployeeID, OldSalary, NewSalary, ChangeDate)
    VALUES (:OLD.EmployeeID, :OLD.Salary, :NEW.Salary, SYSDATE);
END;
/
UPDATE Employees
SET Salary = Salary + 5000
WHERE EmployeeID = 1;
SELECT * FROM SalaryAudit;
