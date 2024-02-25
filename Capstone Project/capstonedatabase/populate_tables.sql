-- populate_tables cannot be run multiple times because of the auto incremented ids. To run this a second time, you have
-- to run create_tables first before running populate_tables.
/* Clear previous data */
DELETE FROM defects;
DELETE FROM favourites;
DELETE FROM equipment;
DELETE FROM employees;
DELETE FROM locations;

/* Populate the tables with data */
/* employee table ----------------------------------------------------------------*/
INSERT INTO employees VALUES ('11111111', 'Jimmie', 'Blair', 'Technician');
INSERT INTO employees VALUES ('11111112', 'Lorena', 'Cohen', 'Technician');
INSERT INTO employees VALUES ('11111113', 'Lynette', 'Franco', 'Technician');
INSERT INTO employees VALUES ('11111114', 'Thompson', 'Richards', 'Technician');
INSERT INTO employees VALUES ('11111115', 'Madden', 'Stone', 'Supervisor');
INSERT INTO employees VALUES ('11111116', 'Simon', 'Dyer', 'Supervisor');

-- /* locations table ----------------------------------------------------------------*/
INSERT INTO locations VALUES ('A1', 1.35597, 103.98506);
INSERT INTO locations VALUES ('A2', 1.35604, 103.98444);
INSERT INTO locations VALUES ('A3', 1.35551, 103.98410);
INSERT INTO locations VALUES ('A4', 1.35489, 103.98403);
INSERT INTO locations VALUES ('A5', 1.35430, 103.98433);
INSERT INTO locations VALUES ('A9', 1.35348, 103.98434);
INSERT INTO locations VALUES ('A10', 1.35287, 103.98400);
INSERT INTO locations VALUES ('A11', 1.35220, 103.98372);
INSERT INTO locations VALUES ('A12', 1.35160, 103.98346);
INSERT INTO locations VALUES ('A13', 1.35099, 103.98321);
INSERT INTO locations VALUES ('A14', 1.35046, 103.98266);
INSERT INTO locations VALUES ('A15', 1.35021, 103.98205);
INSERT INTO locations VALUES ('A16', 1.34979, 103.98172);
INSERT INTO locations VALUES ('A17', 1.34923, 103.98168);
INSERT INTO locations VALUES ('A18', 1.34885, 103.98201);
INSERT INTO locations VALUES ('A19', 1.34868, 103.98253);
INSERT INTO locations VALUES ('A20', 1.34891, 103.98300);
INSERT INTO locations VALUES ('A21', 1.34919, 103.98355);

INSERT INTO locations VALUES ('B1', 1.35746, 103.98565);
INSERT INTO locations VALUES ('B2', 1.35782, 103.98522);
INSERT INTO locations VALUES ('B3', 1.35842, 103.98536);
INSERT INTO locations VALUES ('B4', 1.35889, 103.98572);
INSERT INTO locations VALUES ('B5', 1.35916, 103.98635);
INSERT INTO locations VALUES ('B6', 1.35976, 103.98698);
INSERT INTO locations VALUES ('B7', 1.36045, 103.98720);
INSERT INTO locations VALUES ('B8', 1.36109, 103.98755);
INSERT INTO locations VALUES ('B9', 1.36171, 103.98782);
INSERT INTO locations VALUES ('B10', 1.36235, 103.98808);

INSERT INTO locations VALUES ('C1', 1.36298, 103.98835);
INSERT INTO locations VALUES ('C20', 1.36356, 103.98867);
INSERT INTO locations VALUES ('C22', 1.36416, 103.98892);
INSERT INTO locations VALUES ('C23', 1.36487, 103.98910);
INSERT INTO locations VALUES ('C24', 1.36570, 103.98915);
INSERT INTO locations VALUES ('C25', 1.36642, 103.98905);
INSERT INTO locations VALUES ('C26', 1.36707, 103.98910);
INSERT INTO locations VALUES ('C11', 1.36317, 103.98995);
INSERT INTO locations VALUES ('C13', 1.36378, 103.99020);
INSERT INTO locations VALUES ('C15', 1.36441, 103.99047);
INSERT INTO locations VALUES ('C16', 1.36485, 103.99072);
INSERT INTO locations VALUES ('C17', 1.36541, 103.99061);
INSERT INTO locations VALUES ('C18', 1.36607, 103.99048);
INSERT INTO locations VALUES ('C19', 1.36660, 103.99045);

