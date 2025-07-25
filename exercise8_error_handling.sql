CREATE OR REPLACE FUNCTION SafeDivide (
    p_numerator IN NUMBER,
    p_denominator IN NUMBER
) RETURN NUMBER
IS
    v_result NUMBER;
BEGIN
    v_result := p_numerator / p_denominator;
    RETURN v_result;
EXCEPTION
    WHEN ZERO_DIVIDE THEN
        DBMS_OUTPUT.PUT_LINE('Error: Division by zero.');
        RETURN NULL;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
        RETURN NULL;
END;
/
BEGIN
    DBMS_OUTPUT.PUT_LINE('10 / 2 = ' || SafeDivide(10, 2));
    DBMS_OUTPUT.PUT_LINE('10 / 0 = ' || SafeDivide(10, 0));
END;
/
CREATE TABLE ErrorLogs (
    LogID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    ErrorMessage VARCHAR2(400),
    LoggedAt DATE
);
CREATE OR REPLACE PROCEDURE DoRiskyOperation AS
    v_result NUMBER;
    v_error_message VARCHAR2(400);
BEGIN
    v_result := 10 / 0;  -- Risky operation
    DBMS_OUTPUT.PUT_LINE('Result: ' || v_result);
EXCEPTION
    WHEN OTHERS THEN
        v_error_message := SQLERRM;
        INSERT INTO ErrorLogs (ErrorMessage, LoggedAt)
        VALUES (v_error_message, SYSDATE);
        DBMS_OUTPUT.PUT_LINE('An error occurred and was logged.');
END;
/
BEGIN
    DoRiskyOperation;
END;
/
SELECT * FROM ErrorLogs;
