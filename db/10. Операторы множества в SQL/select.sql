select name from movie
intersect
select title from book 
order by name;

select title from book
except 
select name from movie
order by title;

select name from movie
except 
select title from book
union 
(select title from book 
except 
select name from movie)
order by name;