DELIMITER //

CREATE PROCEDURE AddCustomer(
    IN cID INT,
    IN cName VARCHAR(100),
    IN cDOB DATE,
    IN cBalance DECIMAL(10,2)
)
BEGIN

    DECLARE customerCount INT;

    SELECT COUNT(*)
    INTO customerCount
    FROM Customers
    WHERE CustomerID = cID;

    IF customerCount = 0 THEN

        INSERT INTO Customers(CustomerID, Name, DOB, Balance)
        VALUES(cID, cName, cDOB, cBalance);

        SELECT 'Customer Added Successfully.' AS Message;

    ELSE

        SELECT 'Customer ID Already Exists.' AS Message;

    END IF;

END //

DELIMITER ;

