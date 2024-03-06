CREATE TABLE roles (
    id SERIAL PRIMARY KEY,
    role_name VARCHAR(50)
);
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50),
    email VARCHAR(100),
    role_id INT REFERENCES roles(id)
);
CREATE TABLE rules (
    id SERIAL PRIMARY KEY,
    rule_name VARCHAR(50)
);
CREATE TABLE roles_rules (
	id SERIAL PRIMARY KEY,
	role_id INT REFERENCES roles(id),
	rule_id INT REFERENCES rules(id)
);
CREATE TABLE categories (
    id SERIAL PRIMARY KEY,
    category_name VARCHAR(100)
);
CREATE TABLE states (
    id SERIAL PRIMARY KEY,
    state_name VARCHAR(100)
);
CREATE TABLE items (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100),
    user_id INT REFERENCES users(id),
    category_id INT REFERENCES categories(id),
    state_id INT REFERENCES states(id)
);
CREATE TABLE comments (
    id SERIAL PRIMARY KEY,
	comment_text TEXT,
	item_id INT REFERENCES items(id)
);
CREATE TABLE attachs (
    id SERIAL PRIMARY KEY,
    attach_path VARCHAR(255),
	item_id INT REFERENCES items(id)
);