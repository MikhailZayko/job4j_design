SELECT c.name company_name, COUNT(p.id) employee_count
FROM company c
JOIN person p ON c.id = p.company_id
GROUP BY c.name
HAVING COUNT(p.id) = (
    SELECT MAX(counters.emp_count)
    FROM (
        SELECT COUNT(p2.id) emp_count
        FROM person p2
		WHERE p2.company_id IS NOT NULL
        GROUP BY p2.company_id
    ) counters
);



