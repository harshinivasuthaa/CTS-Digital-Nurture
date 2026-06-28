ALTER TABLE Customers
ADD IsVIP BOOLEAN DEFAULT FALSE;

DELIMITER //

CREATE PROCEDURE UpdateVIPCustomers()
BEGIN

    DECLARE done INT DEFAULT FALSE;
    DECLARE c_id INT;
    DECLARE bal DECIMAL(10,2);

    DECLARE customer_cursor CURSOR FOR
        SELECT CustomerID, Balance
        FROM Customers;

    DECLARE CONTINUE HANDLER FOR NOT FOUND
        SET done = TRUE;

    OPEN customer_cursor;

    read_loop: LOOP

        FETCH customer_cursor INTO c_id, bal;

        IF done THEN
            LEAVE read_loop;
        END IF;

        IF bal > 10000 THEN

            UPDATE Customers
            SET IsVIP = TRUE
            WHERE CustomerID = c_id;

        END IF;

    END LOOP;

    CLOSE customer_cursor;

END //

DELIMITER ;

CALL UpdateVIPCustomers();