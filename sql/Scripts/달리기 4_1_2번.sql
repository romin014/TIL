SELECT 
    c.Country,
    c.CustomerName as Top_Customer,
    COALESCE(SUM(o.TotalAmount), 0) Top_Spent
FROM 
    practice1.customers c
	LEFT JOIN practice1.orders o 
	ON c.CustomerID = o.CustomerID
GROUP BY 
    c.Country, c.CustomerName
HAVING COALESCE(SUM(o.TotalAmount), 0) = (
        SELECT MAX(TotalSpent)
        FROM (
            SELECT c2.Country,
                COALESCE(SUM(o2.TotalAmount), 0) TotalSpent
            FROM practice1.customers c2
            	LEFT JOIN practice1.orders o2 
            	ON c2.CustomerID = o2.CustomerID
            GROUP BY 
                c2.CustomerID, c2.Country
        ) t
        WHERE t.Country = c.Country
    )
