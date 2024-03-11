CREATE TABLE teens (
	id SERIAL PRIMARY KEY,
	name TEXT,
	gender TEXT
);

INSERT INTO teens (name, gender) VALUES 
('Саша', 'М'),
('Петя', 'М'),
('Коля', 'М'),
('Маша', 'Ж'),
('Катя', 'Ж'),
('Саша', 'Ж');

SELECT t1.name, t2.name
FROM teens t1
CROSS JOIN teens t2
WHERE t1.gender != t2.gender AND t1.id < t2.id;