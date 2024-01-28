create table users(
	id serial primary key, 
	name varchar(64)
);

create table locations(
	id serial primary key, 
	name varchar(64), 
	ip varchar(64)
);

create table servers(
	id serial primary key, 
	name varchar(64),
	location_id int references locations(id)
);

create table owners(
	id serial primary key, 
	user_id int references users(id), 
	server_id int references servers(id)
);

create view show_users_with_2_or_more_servers
as select u.name as user, count(l.name), l.name as location from users as u
join owners o on u.id = o.user_id
join servers s on o.server_id = s.id
join locations l on s.location_id = l.id
group by (u.name, l.name) having count(l.name) >= 2;