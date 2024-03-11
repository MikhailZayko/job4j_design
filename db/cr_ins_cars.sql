CREATE TABLE car_bodies (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE car_engines (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE car_transmissions (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE cars (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    body_id INT REFERENCES car_bodies(id),
    engine_id INT REFERENCES car_engines(id),
    transmission_id INT REFERENCES car_transmissions(id)
);

INSERT INTO car_bodies (name) VALUES 
('Седан'),
('Хэтчбек'),
('Пикап');

INSERT INTO car_engines (name) VALUES 
('Бензиновый'),
('Дизельный'),
('Электрический');

INSERT INTO car_transmissions (name) VALUES 
('Механическая'),
('Автоматическая'),
('Роботизированная');

INSERT INTO cars (name, body_id, engine_id, transmission_id) VALUES 
('Toyota Corolla', 1, 1, 1),
('Volkswagen Golf', 2, null, 2),
('BMW 3 Series', 1, 2, null);