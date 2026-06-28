DELIMITER //

CREATE TRIGGER CheckTransactionRules
BEFORE INSERT
ON Transactions
FOR EACH ROW
BEGIN

    DECLARE bal DECIMAL(10,2);

    SELECT Balance
    INTO bal
    FROM Accounts
    WHERE AccountID = NEW.AccountID;

    IF NEW.TransactionType = 'Withdrawal'
       AND NEW.Amount > bal THEN

        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Insufficient Balance';

    END IF;

    IF NEW.TransactionType = 'Deposit'
       AND NEW.Amount <= 0 THEN

        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Deposit Amount Must Be Positive';

    END IF;

END //

DELIMITER ;

INSERT INTO Transactions
VALUES (4,1,CURDATE(),500,'Deposit');

INSERT INTO Transactions
VALUES (5,1,CURDATE(),-500,'Deposit');