INSERT INTO locations VALUES ('D30', 1.36237, 103.99170);
INSERT INTO locations VALUES ('D32', 1.36298, 103.99196);
INSERT INTO locations VALUES ('D34', 1.36361, 103.99223);
INSERT INTO locations VALUES ('D35', 1.36413, 103.99245);
INSERT INTO locations VALUES ('D36', 1.36443, 103.99292);
INSERT INTO locations VALUES ('D37', 1.36482, 103.99341);
INSERT INTO locations VALUES ('D38', 1.36516, 103.99382);
INSERT INTO locations VALUES ('D40', 1.36059, 103.99246);
INSERT INTO locations VALUES ('D41', 1.36119, 103.99272);
INSERT INTO locations VALUES ('D42', 1.36188, 103.99293);
INSERT INTO locations VALUES ('D44', 1.36249, 103.99317);
INSERT INTO locations VALUES ('D46', 1.36316, 103.99353);
INSERT INTO locations VALUES ('D47', 1.36366, 103.99413);
INSERT INTO locations VALUES ('D48', 1.36405, 103.99465);
INSERT INTO locations VALUES ('D49', 1.36450, 103.99509);
 
INSERT INTO locations VALUES ('E8', 1.35777, 103.99401);
INSERT INTO locations VALUES ('E10', 1.35670, 103.99240);
INSERT INTO locations VALUES ('E11', 1.35710, 103.99288);
INSERT INTO locations VALUES ('E12', 1.35755, 103.99345);
INSERT INTO locations VALUES ('E20', 1.35676, 103.99085);
INSERT INTO locations VALUES ('E22', 1.35740, 103.99112);
INSERT INTO locations VALUES ('E24', 1.35805, 103.99140);
INSERT INTO locations VALUES ('E26', 1.35866, 103.99165);
INSERT INTO locations VALUES ('E27', 1.35932, 103.99193);
INSERT INTO locations VALUES ('E28', 1.35992, 103.99219);
INSERT INTO locations VALUES ('E1', 1.35556, 103.99043);
INSERT INTO locations VALUES ('E2', 1.35535, 103.99091);
INSERT INTO locations VALUES ('E3', 1.35512, 103.99146);
INSERT INTO locations VALUES ('E4', 1.35502, 103.99213);
INSERT INTO locations VALUES ('E5', 1.35543, 103.99270);
INSERT INTO locations VALUES ('E6', 1.35589, 103.99331);
INSERT INTO locations VALUES ('E7', 1.35624, 103.99373);

INSERT INTO locations VALUES ('F30', 1.35408, 103.98981);
INSERT INTO locations VALUES ('F31', 1.35385, 103.99036);
INSERT INTO locations VALUES ('F32', 1.35361, 103.99090);
INSERT INTO locations VALUES ('F33', 1.35313, 103.99126);
INSERT INTO locations VALUES ('F34', 1.35249, 103.99137);
INSERT INTO locations VALUES ('F35', 1.35183, 103.99154);
INSERT INTO locations VALUES ('F36', 1.35120, 103.99157);
INSERT INTO locations VALUES ('F37', 1.34995, 103.99107);
INSERT INTO locations VALUES ('F40', 1.35156, 103.99037);
INSERT INTO locations VALUES ('F41', 1.35088, 103.99043);
INSERT INTO locations VALUES ('F42', 1.35016, 103.99054);
INSERT INTO locations VALUES ('F50', 1.35296, 103.98925);
INSERT INTO locations VALUES ('F52', 1.35236, 103.98900);
INSERT INTO locations VALUES ('F54', 1.35170, 103.98872);
INSERT INTO locations VALUES ('F56', 1.35110, 103.98846);
INSERT INTO locations VALUES ('F58', 1.35043, 103.98818);
INSERT INTO locations VALUES ('F59', 1.34983, 103.98793);
INSERT INTO locations VALUES ('F60', 1.34914, 103.98763);

