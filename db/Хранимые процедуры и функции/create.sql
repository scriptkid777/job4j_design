create table products (
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);

create or replace procedure delete_data(d_id integer)
language 'plpgsql'
as $$
    begin
    delete from products where id = d_id;
    end
$$;

create or replace function f_delete_data(d_id integer)
returns void
language 'plpgsql'
as
$$
    begin
    delete from products where id = d_id;
    end
$$;