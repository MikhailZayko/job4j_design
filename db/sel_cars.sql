SELECT c.id, c.name car_name, b.name body_name, e.name engine_name, t.name transmission_name
FROM cars c
LEFT JOIN car_bodies b
ON c.body_id = b.id
LEFT JOIN car_engines e
ON c.engine_id = e.id
LEFT JOIN car_transmissions t
ON c.transmission_id = t.id;

SELECT b.name AS "Не используемые кузова"
FROM car_bodies b
LEFT JOIN cars c
ON c.body_id = b.id
WHERE c.id IS NULL;

SELECT e.name AS "Не используемые двигатели"
FROM car_engines e
LEFT JOIN cars c
ON c.engine_id = e.id
WHERE c.id IS NULL;

SELECT t.name AS "Не используемые коробки передач"
FROM car_transmissions t
LEFT JOIN cars c
ON c.transmission_id = t.id
WHERE c.id IS NULL;