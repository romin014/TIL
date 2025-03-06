select date(created_at), round(avg(point)) avgerage_points
from point_users
group by date(created_at)
