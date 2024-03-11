CREATE TABLE departments (
	id SERIAL PRIMARY KEY,
	name TEXT
);

CREATE TABLE employees (
	id SERIAL PRIMARY KEY,
	name TEXT,
	department_id INT REFERENCES departments(id)
);

INSERT INTO departments (name) VALUES 
('Отдел продаж'),
('Отдел маркетинга'),
('Отдел разработки');

INSERT INTO employees (name, department_id) VALUES 
('Иван', 1),
('Мария', 3),
('Алексей', 3),
('Елена', 1),
('Дмитрий', 3);