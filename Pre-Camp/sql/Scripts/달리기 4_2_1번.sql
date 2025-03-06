SELECT e.Name, e.Department, e.Salary,
    m.Name AS TOP_Earner,
    m.Salary AS TOP_Salary
FROM employees e
LEFT JOIN (
    SELECT Department, Name, Salary
    FROM employees
    WHERE (Department, Salary) IN (
            SELECT Department, MAX(Salary)
            FROM employees
            GROUP BY Department
        )
)m 
ON e.Department = m.Department
