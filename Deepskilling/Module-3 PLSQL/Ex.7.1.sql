CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE add_customer(
        p_customer_id NUMBER,
        p_name        VARCHAR2,
        p_address     VARCHAR2,
        p_balance     NUMBER
    );

    PROCEDURE update_customer(
        p_customer_id NUMBER,
        p_name        VARCHAR2,
        p_address     VARCHAR2
    );

    FUNCTION get_balance(
        p_customer_id NUMBER
    ) RETURN NUMBER;
END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    PROCEDURE add_customer(
        p_customer_id NUMBER,
        p_name        VARCHAR2,
        p_address     VARCHAR2,
        p_balance     NUMBER
    ) IS
    BEGIN
        INSERT INTO customers VALUES (p_customer_id, p_name, p_address, p_balance);
    END add_customer;

    PROCEDURE update_customer(
        p_customer_id NUMBER,
        p_name        VARCHAR2,
        p_address     VARCHAR2
    ) IS
    BEGIN
        UPDATE customers
        SET name = p_name,
            address = p_address
        WHERE customer_id = p_customer_id;
    END update_customer;

    FUNCTION get_balance(
        p_customer_id NUMBER
    ) RETURN NUMBER IS
        v_balance NUMBER;
    BEGIN
        SELECT balance
        INTO v_balance
        FROM customers
        WHERE customer_id = p_customer_id;

        RETURN v_balance;
    END get_balance;

END CustomerManagement;
/