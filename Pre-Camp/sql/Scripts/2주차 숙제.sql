select cuisine_type,
		min(price) min_price,
		max(price) max_price
from food_orders
group by cuisine_type
order by min_price desc