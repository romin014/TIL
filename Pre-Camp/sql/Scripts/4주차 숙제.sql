select t.restaurant_name, 
		case when avg_price <=5000 then 'price_group1'
			 when avg_price between 5001 and 10000 then'price_group2'
			 when avg_price between 10001 and 30000 then 'price_group3'
			 when avg_price > 3000 then 'price_group4' end "price_group",
		case when avg_age < 30 then 'age_group1'
			 when avg_age between 30 and 39 then 'age_group2'
			 when avg_age between 40 and 49 then 'age_group3'
			 when avg_age >= 50 then 'age_group4' end "age_group"
from (
select f.restaurant_name,
		avg(f.price) avg_price,
		avg(c.age) avg_age
from food_orders f right JOIN customers c on f.customer_id = c.customer_id 
group by restaurant_name
)t
order by restaurant_name