INSERT INTO locations VALUES ('G1', 1.33543, 103.98360);
INSERT INTO locations VALUES ('G2', 1.33580, 103.98375);
INSERT INTO locations VALUES ('G3', 1.33616, 103.98390);
INSERT INTO locations VALUES ('G4', 1.33652, 103.98390);
INSERT INTO locations VALUES ('G5', 1.33688, 103.98421);
INSERT INTO locations VALUES ('G6', 1.33735, 103.98441);
INSERT INTO locations VALUES ('G7', 1.33769, 103.98460);
INSERT INTO locations VALUES ('G8', 1.33805, 103.98475);
INSERT INTO locations VALUES ('G9', 1.33841, 103.98490);
INSERT INTO locations VALUES ('G10', 1.33877, 103.98506);
INSERT INTO locations VALUES ('G11', 1.33913, 103.98521);
INSERT INTO locations VALUES ('G12', 1.33950, 103.98536);
INSERT INTO locations VALUES ('G13', 1.33986, 103.98551);
INSERT INTO locations VALUES ('G14', 1.34021, 103.98566);
INSERT INTO locations VALUES ('G15', 1.34058, 103.98582);
INSERT INTO locations VALUES ('G16', 1.34094, 103.98597);
INSERT INTO locations VALUES ('G17', 1.34130, 103.98612);
INSERT INTO locations VALUES ('G18', 1.34209, 103.98662);
INSERT INTO locations VALUES ('G19', 1.34240, 103.98590);
INSERT INTO locations VALUES ('G20', 1.34270, 103.98518);
INSERT INTO locations VALUES ('G21', 1.34301, 103.98445);

-- D34 is everything in use so marker should be red
-- B1 is mixture of in use and not in use with no defects and no favourites so marker should be green
-- C1 is mixture of in use and not in use with no defects and favourites so marker should be yellow
-- E1 is mixture of in use and not in use with defects and no favourites so marker should be blue
-- 11111111 is our favourite employee 
/* equipment table ----------------------------------------------------------------*/
INSERT INTO equipment (category, equipment_name, e_length, e_width, e_height, aircraft, in_use, has_defects, location, employee_id) 
VALUES ('Tow Tug', 'TLD 400HP XL Tow Tug', 2.0, 1.5, 1.5, 'B737', 1, 1, 'A1', '11111111');
INSERT INTO equipment (category, equipment_name, e_length, e_width, e_height, aircraft, in_use, has_defects, location, employee_id) 
VALUES ('Tow Tug', 'TLD 400HP XL Tow Tug', 2.0, 1.5, 1.5, 'B737', 1, 1, 'A1', '11111112');
INSERT INTO equipment (category, equipment_name, e_length, e_width, e_height, aircraft, in_use, has_defects, location, employee_id) 
VALUES ('Tow Tug', 'TLD 500HP XXL Tow Tug', 3.0, 1.5, 1.5, 'B747', 1, 0, 'B1', '11111111');
INSERT INTO equipment (category, equipment_name, e_length, e_width, e_height, aircraft, in_use, has_defects, location, employee_id) 
VALUES ('Tow Tug', 'TLD 500HP XXL Tow Tug', 3.0, 1.5, 1.5, 'B747', 1, 0, 'E1', '11111112');
INSERT INTO equipment (category, equipment_name, e_length, e_width, e_height, aircraft, in_use, has_defects, location, employee_id) 
VALUES ('Tow Tug', 'TLD 400HP XL Tow Tug', 2.0, 1.5, 1.5, 'B737', 0, 1, 'E1', NULL);
INSERT INTO equipment (category, equipment_name, e_length, e_width, e_height, aircraft, in_use, has_defects, location, employee_id) 
VALUES ('Tow Tug', 'TLD 400HP XL Tow Tug', 2.0, 1.5, 1.5, 'B737', 0, 1, 'C1', NULL);
INSERT INTO equipment (category, equipment_name, e_length, e_width, e_height, aircraft, in_use, has_defects, location, employee_id) 
VALUES ('Tow Tug', 'TLD 500HP XXL Tow Tug', 3.0, 1.5, 1.5, 'B747', 0, 0, 'B1', NULL);
INSERT INTO equipment (category, equipment_name, e_length, e_width, e_height, aircraft, in_use, has_defects, location, employee_id) 
VALUES ('Tow Tug', 'TLD 500HP XXL Tow Tug', 3.0, 1.5, 1.5, 'B747', 0, 0, 'G2', NULL);

