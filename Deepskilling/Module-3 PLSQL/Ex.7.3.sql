CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE open_account(
        p_account_id  NUMBER,
        p_customer_id NUMBER,
        p_balance     NUMBER
    );

    PROCEDURE close_account(
        p_account_id NUMBER
    );

    FUNCTION total_balance(
        p_customer_id NUMBER
    ) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    PROCEDURE open_account(
        p_account_id  NUMBER,
        p_customer_id NUMBER,
        p_balance     NUMBER
    ) IS
    BEGIN
        INSERT INTO accounts VALUES (p_account_id, p_customer_id, p_balance, 'OPEN');
    END open_account;

    PROCEDURE close_account(
        p_account_id NUMBER
    ) IS
    BEGIN
        UPDATE accounts
        SET status = 'CLOSED'
        WHERE account_id = p_account_id;
    END close_account;

    FUNCTION total_balance(
        p_customer_id NUMBER
    ) RETURN NUMBER IS
        v_total NUMBER;
    BEGIN
        SELECT NVL(SUM(balance), 0)
        INTO v_total
        FROM accounts
        WHERE customer_id = p_customer_id
          AND status = 'OPEN';

        RETURN v_total;
    END total_balance;

END AccountOperations;
/