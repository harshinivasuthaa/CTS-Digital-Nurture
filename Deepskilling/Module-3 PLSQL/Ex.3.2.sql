DELIMITER //

CREATE PROCEDURE UpdateEmployeeBonus(
    IN deptName VARCHAR(50),
    IN bonusPercent DECIMAL(5,2)
)
BEGIN

    UPDATE Employees
    SET Salary = Salary + (Salary * bonusPercent / 100)
    WHERE Department = deptName;

    SELECT 'Employee Bonus Updated Successfully.' AS Message;

END //

DELIMITER ;

CALL UpdateEmployeeBonus('IT',10);