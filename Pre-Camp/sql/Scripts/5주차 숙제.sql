select t.cuisine_type,
max(if(age=10, order_count, 0)) "10대",
max(if(age=20, order_count, 0)) "20대",
max(if(age=30, order_count, 0)) "30대",
max(if(age=40, order_count, 0)) "40대",
max(if(age=50, order_count, 0)) "50대"
from
(
select a.cuisine_type,
case when age between 10 and 19 then 10
when age between 20 and 29 then 20
when age between 30 and 39 then 30
when age between 40 and 49 then 40
when age between 50 and 59 then 50 end age,
count(1) order_count
from food_orders a inner join customers b on a.customer_id=b.customer_id
where age between 10 and 59
group by a.cuisine_type, age
) t
group by cuisine_type