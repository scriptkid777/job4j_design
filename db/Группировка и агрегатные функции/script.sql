create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price) values('GeForce GTX 1080 3Gb', 23500.0);
insert into devices(name, price) values('Intel Core i3 7350K', 7650.0);
insert into devices(name, price) values('A4Tech X-218BK', 1750.0);
insert into devices(name, price) values('Intel Core i5 10600KF', 13590.0);
insert into devices(name, price) values('GeForce GTX 3060 16Gb', 33000.0);

insert into people(name) values('Igor');
insert into people(name) values('Vadim');
insert into people(name) values('Pavel');

insert into devices_people(device_id, people_id) values(1, 1);
insert into devices_people(device_id, people_id) values(2, 1);
insert into devices_people(device_id, people_id) values(3, 2);
insert into devices_people(device_id, people_id) values(4, 3);
insert into devices_people(device_id, people_id) values(5, 3);

select avg(price) from devices; 

select p.name "Имя покупателя", avg(d.price) "Средняя цена" 
from devices_people dp join people p on dp.people_id = p.id
join devices d on dp.device_id = d.id group by p.name;

select p.name "Имя покупателя", avg(d.price) "Средняя цена" 
from devices_people dp join people p on dp.people_id = p.id
join devices d on dp.device_id = d.id group by p.name 
having avg(d.price) > 5000.0;