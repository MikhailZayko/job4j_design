create table contact_info (
	id serial primary key,
	mobile_phone varchar(20),
    home_phone varchar(20)
);
create table users (
	id serial primary key,
	username varchar(30),
	email varchar(80),
	contact_Info_id int references contact_info(id) unique
);
create table orders (
    id serial primary key,
    order_date date,
    total_amt decimal(10, 2),
	user_id int references users(id)
);
create table products (
    id serial primary key,
    product_name varchar(100),
    price decimal(10, 2)
);
create table orders_products (
	id serial primary key,
	order_id int references orders(id),
	product_id int references products(id)
);