select restaurant_name,
       price_per_plate*ratio_of_add "수수료"
from 
(
select restaurant_name,
       case when price_per_plate<5000 then 0.005
            when price_per_plate between 5000 and 19999 then 0.01
            when price_per_plate between 20000 and 29999 then 0.02
            else 0.03 end ratio_of_add,
       price_per_plate
from 
(
select restaurant_name, avg(price/quantity) price_per_plate
from food_orders
group by 1
) a
) b