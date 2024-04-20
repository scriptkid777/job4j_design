select c.first_name "Имя", c.last_name "Фамилия", c.age "Возраст", c.country "Город"
from customers c where c.age = (select min(age) from customers);

select c.first_name "Имя", c.last_name "Фамилия", c.age "Возраст", c.country "Город"
from customers c where c.id not in (select customer_id from orders);