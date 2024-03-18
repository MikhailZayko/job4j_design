start transaction isolation level repeatable read;

insert into students(name, course, grade) values ('st1', 3, 3.0);

savepoint first_savepoint;

insert into students(name, course, grade) values ('st2', 4, 4.0);

savepoint second_savepoint;

insert into students(name, course, grade) values ('st3', 5, 5.0);

select * from students;

rollback to second_savepoint;

select * from students;

rollback to first_savepoint;

select * from students;

commit;