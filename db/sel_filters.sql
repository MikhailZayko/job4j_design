SELECT p.name, expired_date, p.price, t.name тип
FROM product p
JOIN type t
ON p.type_id = t.id
WHERE t.name = 'СЫР';

SELECT *
FROM product
WHERE name LIKE '%мороженое%';

SELECT *
FROM product
WHERE expired_date <= '2024-03-11';

SELECT name, expired_date, price
FROM product
WHERE price = (SELECT MAX(price) FROM product);

SELECT t.name AS "Имя типа", COUNT(p.*) количество
FROM product p
JOIN type t
ON p.type_id = t.id
GROUP BY t.name;

SELECT p.name, expired_date, p.price, t.name тип
FROM product p
JOIN type t
ON p.type_id = t.id
WHERE t.name = 'СЫР' OR t.name = 'МОЛОКО';

SELECT t.name AS "Тип продуктов", COUNT(p.*) количество
FROM product p
JOIN type t
ON p.type_id = t.id
GROUP BY t.name
HAVING COUNT(p.*) < 10;

SELECT p.*, t.name тип
FROM product p
JOIN type t
ON p.type_id = t.id;