create table roles(
	id serial primary key, 
	name varchar(50)
);

create table rules(
	id serial primary key, 
	name varchar(50)
);

create table categories(
	id serial primary key,
	name varchar(50)
);

create table states(
	id serial primary key,
	name varchar(50)
);

create table users(
	id serial primary key,
	name varchar(50),
	role_id int references roles(id)
);

create table roles_rules(
	id serial primary key, 
	role_id int references roles(id),
	rule_id int references rules(id)
);

create table items(
	id serial primary key, 
	name varchar(50),
	user_id int references users(id), 
	categorie_id int references categories(id), 
	state_id int references states(id)
);

create table comments(
	id serial primary key, 
	name text,
	items_id int references items(id)
);

create table attachs(
	id serial primary key, 
	name varchar(50),
	items_id int references items(id)
);