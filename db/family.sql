create table members(
id serial primary key,
name varchar(255),
role text,
age int);
insert into members(name,role,age) values('Попов Александр Иванович','Отец',35);
insert into members(name,role,age) values('Попова Алена Петровна','Мать',33);
update members set age = 37;
select * from members;
delete from members;
select * from members;