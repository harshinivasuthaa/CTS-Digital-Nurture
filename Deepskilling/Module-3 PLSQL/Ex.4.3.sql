DELIMITER //

CREATE FUNCTION HasSufficientBalance(
    accID INT,
    amount DECIMAL(10,2)
)
RETURNS BOOLEAN
DETERMINISTIC

BEGIN

    DECLARE bal DECIMAL(10,2);

    SELECT Balance
    INTO bal
    FROM Accounts
    WHERE AccountID = accID;

    IF bal >= amount THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;

END //

DELIMITER ;

SELECT HasSufficientBalance(1,500) AS Result;