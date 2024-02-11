create table products(
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);


/*
	Триггер должен срабатывать после вставки данных, 
	для любого товара и просто насчитывать налог на товар(нужно прибавить налог к цене товара). 
	Действовать он должен не на каждый ряд, а на запрос (statement уровень).
*/

create or replace function tax_after()
    returns trigger as
	$$
	BEGIN
	update products
	set price = price + price * 0.2
	where id = (select id from inserted);
	return new;
	END
	$$
	language 'plpgsql';
	
	create trigger tax_after_trigger
	after insert on products 
	referencing new table as inserted
	for each statement 
	execute procedure tax_after();
	
	/*
	Триггер должен срабатывать до вставки данных и насчитывать налог на товар (нужно прибавить налог к цене товара). 
	Здесь используем row уровень.
*/

create or replace function tax_before()
	return trigger as
$$
	BEGIN
		new.price = new.price * 1.2;
		return new
	END
$$
language 'plpgsql';

create trigger tax_before_trigger 
before insert on products
	for each row
	execute procedure tax_before();	
	
	/*
	Нужно написать триггер на row уровне, который сразу после вставки продукта в таблицу products,
	будет заносить имя, цену и текущую дату в таблицу history_of_price. 
*/

create table history_of_price(
    id serial primary key,
    name varchar(50),
    price integer,
    date timestamp
);

create or replace function insert_after()
    returns trigger as
$$
    begin
        insert into history_of_price(name, price, date)
		values(new.name, new.price, current_date);
        return new;
    end;
$$
language 'plpgsql';

create trigger insert_after_trigger 
	after insert on products
	for each ROW
	execute procedure insert_after();