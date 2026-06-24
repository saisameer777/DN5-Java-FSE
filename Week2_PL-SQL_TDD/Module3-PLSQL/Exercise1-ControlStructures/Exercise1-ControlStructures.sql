-- Scenario 1: Apply 1% discount on loan interest rate for customers above 60 years old

DECLARE
    CURSOR c_customers IS
        SELECT CustomerID, DOB FROM Customers;
    v_age NUMBER;
BEGIN
    FOR rec IN c_customers LOOP
        v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12);
        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = rec.CustomerID
              AND InterestRate > 1;
            DBMS_OUTPUT.PUT_LINE('Discount applied for CustomerID: ' || rec.CustomerID || ', Age: ' || v_age);
        END IF;
    END LOOP;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Loan interest discount process completed.');
END;
/

-- Scenario 2: Promote customers to VIP if balance exceeds $10,000

DECLARE
    CURSOR c_customers IS
        SELECT CustomerID, Balance FROM Customers;
BEGIN
    FOR rec IN c_customers LOOP
        IF rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = rec.CustomerID;
            DBMS_OUTPUT.PUT_LINE('CustomerID ' || rec.CustomerID || ' marked as VIP.');
        ELSE
            UPDATE Customers
            SET IsVIP = 'FALSE'
            WHERE CustomerID = rec.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('VIP status update completed.');
END;
/

-- Scenario 3: Print reminders for loans due within the next 30 days

DECLARE
    CURSOR c_loans IS
        SELECT l.LoanID, l.CustomerID, l.EndDate, c.Name
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    FOR rec IN c_loans LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: ' || rec.Name || ', your loan (ID: ' || rec.LoanID
            || ') is due on ' || TO_CHAR(rec.EndDate, 'DD-MON-YYYY') || '. Please pay on time.');
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('Loan reminder process completed.');
END;
/
