SELECT first_name, last_name, age
FROM customers
WHERE age = (SELECT MIN(age) FROM customers);

SELECT * 
FROM customers c
WHERE c.id NOT IN (SELECT o.customer_id FROM orders o);