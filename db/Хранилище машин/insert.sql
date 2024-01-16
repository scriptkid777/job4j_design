insert into car_bodies(name) values('кузов-а1');
insert into car_bodies(name) values('кузов-а2');
insert into car_bodies(name) values('кузов-а3');
insert into car_bodies(name) values('кузов-а4');
insert into car_bodies(name) values('кузов-а5');

insert into car_engines(name) values('двигатель-v1');
insert into car_engines(name) values('двигатель-v2');
insert into car_engines(name) values('двигатель-v3');
insert into car_engines(name) values('двигатель-v4');
insert into car_engines(name) values('двигатель-v5');

insert into car_transmissions(name) values('трансмиссия-v1');
insert into car_transmissions(name) values('трансмиссия-v2');
insert into car_transmissions(name) values('трансмиссия-v3');
insert into car_transmissions(name) values('трансмиссия-v4');
insert into car_transmissions(name) values('трансмиссия-v5');

insert into car(name, body_id, engine_id, transmission_id) 
values ('first car', 1, 1, 1);
insert into car(name, body_id, engine_id, transmission_id) 
values ('second car', 2, 2, 2);
insert into car(name, body_id, engine_id, transmission_id) 
values ('third car', 5, 5, 5);