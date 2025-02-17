select order_id, 
		restaurant_name, 
		day_of_the_week, 
		delivery_time,
		case when day_of_the_week = 'Weekday' and (delivery_time >=25) then 'late'
			 when day_of_the_week = 'Weekend'and (delivery_time >=30) then 'late'
			 else 'On-time' end "지연여부"
from food_orders

 