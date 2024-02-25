UPDATE works 
SET salary = salary * 1.1 
WHERE employee_id IN 
	(SELECT employee_id 
	FROM (manages m JOIN works w ON m.manager_id = w.employee_id) 
	WHERE company_name = "Small Bank of Singapore");
	

	