INSERT INTO equipment (category, equipment_name, e_length, e_width, e_height, aircraft, in_use, has_defects, location, employee_id) 
VALUES ('Tow Bar', 'ACME 50Ton Titanium Tow Bar', 2.5, 0.5, 1.2, 'B787', 1, 1, 'C1', '11111113');
INSERT INTO equipment (category, equipment_name, e_length, e_width, e_height, aircraft, in_use, has_defects, location, employee_id) 
VALUES ('Tow Bar', 'ACME 50Ton Titanium Tow Bar', 2.5, 0.5, 1.2, 'B787', 1, 1, 'G2', '11111114');
INSERT INTO equipment (category, equipment_name, e_length, e_width, e_height, aircraft, in_use, has_defects, location, employee_id) 
VALUES ('Tow Bar', 'ACME 20Ton Steel Tow Bar', 3.3, 0.6, 1.1, 'A320', 1, 0, 'E28', '11111113');
INSERT INTO equipment (category, equipment_name, e_length, e_width, e_height, aircraft, in_use, has_defects, location, employee_id) 
VALUES ('Tow Bar', 'ACME 20Ton Steel Tow Bar', 3.3, 0.6, 1.1, 'A320', 1, 0, 'F41', '11111114');
INSERT INTO equipment (category, equipment_name, e_length, e_width, e_height, aircraft, in_use, has_defects, location, employee_id) 
VALUES ('Tow Bar', 'ACME 50Ton Titanium Tow Bar', 2.5, 0.5, 1.2, 'B787', 0, 1, 'B5', NULL);
INSERT INTO equipment (category, equipment_name, e_length, e_width, e_height, aircraft, in_use, has_defects, location, employee_id) 
VALUES ('Tow Bar', 'ACME 50Ton Titanium Tow Bar', 2.5, 0.5, 1.2, 'B787', 0, 1, 'C26', NULL);
INSERT INTO equipment (category, equipment_name, e_length, e_width, e_height, aircraft, in_use, has_defects, location, employee_id) 
VALUES ('Tow Bar', 'ACME 20Ton Steel Tow Bar', 3.3, 0.6, 1.1, 'A320', 0, 0, 'E10', NULL);
INSERT INTO equipment (category, equipment_name, e_length, e_width, e_height, aircraft, in_use, has_defects, location, employee_id) 
VALUES ('Tow Bar', 'ACME 20Ton Steel Tow Bar', 3.3, 0.6, 1.1, 'A320', 0, 0, 'F60', NULL);

