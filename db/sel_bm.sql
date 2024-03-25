SELECT name AS "Фильмы по книге"
FROM movie
INTERSECT
SELECT title
FROM book;

SELECT title AS "Книги без экранизации"
FROM book
EXCEPT
SELECT name
FROM movie;

SELECT name AS "Уникальные произведения"
FROM movie
EXCEPT
SELECT title
FROM book
UNION ALL
(SELECT title
FROM book
EXCEPT
SELECT name
FROM movie);