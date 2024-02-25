CREATE TABLE IF NOT EXISTS employee
	(employee_id CHAR(6) NOT NULL, 
	employee_name VARCHAR(100) NOT NULL, 
	street VARCHAR(100) NOT NULL,
	employee_city VARCHAR(100) NOT NULL,
	PRIMARY KEY(employee_id));

CREATE TABLE IF NOT EXISTS company
	(company_name VARCHAR(100) NOT NULL,
	company_city VARCHAR(100) NOT NULL,
	PRIMARY KEY(company_name));
	
CREATE TABLE IF NOT EXISTS manages
	(manager_number INT(5) AUTO_INCREMENT, 
	manager_id CHAR(6) NOT NULL,
	PRIMARY KEY(manager_number),
	FOREIGN KEY(manager_id) REFERENCES employee(employee_id) ON DELETE CASCADE ON UPDATE CASCADE);

CREATE TABLE IF NOT EXISTS works
	(employee_id CHAR(6) NOT NULL, 
	company_name VARCHAR(100) NOT NULL,
	salary DECIMAL(8,2) NOT NULL, 
	PRIMARY KEY(employee_id),
	FOREIGN KEY(employee_id) REFERENCES employee(employee_id) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY(company_name) REFERENCES company(company_name) ON DELETE CASCADE ON UPDATE CASCADE);
	



