/*
Write a SQL query to find the total rental amount paid for each film.
Your query should return the following columns: film_id, total_amount
*/
use sakila;
select i.film_id, sum(p.amount) as total_amount from payment p
join rental r on p.rental_id = r.rental_id 
join inventory i on r.inventory_id = i.inventory_id 
group by i.film_id;


-- Create a view named total_rental_amount using the query from the previous step.
use sakila;
create view total_rental_amount as 
select i.film_id, sum(p.amount) as total_amount from payment p
join rental r on p.rental_id = r.rental_id 
join inventory i on r.inventory_id = i.inventory_id 
group by i.film_id;


-- Write a SQL query to find the total number of copies in inventory for each film. 
-- Your query should return the following columns: film_id, total_copies
use sakila;
select film_id, count(inventory_id) as total_copies from inventory
group by film_id;


-- Create a view named total_film_copies using the query from the previous step.
use sakila;
create view total_film_copies as 
select film_id, count(inventory_id) as total_copies from inventory
group by film_id;


/*Write a SQL query that combines data from the film table, the total_rental_amount view, 
 and the total_film_copies view to find all films with a total rental amount greater than 
 200.00, and display the following columns:film_id, title, description,rental_duration,
 rental_rate, replacement_cost, rating, total_copies, total_amount
 */
use sakila;
select tra.film_id, f.title, f.description, f.rental_duration, f.rental_rate, f.replacement_cost, f.rating, tfc.total_copies, tra.total_amount from total_rental_amount tra
join total_film_copies tfc on tra.film_id = tfc.film_id 
join film f on tra.film_id = f.film_id 
where total_amount > 200.00;
