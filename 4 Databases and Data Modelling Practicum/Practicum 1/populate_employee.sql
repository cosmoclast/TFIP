DELETE FROM manages;
DELETE FROM works;
DELETE FROM company;
DELETE FROM employee;


INSERT INTO employee VALUES ("E00001", "Mark", "Adam Road", "Singapore");
INSERT INTO employee VALUES ("E00002", "Olivia", "Lentor Vale", "Singapore");
INSERT INTO employee VALUES ("E00003", "Emma", "Bishan Street 12", "Singapore");
INSERT INTO employee VALUES ("E00004", "James", "Range Road 242", "Alberta");
INSERT INTO employee VALUES ("E00005", "Amy", "23rd Street", "New York City");
INSERT INTO employee VALUES ("E00006", "Nancy", "Absecon Rd", "New York City");
INSERT INTO employee VALUES ("E00007", "Chloe", "10 Avenue North-west", "Alberta");
INSERT INTO employee VALUES ("E00008", "Ethan", "Parry Rd", "Kuala Lumpur");
INSERT INTO employee VALUES ("E00009", "Daniel", "El Prado", "San Diego");
INSERT INTO employee VALUES ("E00010", "Levi", "5th Avenue", "San Diego");
INSERT INTO employee VALUES ("E00011", "Logan", "Teck Ghee Rd", "Singapore");

INSERT INTO company VALUES ("First Bank of Singapore", "Singapore");
INSERT INTO company VALUES ("Small Bank of Singapore", "Alberta");
INSERT INTO company VALUES ("Bank of Nova Scotia", "Nova Scotia");

INSERT INTO works VALUES ("E00001", "First Bank of Singapore", 5500.0);
INSERT INTO works VALUES ("E00002", "First Bank of Singapore", 7000.0);
INSERT INTO works VALUES ("E00003", "Bank of Nova Scotia", 6000.0);
INSERT INTO works VALUES ("E00004", "Bank of Nova Scotia", 3200.0);
INSERT INTO works VALUES ("E00005", "Small Bank of Singapore", 2500.0);
INSERT INTO works VALUES ("E00006", "Small Bank of Singapore", 5000.0);
INSERT INTO works VALUES ("E00007", "Small Bank of Singapore", 3500.0);
INSERT INTO works VALUES ("E00008", "First Bank of Singapore", 15000.0);
INSERT INTO works VALUES ("E00009", "Bank of Nova Scotia", 3200.0);
INSERT INTO works VALUES ("E00010", "First Bank of Singapore", 3200.0);
INSERT INTO works VALUES ("E00011", "First Bank of Singapore", 7500.0);

INSERT INTO manages (manager_id) VALUES ("E00002");
INSERT INTO manages (manager_id) VALUES ("E00008");
INSERT INTO manages (manager_id) VALUES ("E00003");
INSERT INTO manages (manager_id) VALUES ("E00006");
INSERT INTO manages (manager_id) VALUES ("E00007");
INSERT INTO manages (manager_id) VALUES ("E00011");