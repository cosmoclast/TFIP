DROP TABLE IF EXISTS works;
DROP TABLE IF EXISTS repair_bay;
DROP TABLE IF EXISTS problem;
DROP TABLE IF EXISTS admin_staff;
DROP TABLE IF EXISTS mechanic;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS service_ticket;
DROP TABLE IF EXISTS vehicle;
DROP TABLE IF EXISTS repair_centre;

CREATE TABLE repair_centre(    
	repair_centre_id CHAR(8),
	address VARCHAR(100) UNIQUE,
	hourly_rate DECIMAL(5,2),
	PRIMARY KEY(repair_centre_id)
);

CREATE TABLE vehicle(   
	vehicle_id VARCHAR(10),
	year INT,
	model VARCHAR(50),
	make VARCHAR(50),
	PRIMARY KEY(vehicle_id)
);

#slot_id is not included in service_ticket because the service_ticket_id is used in repair_bay to uniquely identify a record
CREATE TABLE service_ticket(   
	service_ticket_id INT AUTO_INCREMENT,
	vehicle_id VARCHAR(10),
	date_in TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(service_ticket_id),
	FOREIGN KEY(vehicle_id) REFERENCES vehicle(vehicle_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE employee(    
	employee_id CHAR(8),
	repair_centre_id CHAR(8),
	employee_name VARCHAR(100),
	employee_salary DECIMAL(7,2),
	PRIMARY KEY(employee_id, repair_centre_id),
	FOREIGN KEY(repair_centre_id) REFERENCES repair_centre(repair_centre_id) ON DELETE CASCADE ON UPDATE CASCADE
);
 
CREATE TABLE mechanic(	 
	employee_id CHAR(8),
	mechanic_rank VARCHAR(50),
	PRIMARY KEY(employee_id),
	FOREIGN KEY(employee_id) REFERENCES employee(employee_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE admin_staff(	
	employee_id CHAR(8),
	job_title VARCHAR(50), 
	PRIMARY KEY(employee_id),
	FOREIGN KEY(employee_id) REFERENCES employee(employee_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE problem(	 
	problem_id INT,
	employee_id CHAR(8),
	hours_fix INT,  
	description BLOB,
	PRIMARY KEY(problem_id), 
	FOREIGN KEY(problem_id) REFERENCES service_ticket(service_ticket_id) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY(employee_id) REFERENCES mechanic(employee_id) ON UPDATE CASCADE
);

CREATE TABLE repair_bay(   
	slot_id CHAR(8),
	service_ticket_id INT,
	repair_centre_id CHAR(8),
	invoice_number INT,
	work_done BLOB,
	date_of_repair DATE,
	PRIMARY KEY(slot_id, service_ticket_id, repair_centre_id),
	FOREIGN KEY(service_ticket_id) REFERENCES service_ticket(service_ticket_id) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY(repair_centre_id) REFERENCES repair_centre(repair_centre_id) ON UPDATE CASCADE
);

#works table is created because cardinality between repair_bay and mechanic is many to many.
CREATE TABLE works(    
	repair_centre_id CHAR(8),
	slot_id CHAR(8),
	employee_id CHAR(8),
	PRIMARY KEY(repair_centre_id, slot_id, employee_id),
	FOREIGN KEY(repair_centre_id) REFERENCES repair_bay(repair_centre_id) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY(slot_id) REFERENCES repair_bay(slot_id) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY(employee_id) REFERENCES mechanic(employee_id) ON DELETE CASCADE ON UPDATE CASCADE
);