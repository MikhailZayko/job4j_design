start transaction isolation level serializable;

select avg(grade) from students;

update students set grade = 4.0 where id = 1;

commit;