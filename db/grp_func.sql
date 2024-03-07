CREATE TABLE devices
(
    id    SERIAL PRIMARY KEY,
    name  VARCHAR(255),
    price FLOAT
);

CREATE TABLE people
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE devices_people
(
    id        SERIAL PRIMARY KEY,
    device_id INT REFERENCES devices (id),
    people_id INT REFERENCES people (id)
);

INSERT INTO devices (name, price) VALUES 
('Смартфон', 4000.99),
('Ноутбук', 6000.99),
('Планшет', 3000.99);

INSERT INTO people (name) VALUES 
('Иван'),
('Мария'),
('Петр');

INSERT INTO devices_people (device_id, people_id) VALUES 
(1, 1),
(3, 1),
(2, 2),
(3, 2),
(1, 3),
(2, 3);

SELECT AVG(price) AS "Средняя цена всех устройств" FROM devices;

SELECT p.name Имя, AVG(d.price) AS "Средняя цена утройств"
FROM people p
JOIN devices_people dp
ON p.id = dp.people_id
JOIN devices d
ON d.id = dp.device_id
GROUP BY p.name;

SELECT p.name Имя, AVG(d.price) AS "Средняя цена утройств"
FROM people p
JOIN devices_people dp
ON p.id = dp.people_id
JOIN devices d
ON d.id = dp.device_id
GROUP BY p.name
HAVING AVG(d.price) > 5000;