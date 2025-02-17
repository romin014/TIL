select date(created_at) created_at , round(avg(point)) average_points
from point_users
group by created_at