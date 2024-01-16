create table car_bodies(
	id serial primary key,
	name varchar(64)
);

create table car_engines(
	id serial primary key,
	name varchar(64)
);

create table car_transmissions(
	id serial primary key,
	name varchar(64)
);

create table car(
	id serial primary key, 
	name varchar(64), 
	body_id int references car_bodies(id), 
	engine_id int references car_engines(id),
	transmission_id int references car_transmissions(id)
);