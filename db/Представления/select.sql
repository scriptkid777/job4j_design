select u.name "Пользователь", count(l.name) "Кол-во", l.name "Локация" from users u
join owners o on u.id = o.user_id
join servers s on o.server_id = s.id
join locations l on s.location_id = l.id
group by (u.name, l.name) having count(l.name) >= 2;

select * from show_users_with_2_or_more_servers;