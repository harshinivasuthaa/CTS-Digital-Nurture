DELIMITER //

CREATE PROCEDURE UpdateEmployeeSalary(
    IN empID INT,
    IN newSalary DECIMAL(10,2)
)
BEGIN

    DECLARE empCount INT;

    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SELECT 'An error occurred while updating salary.' AS Message;
    END;

    SELECT COUNT(*)
    INTO empCount
    FROM Employees
    WHERE EmployeeID = empID;

    IF empCount > 0 THEN

        UPDATE Employees
        SET Salary = newSalary
        WHERE EmployeeID = empID;

        SELECT 'Salary Updated Successfully.' AS Message;

    ELSE

        SELECT 'Employee Not Found.' AS Message;

    END IF;

END //

DELIMITER ;