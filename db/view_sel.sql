CREATE VIEW show_students_with_pushkins_books_sorted_by_desc
AS
SELECT s.name AS Студент, COUNT(a.name) AS "Количество книг Пушкина"
FROM students AS s
JOIN orders o ON s.id = o.student_id
JOIN books b ON o.book_id = b.id
JOIN authors a ON b.author_id = a.id
WHERE a.name LIKE '%Пушкин'
GROUP BY s.name
ORDER BY COUNT(a.name) DESC;

SELECT * FROM show_students_with_pushkins_books_sorted_by_desc;