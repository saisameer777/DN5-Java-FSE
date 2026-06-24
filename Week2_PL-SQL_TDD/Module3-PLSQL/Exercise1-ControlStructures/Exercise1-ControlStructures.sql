-- ============================================================
-- Exercise 1: Control Structures
-- Module 3 - PL/SQL Programming
-- DN 5.0 Deep Skilling - Java FSE React
-- ============================================================

-- SCHEMA (run once before executing the exercises)
-- CREATE TABLE Customers (
--     CustomerID NUMBER PRIMARY KEY,
--     Name VARCHAR2(100),
--     DOB DATE,
--     Balance NUMBER,
--     LastModified DATE
-- );
-- CREATE TABLE Loans (
--     LoanID NUMBER PRIMARY KEY,
--     CustomerID NUMBER,
--     LoanAmount NUMBER,
--     InterestRate NUMBER,
--     StartDate DATE,
--     EndDate DATE,
--     FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
-- );

-- ============================================================
-- Scenario 1: Apply 1% discount on loan interest rates
--             for customers above 60 years old.
-- ============================================================
DECLARE
    CURSOR c_customers IS
        SELECT CustomerID, DOB FROM Customers;
    v_age NUMBER;
BEGIN
    FOR rec IN c_customers LOOP
        -- Calculate age in years
        v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12);

        IF v_age > 60 THEN
            -- Apply 1% discount to all loans of this customer
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = rec.CustomerID
              AND InterestRate > 1; -- prevent negative rates

            DBMS_OUTPUT.PUT_LINE('Applied 1% discount for CustomerID: '
                || rec.CustomerID || ' (Age: ' || v_age || ')');
        END IF;
    END LOOP;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Scenario 1 complete: Loan discount applied.');
END;
/

-- ============================================================
-- Scenario 2: Set IsVIP = TRUE for customers with balance > $10,000
-- NOTE: Add IsVIP column first if not present:
--       ALTER TABLE Customers ADD IsVIP VARCHAR2(5) DEFAULT 'FALSE';
-- ============================================================
DECLARE
    CURSOR c_customers IS
        SELECT CustomerID, Balance FROM Customers;
BEGIN
    FOR rec IN c_customers LOOP
        IF rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE('CustomerID ' || rec.CustomerID
                || ' promoted to VIP. Balance: $' || rec.Balance);
        ELSE
            UPDATE Customers
            SET IsVIP = 'FALSE'
            WHERE CustomerID = rec.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Scenario 2 complete: VIP status updated.');
END;
/

-- ============================================================
-- Scenario 3: Send reminders for loans due within the next 30 days
-- ============================================================
DECLARE
    CURSOR c_loans IS
        SELECT l.LoanID, l.CustomerID, l.EndDate, c.Name
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    FOR rec IN c_loans LOOP
        DBMS_OUTPUT.PUT_LINE('REMINDER: Dear ' || rec.Name
            || ' (CustomerID: ' || rec.CustomerID || '), '
            || 'your LoanID ' || rec.LoanID
            || ' is due on ' || TO_CHAR(rec.EndDate, 'DD-MON-YYYY')
            || '. Please ensure timely payment.');
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('Scenario 3 complete: Reminders sent.');
END;
/
