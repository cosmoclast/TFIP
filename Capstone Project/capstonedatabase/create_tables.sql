DROP TABLE IF EXISTS defects;
DROP TABLE IF EXISTS favourites;
DROP TABLE IF EXISTS equipment;
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS locations;

CREATE TABLE locations(
	bay VARCHAR(5),
	lat DECIMAL(8,5),
	lng DECIMAL(8,5),	
	PRIMARY KEY(bay)
);

CREATE TABLE employees(
	employee_id VARCHAR(8),
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	title VARCHAR(50),	
	PRIMARY KEY(employee_id)
);

CREATE TABLE equipment(
	equipment_id INT AUTO_INCREMENT,
	category VARCHAR(50),
	equipment_name VARCHAR(50),
	e_length DECIMAL(3,1),
	e_width DECIMAL(3,1),
	e_height DECIMAL(3,1),
	aircraft VARCHAR(20),
	in_use TINYINT(1) DEFAULT(0),
	has_defects TINYINT(1) DEFAULT(0),
	location VARCHAR(5),
	employee_id VARCHAR(8),
	PRIMARY KEY(equipment_id),
	FOREIGN KEY(location) REFERENCES locations(bay),
	FOREIGN KEY(employee_id) REFERENCES employees(employee_id)
);

CREATE TABLE favourites(
	employee_id VARCHAR(8),
	equipment_id INT,
	PRIMARY KEY(employee_id, equipment_id),
	FOREIGN KEY(employee_id) REFERENCES employees(employee_id),
	FOREIGN KEY(equipment_id) REFERENCES equipment(equipment_id)
);

CREATE TABLE defects(
	defect_id INT AUTO_INCREMENT,
	equipment_id INT,
	description VARCHAR(50),
	PRIMARY KEY(defect_id),
	FOREIGN KEY(equipment_id) REFERENCES equipment(equipment_id)
);


