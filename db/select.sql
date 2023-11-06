select p.name, p.surname, p.people_id from people as p join snils as s on s.id = p.people_id;

select p.name as Имя, p.surname as Фамилия, s.number as Снилс from people as p join snils as s on s.id = p.people_id;

select p.name Имя, p.surname Фамилия, s.number Снилс from people  p join snils  s on s.id = p.people_id;
