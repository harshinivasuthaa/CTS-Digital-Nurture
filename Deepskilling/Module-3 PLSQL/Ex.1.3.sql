DELIMITER //

CREATE PROCEDURE LoanReminder()
BEGIN

    DECLARE done INT DEFAULT FALSE;
    DECLARE c_name VARCHAR(100);
    DECLARE l_id INT;
    DECLARE due_date DATE;

    DECLARE loan_cursor CURSOR FOR
    SELECT C.Name, L.LoanID, L.EndDate
    FROM Customers C
    JOIN Loans L
    ON C.CustomerID = L.CustomerID;

    DECLARE CONTINUE HANDLER FOR NOT FOUND
    SET done = TRUE;

    OPEN loan_cursor;

    read_loop: LOOP

        FETCH loan_cursor
        INTO c_name, l_id, due_date;

        IF done THEN
            LEAVE read_loop;
        END IF;

        IF due_date BETWEEN CURDATE()
        AND DATE_ADD(CURDATE(), INTERVAL 30 DAY) THEN

            SELECT CONCAT(
            'Reminder: Loan ',
            l_id,
            ' for ',
            c_name,
            ' is due on ',
            due_date
            ) AS Message;

        END IF;

    END LOOP;

    CLOSE loan_cursor;

END //

DELIMITER ;

CALL LoanReminder();