INSERT INTO equipment (category, equipment_name, e_length, e_width, e_height, aircraft, in_use, has_defects, location, employee_id) 
VALUES ('Ground Power Unit', 'VG GPU 40KW', 2.0, 1.1, 1.5, 'A320', 1, 1, 'F30', '11111115');
INSERT INTO equipment (category, equipment_name, e_length, e_width, e_height, aircraft, in_use, has_defects, location, employee_id) 
VALUES ('Ground Power Unit', 'VG GPU 40KW', 2.0, 1.1, 1.5, 'A320', 1, 1, 'D34', '11111116');
INSERT INTO equipment (category, equipment_name, e_length, e_width, e_height, aircraft, in_use, has_defects, location, employee_id) 
VALUES ('Ground Power Unit', 'VG GPU 80KW', 2.2, 1.7, 1.6, 'A330', 1, 0, 'E7', '11111115');
INSERT INTO equipment (category, equipment_name, e_length, e_width, e_height, aircraft, in_use, has_defects, location, employee_id) 
VALUES ('Ground Power Unit', 'VG GPU 80KW', 2.2, 1.7, 1.6, 'A330', 1, 0, 'C22', '11111116');
INSERT INTO equipment (category, equipment_name, e_length, e_width, e_height, aircraft, in_use, has_defects, location, employee_id) 
VALUES ('Ground Power Unit', 'VG GPU 40KW', 2.0, 1.1, 1.5, 'A320', 0, 1, 'A1', NULL);
INSERT INTO equipment (category, equipment_name, e_length, e_width, e_height, aircraft, in_use, has_defects, location, employee_id) 
VALUES ('Ground Power Unit', 'VG GPU 40KW', 2.0, 1.1, 1.5, 'A320', 0, 1, 'G15', NULL);
INSERT INTO equipment (category, equipment_name, e_length, e_width, e_height, aircraft, in_use, has_defects, location, employee_id) 
VALUES ('Ground Power Unit', 'VG GPU 80KW', 2.2, 1.7, 1.6, 'A330', 0, 0, 'C26', NULL);
INSERT INTO equipment (category, equipment_name, e_length, e_width, e_height, aircraft, in_use, has_defects, location, employee_id) 
VALUES ('Ground Power Unit', 'VG GPU 80KW', 2.2, 1.7, 1.6, 'A330', 0, 0, 'B10', NULL);

INSERT INTO equipment (category, equipment_name, e_length, e_width, e_height, aircraft, in_use, has_defects, location, employee_id) 
VALUES ('Step', 'ABC ALUMINIUM LOW STEP', 2.3, 1.8, 1.7, 'B777', 1, 1, 'D34', '11111111');
INSERT INTO equipment (category, equipment_name, e_length, e_width, e_height, aircraft, in_use, has_defects, location, employee_id) 
VALUES ('Step', 'ABC ALUMINIUM LOW STEP', 2.3, 1.8, 1.7, 'B777', 1, 1, 'A1', '11111111');
INSERT INTO equipment (category, equipment_name, e_length, e_width, e_height, aircraft, in_use, has_defects, location, employee_id) 
VALUES ('Step', 'ABC STEEL HIGH STEP', 3.5, 2.4, 4.0, 'A350', 1, 0, 'C26', '11111111');
INSERT INTO equipment (category, equipment_name, e_length, e_width, e_height, aircraft, in_use, has_defects, location, employee_id) 
VALUES ('Step', 'ABC STEEL HIGH STEP', 3.5, 2.4, 4.0, 'A350', 1, 0, 'G15', '11111111');
INSERT INTO equipment (category, equipment_name, e_length, e_width, e_height, aircraft, in_use, has_defects, location, employee_id) 
VALUES ('Step', 'ABC ALUMINIUM LOW STEP', 2.3, 1.8, 1.7, 'B777', 0, 1, 'B10', NULL);
INSERT INTO equipment (category, equipment_name, e_length, e_width, e_height, aircraft, in_use, has_defects, location, employee_id) 
VALUES ('Step', 'ABC ALUMINIUM LOW STEP', 2.3, 1.8, 1.7, 'B777', 0, 1, 'C22', NULL);
INSERT INTO equipment (category, equipment_name, e_length, e_width, e_height, aircraft, in_use, has_defects, location, employee_id) 
VALUES ('Step', 'ABC STEEL HIGH STEP', 3.5, 2.4, 4.0, 'A350', 0, 0, 'E7', NULL);
INSERT INTO equipment (category, equipment_name, e_length, e_width, e_height, aircraft, in_use, has_defects, location, employee_id) 
VALUES ('Step', 'ABC STEEL HIGH STEP', 3.5, 2.4, 4.0, 'A350', 0, 0, 'F30', NULL);

