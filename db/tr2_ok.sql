start transaction isolation level serializable;

select avg(grade) from students;

update students set grade = 3.9 where id = 2;

commit;