select p.name "Название" , p.expired_date "Срок", p.price "Цена" from product as p join type t on p.type_id = t.id
where t.name = 'СЫР';

select p.name "Название", p.expired_date "Срок", p.price "Цена" from product as p where p.name like '%мороженное%';

select p.name "Название", p.expired_date "Срок", p.price "Цена" from product as p where p.expired_date < current_date;

select p.name "Название", p.expired_date "Срок", p.price "Цена", t.name "Тип" from product p join type t on p.type_id = t.id
where p.price = (select max(price) from product);

select t.name "Тип", count(t.name) "Кол-во" from product p join type t on t.id = p.type_id group by t.name;

select p.name "Название", p.expired_date "Срок", p.price "Цена" from product p join type t on p.type_id = t.id
where t.name = 'МОЛОКО' or t.name ='СЫР';

select t.name "Тип" from type t group by t.name having count(t.name) < 10;

select p.name "Название", p.expired_date "Срок", p.price "Цена", t.name "Тип"
from product p join type t on p.type_id = t.id;