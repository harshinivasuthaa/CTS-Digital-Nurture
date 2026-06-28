DELIMITER //

CREATE PROCEDURE ApplyAnnualFee()
BEGIN

    DECLARE done INT DEFAULT FALSE;
    DECLARE acc_id INT;

    DECLARE account_cursor CURSOR FOR
        SELECT AccountID
        FROM Accounts;

    DECLARE CONTINUE HANDLER FOR NOT FOUND
        SET done = TRUE;

    OPEN account_cursor;

    read_loop: LOOP

        FETCH account_cursor
        INTO acc_id;

        IF done THEN
            LEAVE read_loop;
        END IF;

        UPDATE Accounts
        SET Balance = Balance - 100
        WHERE AccountID = acc_id;

    END LOOP;

    CLOSE account_cursor;

    SELECT 'Annual Fee Applied Successfully.' AS Message;

END //

DELIMITER ;

CALL ApplyAnnualFee();