-- same favourites for 11111111 and 11111112
-- random favourites for 11111113
-- no favourites for 11111114
-- random favourites for 11111115
-- no favourites for 11111116
/* favourites table ----------------------------------------------------------------*/
INSERT INTO favourites VALUES ('11111111', 6);
INSERT INTO favourites VALUES ('11111111', 12);
INSERT INTO favourites VALUES ('11111111', 13);
INSERT INTO favourites VALUES ('11111111', 14);
INSERT INTO favourites VALUES ('11111111', 15);
INSERT INTO favourites VALUES ('11111111', 16);
INSERT INTO favourites VALUES ('11111111', 17);
INSERT INTO favourites VALUES ('11111111', 18);
INSERT INTO favourites VALUES ('11111111', 19);

INSERT INTO favourites VALUES ('11111112', 6);
INSERT INTO favourites VALUES ('11111112', 12);
INSERT INTO favourites VALUES ('11111112', 13);
INSERT INTO favourites VALUES ('11111112', 14);
INSERT INTO favourites VALUES ('11111112', 15);
INSERT INTO favourites VALUES ('11111112', 16);
INSERT INTO favourites VALUES ('11111112', 17);
INSERT INTO favourites VALUES ('11111112', 18);
INSERT INTO favourites VALUES ('11111112', 19);

INSERT INTO favourites VALUES ('11111113', 1);
INSERT INTO favourites VALUES ('11111113', 2);
INSERT INTO favourites VALUES ('11111113', 3);
INSERT INTO favourites VALUES ('11111113', 5);
INSERT INTO favourites VALUES ('11111113', 7);
INSERT INTO favourites VALUES ('11111113', 11);
INSERT INTO favourites VALUES ('11111113', 13);
INSERT INTO favourites VALUES ('11111113', 14);
INSERT INTO favourites VALUES ('11111113', 17);
INSERT INTO favourites VALUES ('11111113', 19);
INSERT INTO favourites VALUES ('11111113', 20);
INSERT INTO favourites VALUES ('11111113', 23);
INSERT INTO favourites VALUES ('11111113', 29);
INSERT INTO favourites VALUES ('11111113', 31);
INSERT INTO favourites VALUES ('11111113', 32);

INSERT INTO favourites VALUES ('11111115', 3);
INSERT INTO favourites VALUES ('11111115', 6);
INSERT INTO favourites VALUES ('11111115', 8);
INSERT INTO favourites VALUES ('11111115', 9);
INSERT INTO favourites VALUES ('11111115', 10);
INSERT INTO favourites VALUES ('11111115', 12);
INSERT INTO favourites VALUES ('11111115', 15);
INSERT INTO favourites VALUES ('11111115', 16);
INSERT INTO favourites VALUES ('11111115', 17);
INSERT INTO favourites VALUES ('11111115', 19);
INSERT INTO favourites VALUES ('11111115', 22);
INSERT INTO favourites VALUES ('11111115', 24);
INSERT INTO favourites VALUES ('11111115', 25);
INSERT INTO favourites VALUES ('11111115', 30);
INSERT INTO favourites VALUES ('11111115', 31);

-- /* defects table ----------------------------------------------------------------*/
INSERT INTO defects (equipment_id, description) VALUES (1, "HELLO WORLD");
INSERT INTO defects (equipment_id, description) VALUES (1, "0123456789");
INSERT INTO defects (equipment_id, description) VALUES (1, "TESTING!!!");
INSERT INTO defects (equipment_id, description) VALUES (1, "!@#$%^&*()");
INSERT INTO defects (equipment_id, description) VALUES (1, "Seatbelt frayed");
INSERT INTO defects (equipment_id, description) VALUES (1, "Gear knob missing");
INSERT INTO defects (equipment_id, description) VALUES (1, "Brakes spongy");
INSERT INTO defects (equipment_id, description) VALUES (1, "Handbrake stiff");
INSERT INTO defects (equipment_id, description) VALUES (1, "Horn too loud");
INSERT INTO defects (equipment_id, description) VALUES (1, "Signal light too dim");

INSERT INTO defects (equipment_id, description) VALUES (2, "Gear knob missing");
INSERT INTO defects (equipment_id, description) VALUES (2, "Brakes spongy");
INSERT INTO defects (equipment_id, description) VALUES (2, "Handbrake stiff");
INSERT INTO defects (equipment_id, description) VALUES (2, "Horn too loud");
INSERT INTO defects (equipment_id, description) VALUES (2, "Signal light too dim");

