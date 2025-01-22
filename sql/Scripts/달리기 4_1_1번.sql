SELECT 
    c.CustomerName,
    COUNT(o.OrderID) AS OrderCount,
    COALESCE(SUM(o.TotalAmount), 0) TotalSpent
FROM practice1.customers c 
	left join practice1.orders o  
	on c.customerID = o.customerID
GROUP BY 
    c.CustomerID, c.CustomerName
ORDER BY 
    c.CustomerName