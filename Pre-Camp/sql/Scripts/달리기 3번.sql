select u.user_id, email, coalesce(point,0)
from users u left join point_users pu on u.user_id = pu.user_id 
order by point desc
