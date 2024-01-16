select c.name "Машина", b.name "Кузов", e.name "Двигатель", t.name "Коробка передач" from car c 
join car_bodies b on c.body_id = b.id 
join car_engines e on c.engine_id = e.id
join car_transmissions t on c.transmission_id = t.id;

select b.name "Кузова" from car_bodies b 
left join car c on b.id = c.body_id 
where c.body_id is null;

select e.name "Двигатели" from car_engines e 
left join car c on e.id = c.body_id 
where c.body_id is null;

select t.name "Коробки передач" from car_transmissions t 
left join car c on t.id = c.body_id 
where c.body_id is null;