DELIMITER //

CREATE PROCEDURE UpdateLoanInterestRates()
BEGIN

    DECLARE done INT DEFAULT FALSE;
    DECLARE loan_id INT;

    DECLARE loan_cursor CURSOR FOR
        SELECT LoanID
        FROM Loans;

    DECLARE CONTINUE HANDLER FOR NOT FOUND
        SET done = TRUE;

    OPEN loan_cursor;

    read_loop: LOOP

        FETCH loan_cursor
        INTO loan_id;

        IF done THEN
            LEAVE read_loop;
        END IF;

        UPDATE Loans
        SET InterestRate = InterestRate + 1
        WHERE LoanID = loan_id;

    END LOOP;

    CLOSE loan_cursor;

    SELECT 'Loan Interest Rates Updated Successfully.' AS Message;

END //

DELIMITER ;

CALL UpdateLoanInterestRates();