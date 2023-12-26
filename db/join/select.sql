select e.name "Работник", d.name "Департамент"
from employees e left join departments d 
on e.department_id = d.id;

select d.name "Департамент", e.name "Работник"
from employees e right join departments d 
on e.department_id = d.id;

select e.name "Работник", d.name "Департамент"
from employees e full join departments d 
on e.department_id = d.id;

select e.name "Работник", d.name "Департамент"
from employees e cross join departments d;

select e.name "Работник", d.name "Департамент"
from employees e left join departments d 
on e.department_id = d.id;

select e.name "Работник", d.name "Департамент"
from departments d right join employees e 
on e.department_id = d.id;

select t1.name "Парень", t2.name "Девушка" 
from teens t1 cross join teens t2
where t1.gender < t2.gender;

