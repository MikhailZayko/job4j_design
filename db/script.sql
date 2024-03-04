create table people (
    id serial primary key,
	sex char(1),
    name varchar(15),
	age int
);
insert into people (sex, name, age) values ('m', 'Ivan', 25);
update people set sex = 'w', name = 'Anna', age = 20;
delete from people;