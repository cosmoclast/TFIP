DELETE FROM employee 
WHERE employee_id IN 
	(SELECT employee_id 
	FROM (works w JOIN manages m ON w.employee_id = m.manager_id) 
	WHERE company_name = "First Bank of Singapore" AND salary > "10000");