-- ============================================================
-- Exercise 3: Stored Procedures
-- Module 3 - PL/SQL Programming
-- DN 5.0 Deep Skilling - Java FSE React
-- ============================================================

-- ============================================================
-- Scenario 1: ProcessMonthlyInterest
-- Applies 1% interest to all Savings accounts
-- ============================================================
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE Accounts
    SET Balance       = Balance * 1.01,
        LastModified  = SYSDATE
    WHERE AccountType = 'Savings';

    DBMS_OUTPUT.PUT_LINE('Monthly interest (1%) applied to all Savings accounts.');
    DBMS_OUTPUT.PUT_LINE('Rows updated: ' || SQL%ROWCOUNT);
    COMMIT;
END ProcessMonthlyInterest;
/

-- Test Scenario 1
BEGIN
    ProcessMonthlyInterest;
END;
/

-- ============================================================
-- Scenario 2: UpdateEmployeeBonus
-- Adds a bonus % to all employees in a given department
-- Parameters: p_department  - target department name
--             p_bonus_pct   - bonus percentage to add (e.g. 10 = 10%)
-- ============================================================
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department IN Employees.Department%TYPE,
    p_bonus_pct  IN NUMBER
) AS
    v_count NUMBER := 0;
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_bonus_pct / 100)
    WHERE Department = p_department;

    v_count := SQL%ROWCOUNT;

    IF v_count = 0 THEN
        DBMS_OUTPUT.PUT_LINE('No employees found in department: ' || p_department);
    ELSE
        DBMS_OUTPUT.PUT_LINE('Bonus of ' || p_bonus_pct || '% applied to '
            || v_count || ' employee(s) in ' || p_department || ' department.');
    END IF;
    COMMIT;
END UpdateEmployeeBonus;
/

-- Test Scenario 2
BEGIN
    UpdateEmployeeBonus('IT', 10);
END;
/

-- ============================================================
-- Scenario 3: TransferFunds
-- Transfers amount from source account to target account
-- Validates sufficient balance before transfer
-- Parameters: p_from_account - source AccountID
--             p_to_account   - destination AccountID
--             p_amount       - amount to transfer
-- ============================================================
CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account IN Accounts.AccountID%TYPE,
    p_to_account   IN Accounts.AccountID%TYPE,
    p_amount       IN NUMBER
) AS
    v_from_balance NUMBER;
    v_from_exists  NUMBER;
    v_to_exists    NUMBER;
BEGIN
    -- Validate both accounts exist
    SELECT COUNT(*) INTO v_from_exists FROM Accounts WHERE AccountID = p_from_account;
    SELECT COUNT(*) INTO v_to_exists   FROM Accounts WHERE AccountID = p_to_account;

    IF v_from_exists = 0 THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: Source account ' || p_from_account || ' does not exist.');
        RETURN;
    END IF;

    IF v_to_exists = 0 THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: Destination account ' || p_to_account || ' does not exist.');
        RETURN;
    END IF;

    -- Check sufficient balance
    SELECT Balance INTO v_from_balance
    FROM Accounts
    WHERE AccountID = p_from_account;

    IF v_from_balance < p_amount THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: Insufficient balance. Available: $'
            || v_from_balance || ', Requested: $' || p_amount);
        RETURN;
    END IF;

    -- Debit source account
    UPDATE Accounts
    SET Balance      = Balance - p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_from_account;

    -- Credit destination account
    UPDATE Accounts
    SET Balance      = Balance + p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_to_account;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('SUCCESS: Transferred $' || p_amount
        || ' from Account ' || p_from_account
        || ' to Account '   || p_to_account);

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('ERROR: Transfer failed. ' || SQLERRM);
END TransferFunds;
/

-- Test Scenario 3
BEGIN
    TransferFunds(1, 2, 500);
END;
/
