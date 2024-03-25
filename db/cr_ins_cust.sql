CREATE TABLE customers
(
    id         serial primary key,
    first_name text,
    last_name  text,
    age        int,
    country    text
);

CREATE TABLE orders
(
    id          serial primary key,
    amount      int,
    customer_id int references customers (id)
);

INSERT INTO customers (first_name, last_name, age, country) VALUES
('John', 'Doe', 30, 'USA'),
('Alice', 'Smith', 18, 'UK'),
('Michael', 'Johnson', 40, 'Canada'),
('Emma', 'Brown', 35, 'Australia'),
('Alexander', 'Martinez', 18, 'Spain');

INSERT INTO orders (amount, customer_id) VALUES
(100, 1),
(75, 3),
(50, 5);