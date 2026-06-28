DELIMITER //

CREATE PROCEDURE TransferFunds(
    IN fromAccount INT,
    IN toAccount INT,
    IN amount DECIMAL(10,2)
)
BEGIN

    DECLARE fromBalance DECIMAL(10,2);

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

        SELECT 'Funds Transferred Successfully.' AS Message;

    ELSE

        SELECT 'Insufficient Balance.' AS Message;

    END IF;

END //

DELIMITER ;

CALL TransferFunds(2,1,200);