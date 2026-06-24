-- Scenario 1: Process monthly interest for all savings accounts

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE Accounts
    SET Balance      = Balance * 1.01,
        LastModified = SYSDATE
    WHERE AccountType = 'Savings';
    DBMS_OUTPUT.PUT_LINE('Monthly interest applied. Rows updated: ' || SQL%ROWCOUNT);
    COMMIT;
END ProcessMonthlyInterest;
/

BEGIN
    ProcessMonthlyInterest;
END;
/

-- Scenario 2: Update employee bonus based on department and percentage

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department IN Employees.Department%TYPE,
    p_bonus_pct  IN NUMBER
) AS
    v_count NUMBER;
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_bonus_pct / 100)
    WHERE Department = p_department;
    v_count := SQL%ROWCOUNT;
    IF v_count = 0 THEN
        DBMS_OUTPUT.PUT_LINE('No employees found in department: ' || p_department);
    ELSE
        DBMS_OUTPUT.PUT_LINE(v_count || ' employee(s) in ' || p_department || ' received ' || p_bonus_pct || '% bonus.');
    END IF;
    COMMIT;
END UpdateEmployeeBonus;
/

BEGIN
    UpdateEmployeeBonus('IT', 10);
END;
/

-- Scenario 3: Transfer funds between two accounts

CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account IN Accounts.AccountID%TYPE,
    p_to_account   IN Accounts.AccountID%TYPE,
    p_amount       IN NUMBER
) AS
    v_balance     NUMBER;
    v_from_exists NUMBER;
    v_to_exists   NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_from_exists FROM Accounts WHERE AccountID = p_from_account;
    SELECT COUNT(*) INTO v_to_exists   FROM Accounts WHERE AccountID = p_to_account;

    IF v_from_exists = 0 THEN
        DBMS_OUTPUT.PUT_LINE('Source account not found: ' || p_from_account);
        RETURN;
    END IF;

    IF v_to_exists = 0 THEN
        DBMS_OUTPUT.PUT_LINE('Destination account not found: ' || p_to_account);
        RETURN;
    END IF;

    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_from_account;

    IF v_balance < p_amount THEN
        DBMS_OUTPUT.PUT_LINE('Insufficient balance. Available: ' || v_balance || ', Requested: ' || p_amount);
        RETURN;
    END IF;

    UPDATE Accounts SET Balance = Balance - p_amount, LastModified = SYSDATE WHERE AccountID = p_from_account;
    UPDATE Accounts SET Balance = Balance + p_amount, LastModified = SYSDATE WHERE AccountID = p_to_account;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transfer successful: ' || p_amount || ' from Account ' || p_from_account || ' to Account ' || p_to_account);
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
END TransferFunds;
/

BEGIN
    TransferFunds(1, 2, 500);
END;
/
