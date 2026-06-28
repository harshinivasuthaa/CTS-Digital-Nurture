DELIMITER //

CREATE PROCEDURE GenerateMonthlyStatements()
BEGIN

    DECLARE done INT DEFAULT FALSE;
    DECLARE t_id INT;
    DECLARE acc_id INT;
    DECLARE t_amount DECIMAL(10,2);
    DECLARE t_type VARCHAR(20);

    DECLARE trans_cursor CURSOR FOR
        SELECT TransactionID, AccountID, Amount, TransactionType
        FROM Transactions
        WHERE MONTH(TransactionDate) = MONTH(CURDATE())
        AND YEAR(TransactionDate) = YEAR(CURDATE());

    DECLARE CONTINUE HANDLER FOR NOT FOUND
        SET done = TRUE;

    OPEN trans_cursor;

    read_loop: LOOP

        FETCH trans_cursor
        INTO t_id, acc_id, t_amount, t_type;

        IF done THEN
            LEAVE read_loop;
        END IF;

        SELECT CONCAT(
            'Transaction ID: ', t_id,
            ', Account: ', acc_id,
            ', Amount: ', t_amount,
            ', Type: ', t_type
        ) AS Statement;

    END LOOP;

    CLOSE trans_cursor;
    
END //

DELIMITER ;

CALL GenerateMonthlyStatements();