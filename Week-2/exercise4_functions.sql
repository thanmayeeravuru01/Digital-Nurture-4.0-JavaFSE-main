CREATE OR REPLACE FUNCTION CalculateAge (
    p_dob IN DATE
) RETURN NUMBER IS
    v_age NUMBER;
BEGIN
    v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
    RETURN v_age;
END;
/
SELECT Name, DOB, CalculateAge(DOB) AS Age
FROM Customers;
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_amount IN NUMBER,
    p_rate IN NUMBER,
    p_years IN NUMBER
) RETURN NUMBER IS
    v_r NUMBER := p_rate / (12 * 100);  -- Monthly rate
    v_n NUMBER := p_years * 12;         -- Total months
    v_emi NUMBER;
BEGIN
    v_emi := (p_amount * v_r * POWER(1 + v_r, v_n)) /
             (POWER(1 + v_r, v_n) - 1);

    RETURN ROUND(v_emi, 2);
END;
/
SELECT CalculateMonthlyInstallment(5000, 5, 5) AS EMI FROM dual;
CREATE OR REPLACE FUNCTION GetCustomerType (
    p_balance IN NUMBER
) RETURN VARCHAR2 IS
BEGIN
    IF p_balance > 50000 THEN
        RETURN 'Platinum';
    ELSIF p_balance > 10000 THEN
        RETURN 'Gold';
    ELSE
        RETURN 'Silver';
    END IF;
END;
/
SELECT GetCustomerType(70000) AS CustomerType FROM dual;

SELECT GetCustomerType(20000) AS CustomerType FROM dual;

SELECT GetCustomerType(5000) AS CustomerType FROM dual;
SELECT Name, Balance, GetCustomerType(Balance) AS CustomerType
FROM Customers;
