CREATE TABLE fauna (
    id             SERIAL PRIMARY KEY,
    name           TEXT,
    avg_age        INT,
    discovery_date DATE
);

INSERT INTO fauna (name, avg_age, discovery_date) VALUES
('Lion', 4380, '1920-01-15'),
('Tiger', 5475, '1925-07-23'),
('fish', 1800, null),
('Elephant', 14600, '1930-11-30'),
('Cheetah', 2920, '1940-03-05'),
('Giraffe', 9125, '1955-09-10');

SELECT * FROM fauna WHERE name LIKE '%fish%';
SELECT * FROM fauna WHERE avg_age >= 10000 AND avg_age <= 21000;
SELECT * FROM fauna WHERE discovery_date IS NULL;
SELECT * FROM fauna WHERE discovery_date < '1950-01-01';