INSERT INTO defects (equipment_id, description) VALUES (5, "Right bolt loose");
INSERT INTO defects (equipment_id, description) VALUES (5, "Left bolt missing");
INSERT INTO defects (equipment_id, description) VALUES (5, "Seat worn");
INSERT INTO defects (equipment_id, description) VALUES (5, "Seatbelt frayed");
INSERT INTO defects (equipment_id, description) VALUES (5, "Gear knob missing");
INSERT INTO defects (equipment_id, description) VALUES (5, "Brakes spongy");
INSERT INTO defects (equipment_id, description) VALUES (5, "Handbrake stiff");

INSERT INTO defects (equipment_id, description) VALUES (6, "Horn too loud");
INSERT INTO defects (equipment_id, description) VALUES (6, "Signal light too dim");

INSERT INTO defects (equipment_id, description) VALUES (9, "Spare shear bolt missing");
INSERT INTO defects (equipment_id, description) VALUES (9, "Right wheel loose");
INSERT INTO defects (equipment_id, description) VALUES (9, "Left wheel low pressure");
INSERT INTO defects (equipment_id, description) VALUES (9, "Hydraulic pump leaking");
INSERT INTO defects (equipment_id, description) VALUES (9, "Hydraulic pump stiff");
INSERT INTO defects (equipment_id, description) VALUES (9, "Left spring rusty");
INSERT INTO defects (equipment_id, description) VALUES (9, "Paint peeling");
INSERT INTO defects (equipment_id, description) VALUES (9, "Locking handle stiff");
INSERT INTO defects (equipment_id, description) VALUES (9, "Hook grease dry");
INSERT INTO defects (equipment_id, description) VALUES (9, "Danger decal missing");

INSERT INTO defects (equipment_id, description) VALUES (10, "Hook grease dry");
INSERT INTO defects (equipment_id, description) VALUES (10, "Left wheel low pressure");
INSERT INTO defects (equipment_id, description) VALUES (10, "Hydraulic pump leaking");
INSERT INTO defects (equipment_id, description) VALUES (10, "Spare shear bolt missing");
INSERT INTO defects (equipment_id, description) VALUES (10, "Right wheel loose");
INSERT INTO defects (equipment_id, description) VALUES (10, "Paint peeling");
INSERT INTO defects (equipment_id, description) VALUES (10, "Locking handle stiff");
INSERT INTO defects (equipment_id, description) VALUES (10, "Hydraulic pump stiff");
INSERT INTO defects (equipment_id, description) VALUES (10, "Left spring rusty");

INSERT INTO defects (equipment_id, description) VALUES (13, "Hydraulic pump stiff");
INSERT INTO defects (equipment_id, description) VALUES (13, "Paint peeling");
INSERT INTO defects (equipment_id, description) VALUES (13, "Locking handle stiff");
INSERT INTO defects (equipment_id, description) VALUES (13, "Hook grease dry");
INSERT INTO defects (equipment_id, description) VALUES (13, "Spare shear bolt missing");
INSERT INTO defects (equipment_id, description) VALUES (13, "Right wheel loose");
INSERT INTO defects (equipment_id, description) VALUES (13, "Left wheel low pressure");
INSERT INTO defects (equipment_id, description) VALUES (13, "Danger decal missing");
INSERT INTO defects (equipment_id, description) VALUES (13, "Left spring rusty");

INSERT INTO defects (equipment_id, description) VALUES (14, "Spare shear bolt missing");
INSERT INTO defects (equipment_id, description) VALUES (14, "Right wheel loose");
INSERT INTO defects (equipment_id, description) VALUES (14, "Left wheel low pressure");
INSERT INTO defects (equipment_id, description) VALUES (14, "Hydraulic pump leaking");
INSERT INTO defects (equipment_id, description) VALUES (14, "Left spring rusty");
INSERT INTO defects (equipment_id, description) VALUES (14, "Paint peeling");
INSERT INTO defects (equipment_id, description) VALUES (14, "Hook grease dry");
INSERT INTO defects (equipment_id, description) VALUES (14, "Danger decal missing");
INSERT INTO defects (equipment_id, description) VALUES (14, "Hydraulic pump stiff");

