CREATE TABLE record_book (
	id SERIAL PRIMARY KEY,
	average_mark FLOAT4
);

CREATE TABLE students (
	id SERIAL PRIMARY KEY,
	name TEXT,
	course INT,
	record_book_id INT REFERENCES record_book(id) UNIQUE
);

INSERT INTO record_book(average_mark) VALUES
(4.5),
(3.7),
(4.1);

INSERT INTO students(name, course, record_book_id) VALUES
('Ivan', 3, 1),
('Anna', 2, 2),
('Petr', 1, 3);

SELECT st.name, st.course, rb.average_mark
FROM students AS st JOIN record_book AS rb ON st.record_book_id = rb.id;

SELECT st.name AS Имя, st.course AS Курс, rb.average_mark AS Оценка
FROM students AS st JOIN record_book AS rb ON st.record_book_id = rb.id;

SELECT st.name AS "Имя студента", st.course Курс, rb.average_mark AS "Средняя оценка"
FROM students st JOIN record_book rb ON st.record_book_id = rb.id;
