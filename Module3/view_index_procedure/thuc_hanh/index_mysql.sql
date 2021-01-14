EXPLAIN SELECT * FROM customers WHERE customerNumber = 175;

ALTER TABLE customers 
ADD INDEX idx_full_name (contactFirstName, contactLastName);

ALTER TABLE customers
DROP INDEX idx_full_name;

EXPLAIN SELECT * FROM customers WHERE contactFirstName = 'Jean' or contactFirstName = 'King';

