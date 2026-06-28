CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE hire_employee(
        p_emp_id NUMBER,
        p_name   VARCHAR2,
        p_salary NUMBER,
        p_bonus  NUMBER
    );

    PROCEDURE update_employee(
        p_emp_id NUMBER,
        p_name   VARCHAR2,
        p_salary NUMBER,
        p_bonus  NUMBER
    );

    FUNCTION annual_salary(
        p_emp_id NUMBER
    ) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE hire_employee(
        p_emp_id NUMBER,
        p_name   VARCHAR2,
        p_salary NUMBER,
        p_bonus  NUMBER
    ) IS
    BEGIN
        INSERT INTO employees VALUES (p_emp_id, p_name, p_salary, p_bonus);
    END hire_employee;

    PROCEDURE update_employee(
        p_emp_id NUMBER,
        p_name   VARCHAR2,
        p_salary NUMBER,
        p_bonus  NUMBER
    ) IS
    BEGIN
        UPDATE employees
        SET name = p_name,
            salary = p_salary,
            bonus = p_bonus
        WHERE emp_id = p_emp_id;
    END update_employee;

    FUNCTION annual_salary(
        p_emp_id NUMBER
    ) RETURN NUMBER IS
        v_salary NUMBER;
        v_bonus  NUMBER;
    BEGIN
        SELECT salary, bonus
        INTO v_salary, v_bonus
        FROM employees
        WHERE emp_id = p_emp_id;

        RETURN (v_salary * 12) + v_bonus;
    END annual_salary;

END EmployeeManagement;
/