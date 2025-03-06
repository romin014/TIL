SELECT Department,
    	AVG(Salary) Avg_Salary
FROM employees
GROUP BY Department
HAVING AVG(Salary) = (
        SELECT MAX(Avg_Salary)
        FROM (
        	SELECT AVG(Salary) Avg_Salary
            FROM employees
            GROUP BY Department
        )t
    )
    limit 1
