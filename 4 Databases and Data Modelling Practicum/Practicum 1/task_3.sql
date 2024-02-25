SELECT * 
FROM 
	(SELECT company_name, SUM(salary) AS s_sum 
	FROM works 
	GROUP BY company_name) AS company_s_sum 
ORDER BY company_s_sum.s_sum 
LIMIT 1;
