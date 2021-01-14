DELIMITER //
CREATE PROCEDURE find_all_customers()
BEGIN
	SELECT *
    FROM customers;
END;
// DELIMITER ;

CALL find_all_customers();

DELIMITER //
DROP PROCEDURE IF EXISTS find_all_customers;
CREATE PROCEDURE find_all_customers()
BEGIN
	SELECT *
    FROM customers
    WHERE customerNumber = 175;
END;
// DELIMITER ;

CALL find_all_customers();
