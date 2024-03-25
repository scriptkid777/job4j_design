begin;
declare cursor_products scroll cursor for select * from products;

fetch last from cursor_products;
move backward 6 FROM cursor_products;
fetch from cursor_products;
move backward 9 FROM cursor_products;
fetch from cursor_products;
move backward 6 FROM cursor_products;
fetch from cursor_products;

fetch prior from cursor_products;
close cursor_products;
commit;