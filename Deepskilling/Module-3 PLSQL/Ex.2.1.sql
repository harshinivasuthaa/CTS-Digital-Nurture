DELIMITER //

CREATE PROCEDURE SafeTransferFunds(
    IN fromAccount INT,
    IN toAccount INT,
    IN amount DECIMAL(10,2)
)
BEGIN

    DECLARE fromBalance DECIMAL(10,2);

    START TRANSACTION;

    SELECT Balance
    INTO fromBalance
    FROM Accounts
    WHERE AccountID = fromAccount;

    IF fromBalance >= amount THEN

        UPDATE Accounts
        SET Balance = Balance - amount
        WHERE AccountID = fromAccount;

        UPDATE Accounts
        SET Balance = Balance + amount
        WHERE AccountID = toAccount;

        COMMIT;

        SELECT 'Transfer Successful' AS Message;

    ELSE

        ROLLBACK;

        SELECT 'Insufficient Balance. Transfer Failed.' AS Message;

    END IF;

END //

DELIMITER ;

CALL SafeTransferFunds(1,2,100);


