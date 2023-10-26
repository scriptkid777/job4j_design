insert into roles(name) values('first_role');
insert into rules(name) values('second_rule');
insert into categories(name) values('first_categorie');
insert into states(name) values('first_state');
insert into users(name, role_id) values('Vladislav', 1);
insert into roles_rules(role_id, rule_id) values(1, 1);
insert into items(name, user_id, categorie_id, state_id) values ('first item', 1, 1, 1);
insert into comments(name, items_id) values('first_comment', 1);
insert into attachs(name, items_id) values('first_attach', 1);