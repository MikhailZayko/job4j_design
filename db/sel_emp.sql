SELECT *
FROM employees e
LEFT JOIN departments d
ON e.department_id = d.id;

SELECT *
FROM employees e
RIGHT JOIN departments d
ON e.department_id = d.id;

SELECT *
FROM employees e
FULL JOIN departments d
ON e.department_id = d.id;

SELECT *
FROM employees e
CROSS JOIN departments d;

SELECT d.name AS "Департамент без работников"
FROM departments d
LEFT JOIN employees e
ON e.department_id = d.id
WHERE e.id IS NULL;

SELECT *
FROM employees e
LEFT JOIN departments d
ON e.department_id = d.id;

SELECT e.*, d.*
FROM departments d
RIGHT JOIN employees e
ON e.department_id = d.id;