SELECT p.name person_name, c.name company_name
FROM person p
LEFT JOIN company c ON p.company_id = c.id
WHERE c.id != 5 OR p.company_id IS NULL;

