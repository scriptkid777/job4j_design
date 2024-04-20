create table customers(
    id serial primary key,
    first_name text,
    last_name text,
    age int,
    country text
);

create table orders(
    id serial primary key,
    amount int,
    customer_id int references customers(id)
);