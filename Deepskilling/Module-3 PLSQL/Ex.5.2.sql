CREATE TABLE AuditLog (
    AuditID INT AUTO_INCREMENT PRIMARY KEY,
    TransactionID INT,
    Action VARCHAR(50),
    ActionDate DATETIME
);

DELIMITER //

CREATE TRIGGER LogTransaction
AFTER INSERT
ON Transactions
FOR EACH ROW
BEGIN

    INSERT INTO AuditLog(TransactionID, Action, ActionDate)
    VALUES(NEW.TransactionID, 'Transaction Inserted', NOW());

END //

DELIMITER ;

INSERT INTO Transactions
VALUES (3,1,CURDATE(),500,'Deposit');

SELECT * FROM AuditLog;