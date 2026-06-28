DELIMITER //

CREATE PROCEDURE ApplySeniorCitizenDiscount()
BEGIN

    DECLARE done INT DEFAULT FALSE;
    DECLARE c_id INT;
    DECLARE c_dob DATE;
    DECLARE age INT;

    DECLARE customer_cursor CURSOR FOR
        SELECT CustomerID, DOB
        FROM Customers;

    DECLARE CONTINUE HANDLER FOR NOT FOUND
        SET done = TRUE;

    OPEN customer_cursor;

    read_loop: LOOP

        FETCH customer_cursor INTO c_id, c_dob;

        IF done THEN
            LEAVE read_loop;
        END IF;

        SET age = TIMESTAMPDIFF(YEAR, c_dob, CURDATE());

        IF age > 60 THEN

            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = c_id;

        END IF;

    END LOOP;

    CLOSE customer_cursor;

END //

DELIMITER ;

CALL ApplySeniorCitizenDiscount();
SELECT * FROM Loans;