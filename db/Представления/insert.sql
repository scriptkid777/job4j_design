insert into users(name) values('Igor');
insert into users(name) values('Oleg');
insert into users(name) values('Vladislav');

insert into locations(name, ip) values('moscow', '137.241.72.35');
insert into locations(name, ip) values('krasnodar', '160.151.35.168');
insert into locations(name, ip) values('tomsk', '218.83.20.92');
insert into locations(name, ip) values('moscow', '109.251.90.174');
insert into locations(name, ip) values('krasnodar', '195.159.168.188');
insert into locations(name, ip) values('tomsk', '81.138.240.251');
insert into locations(name, ip) values('moscow', '59.137.40.247');
insert into locations(name, ip) values('Novosibirsk', '97.182.200.216');
insert into locations(name, ip) values('tomsk', '98.187.176.22');

insert into servers(name, location_id) values ('server v1', 1);
insert into servers(name, location_id) values ('server v2', 2);
insert into servers(name, location_id) values ('server v3', 3);
insert into servers(name, location_id) values ('server v4', 4);
insert into servers(name, location_id) values ('server v5', 5);
insert into servers(name, location_id) values ('server v6', 6);
insert into servers(name, location_id) values ('server v7', 7);
insert into servers(name, location_id) values ('server v8', 8);
insert into servers(name, location_id) values ('server v9', 9);

insert into owners(user_id, server_id) values(1, 1);
insert into owners(user_id, server_id) values(1, 2);
insert into owners(user_id, server_id) values(1, 3);
insert into owners(user_id, server_id) values(1, 4);
insert into owners(user_id, server_id) values(2, 5);
insert into owners(user_id, server_id) values(3, 6);
insert into owners(user_id, server_id) values(3, 7);
insert into owners(user_id, server_id) values(3, 8);
insert into owners(user_id, server_id) values(3, 9);