CREATE TABLE students (
	id SERIAL PRIMARY KEY,
	name TEXT,
	course INT,
	grade FLOAT
);

INSERT INTO students (name, course, grade) VALUES
('Ivan', 2, 4.6),
('Petr', 3, 3.4),
('Anna', 1, 4.9);