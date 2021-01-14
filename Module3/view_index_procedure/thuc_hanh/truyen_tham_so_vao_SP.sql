DELIMITER //
CREATE PROCEDURE get_customer_by_id(IN customer_id INT)
BEGIN
	SELECT * 
    FROM customers
    WHERE customerNumber = customer_id;
END;
// DELIMITER ;

CALL get_customer_by_id(175);

--
DELIMITER //
CREATE PROCEDURE get_customer_count_by_city(IN in_city VARCHAR(50), OUT total INT)
BEGIN
	SELECT COUNT(customerNumber)
    INTO total
    FROM customers 
    WHERE city = in_city;
END;
// DELIMITER ;

CALL get_customer_count_by_city ('Lyon',@total);
SELECT @total;