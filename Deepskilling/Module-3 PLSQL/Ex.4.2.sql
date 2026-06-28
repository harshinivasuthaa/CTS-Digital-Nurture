DELIMITER //

CREATE FUNCTION CalculateMonthlyInstallment(
    loanAmount DECIMAL(10,2),
    interestRate DECIMAL(5,2),
    years INT
)
RETURNS DECIMAL(10,2)
DETERMINISTIC

BEGIN

    DECLARE installment DECIMAL(10,2);

    SET installment =
    (loanAmount + (loanAmount * interestRate / 100))
    / (years * 12);
    RETURN installment;
END //

DELIMITER ;

SELECT CalculateMonthlyInstallment(5000,5,5) AS MonthlyInstallment;