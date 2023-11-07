create table snils(
	id serial primary key,
	number int
);

create table people(
	id serial primary key, 
	name varchar(55),
	surname varchar(55),
	people_id int references snils(id) unique
);