INSERT INTO defects (equipment_id, description) VALUES (17, "Emergency stop button wobbly");
INSERT INTO defects (equipment_id, description) VALUES (17, "External power plug 1 loose");
INSERT INTO defects (equipment_id, description) VALUES (17, "External power plug 2 hook missing");
INSERT INTO defects (equipment_id, description) VALUES (17, "External power cable 1 dirty");
INSERT INTO defects (equipment_id, description) VALUES (17, "External power cable 2 dirty");
INSERT INTO defects (equipment_id, description) VALUES (17, "LCD screen blur");
INSERT INTO defects (equipment_id, description) VALUES (17, "Power on LED spoilt");
INSERT INTO defects (equipment_id, description) VALUES (17, "Power off button stiff");
INSERT INTO defects (equipment_id, description) VALUES (17, "Oil level low");
INSERT INTO defects (equipment_id, description) VALUES (17, "Excessive exhaust sound");

INSERT INTO defects (equipment_id, description) VALUES (18, "Power off button stiff");
INSERT INTO defects (equipment_id, description) VALUES (18, "Oil level low");
INSERT INTO defects (equipment_id, description) VALUES (18, "Excessive exhaust sound");
INSERT INTO defects (equipment_id, description) VALUES (18, "Emergency stop button wobbly");
INSERT INTO defects (equipment_id, description) VALUES (18, "External power plug 1 loose");
INSERT INTO defects (equipment_id, description) VALUES (18, "External power plug 2 hook missing");

INSERT INTO defects (equipment_id, description) VALUES (21, "Oil level low");

INSERT INTO defects (equipment_id, description) VALUES (22, "Power off button stiff");

INSERT INTO defects (equipment_id, description) VALUES (25, "Left wheel loose");
INSERT INTO defects (equipment_id, description) VALUES (25, "Right forward cushion missing");
INSERT INTO defects (equipment_id, description) VALUES (25, "Right aft cushion broken");
INSERT INTO defects (equipment_id, description) VALUES (25, "Right stopper stiff");
INSERT INTO defects (equipment_id, description) VALUES (25, "Left stopped spring missing");
INSERT INTO defects (equipment_id, description) VALUES (25, "Forward footguard bent");
INSERT INTO defects (equipment_id, description) VALUES (25, "Left grab bar bent");
INSERT INTO defects (equipment_id, description) VALUES (25, "Bottom step slippery");
INSERT INTO defects (equipment_id, description) VALUES (25, "Anti slip strip missing");
INSERT INTO defects (equipment_id, description) VALUES (25, "Caution decal missing");

INSERT INTO defects (equipment_id, description) VALUES (26, "Bottom step slippery");
INSERT INTO defects (equipment_id, description) VALUES (26, "Anti slip strip missing");
INSERT INTO defects (equipment_id, description) VALUES (26, "Left wheel loose");
INSERT INTO defects (equipment_id, description) VALUES (26, "Caution decal missing");

INSERT INTO defects (equipment_id, description) VALUES (29, "Anti slip strip missing");
INSERT INTO defects (equipment_id, description) VALUES (29, "Caution decal missing");
INSERT INTO defects (equipment_id, description) VALUES (29, "Left wheel loose");

INSERT INTO defects (equipment_id, description) VALUES (30, "Forward footguard bent");
INSERT INTO defects (equipment_id, description) VALUES (30, "Anti slip strip missing");
INSERT INTO defects (equipment_id, description) VALUES (30, "Right stopper stiff");
INSERT INTO defects (equipment_id, description) VALUES (30, "Left stopped spring missing");
INSERT INTO defects (equipment_id, description) VALUES (30, "Right forward cushion missing");
INSERT INTO defects (equipment_id, description) VALUES (30, "Caution decal missing");
INSERT INTO defects (equipment_id, description) VALUES (30, "Left wheel loose");
INSERT INTO defects (equipment_id, description) VALUES (30, "Right aft cushion broken");




