SELECT employee_id, employee_name 
FROM ((employee NATURAL JOIN works) NATURAL JOIN company) 
WHERE employee_city = company_city; 