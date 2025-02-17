select restaurant_name, customer_id 
from food_orders
where food_preparation_time between 20 and 30
And cuisine_type = 'Korean'