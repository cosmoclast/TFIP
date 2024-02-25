/*
#Test Case 1: Testing whether the discount is updated correctly
INSERT INTO order_detail (order_detail_id, employee_id, product_id, cust_id, quantity, unit_price, discount) 
SELECT 'x0000001', '00000001', '00000901', '00004001', 77, p.unit_price, 0
FROM product AS p 
WHERE p.product_id = '00000901';

INSERT INTO order_detail (order_detail_id, employee_id, product_id, cust_id, quantity, unit_price, discount) 
SELECT 'x0000002', '00000002', '00000902', '00004002', 10, p.unit_price, 0
FROM product AS p
WHERE p.product_id = '00000902';

INSERT INTO order_detail (order_detail_id, employee_id, product_id, cust_id, quantity, unit_price, discount) 
SELECT 'x0000003', '00000003', '00000903', '00004003', 41, p.unit_price, 0
FROM product AS p
WHERE p.product_id = '00000903';

INSERT INTO order_detail (order_detail_id, employee_id, product_id, cust_id, quantity, unit_price, discount) 
SELECT 'x0000004', '00000004', '00000904', '00004004', 40, p.unit_price, 0
FROM product AS p
WHERE p.product_id = '00000904';

INSERT INTO order_detail (order_detail_id, employee_id, product_id, cust_id, quantity, unit_price, discount) 
SELECT 'x0000005', '00000005', '00000905', '00004005', 30, p.unit_price, 0
FROM product AS p
WHERE p.product_id = '00000905';

INSERT INTO order_detail (order_detail_id, employee_id, product_id, cust_id, quantity, unit_price, discount) 
SELECT 'x0000007', '00000003', '00000903', '00004003', 49, p.unit_price, 0
FROM product AS p
WHERE p.product_id = '00000906';

INSERT INTO order_detail (order_detail_id, employee_id, product_id, cust_id, quantity, unit_price, discount) 
SELECT 'x0000008', '00000003', '00000903', '00004003', 5, p.unit_price, 0
FROM product AS p
WHERE p.product_id = '00000903';

INSERT INTO order_detail (order_detail_id, employee_id, product_id, cust_id, quantity, unit_price, discount) 
SELECT 'x0000009', '00000003', '00000903', '00004003', 5, p.unit_price, 0
FROM product AS p
WHERE p.product_id = '00000903';

INSERT INTO order_detail (order_detail_id, employee_id, product_id, cust_id, quantity, unit_price, discount) 
SELECT 'x0000010', '00000003', '00000903', '00004003', 5, p.unit_price, 0
FROM product AS p
WHERE p.product_id = '00000903';

INSERT INTO order_detail (order_detail_id, employee_id, product_id, cust_id, quantity, unit_price, discount) 
SELECT 'x0000006', '00000006', '00000906', '00004005', 21, p.unit_price, 0
FROM product AS p
WHERE p.product_id = '00000903';
*/

/*
#Test Case 2: Testing shipping order is correct, testing supplier order is correct, payment is correct, testing rejection of payment if no stock.
CALL process_payment ('x0000001', 'CASH', NULL, NULL, NULL, 'FEDEX1', '236 Hegeman Avenue, Poland');
CALL process_payment ('x0000002', 'CASH', NULL, NULL, NULL, 'FEDEX2', '859 Strickland Avenue, Qatar');
CALL process_payment ('x0000003', 'CASH', NULL, NULL, NULL, 'FEDEX3', '544 Bushwick Place, Honduras');
CALL process_payment ('x0000004', 'CASH', NULL, NULL, NULL, 'FEDEX4', '538 Noel Avenue, Germany');
CALL process_payment ('x0000005', 'CASH', NULL, NULL, NULL, 'FEDEX5', '547 Porter Avenue, Latvia');
CALL process_payment ('x0000007', 'CREDIT', '1234 4567 8900 0000', '01/2026', 'FEDEX3', 'FEDEX3', '544 Bushwick Place, Honduras');
CALL process_payment ('x0000008', 'CREDIT', '1234 4567 8900 0000', '01/2026', 'FEDEX3', 'FEDEX3', '544 Bushwick Place, Honduras');
CALL process_payment ('x0000009', 'CREDIT', '1234 4567 8900 0000', '01/2026', 'FEDEX3', 'FEDEX3', '544 Bushwick Place, Honduras');
CALL process_payment ('x0000010', 'CREDIT', '1234 4567 8900 0000', '01/2026', 'FEDEX3', 'FEDEX3', '544 Bushwick Place, Honduras');
*/

/*
#Test Case 3: Testing supplier order works correctly, ie. task 4 works correctly and does not allow an order that has already been paid to go through
UPDATE product SET remaining_stock = 0 WHERE product_id = '00000901';
UPDATE product SET remaining_stock = 0 WHERE product_id = '00000902';
UPDATE product SET remaining_stock = 5 WHERE product_id = '00000903';
UPDATE product SET remaining_stock = 9 WHERE product_id = '00000903';
UPDATE product SET remaining_stock = 10 WHERE product_id = '00000903';
UPDATE product SET remaining_stock = 140 WHERE product_id = '00000903';
UPDATE product SET remaining_stock = 140 WHERE product_id = '00000903';
UPDATE product SET remaining_stock = 140 WHERE product_id = '00000903';
CALL process_payment ('x0000010', 'CREDIT', '1234 4567 8900 0000', '01/2026', 'FEDEX3', 'FEDEX3', '544 Bushwick Place, Honduras');
CALL process_payment ('x0000010', 'CREDIT', '1234 4567 8900 0000', '01/2026', 'FEDEX3', 'FEDEX3', '544 Bushwick Place, Honduras');
*/


#Test Case 4: Testing supplier order works correctly, ie. task 4 works correctly and does not allow an order that has already been paid to go through
INSERT INTO order_detail (order_detail_id, employee_id, product_id, cust_id, quantity, unit_price, discount) 
SELECT 'x0000011', '00000003', '00000903', '00004003', 125, p.unit_price, 0
FROM product AS p
WHERE p.product_id = '00000903';

CALL process_payment ('x0000011', 'CREDIT', '1234 4567 8900 0000', '01/2026', 'FEDEX3', 'FEDEX3', '544 Bushwick Place, Honduras');

UPDATE product SET remaining_stock = 5 WHERE product_id = '00000903';
UPDATE product SET remaining_stock = 9 WHERE product_id = '00000903';
UPDATE product SET remaining_stock = 10 WHERE product_id = '00000903';
UPDATE product SET remaining_stock = 150 WHERE product_id = '00000903';
UPDATE product SET remaining_stock = 150 WHERE product_id = '00000903';
UPDATE product SET remaining_stock = 150 WHERE product_id = '00000903';

INSERT INTO order_detail (order_detail_id, employee_id, product_id, cust_id, quantity, unit_price, discount) 
SELECT 'x0000012', '00000003', '00000903', '00004003', 140, p.unit_price, 0
FROM product AS p
WHERE p.product_id = '00000903';

CALL process_payment ('x0000012', 'CREDIT', '1234 4567 8900 0000', '01/2026', 'FEDEX3', 'FEDEX3', '544 Bushwick Place, Honduras');

UPDATE product SET remaining_stock = 5 WHERE product_id = '00000903';
UPDATE product SET remaining_stock = 9 WHERE product_id = '00000903';
UPDATE product SET remaining_stock = 10 WHERE product_id = '00000903';
UPDATE product SET remaining_stock = 150 WHERE product_id = '00000903';
UPDATE product SET remaining_stock = 150 WHERE product_id = '00000903';
UPDATE product SET remaining_stock = 150 WHERE product_id = '00000903';

INSERT INTO order_detail (order_detail_id, employee_id, product_id, cust_id, quantity, unit_price, discount) 
SELECT 'x0000013', '00000003', '00000903', '00004003', 20, p.unit_price, 0
FROM product AS p
WHERE p.product_id = '00000903';

INSERT INTO order_detail (order_detail_id, employee_id, product_id, cust_id, quantity, unit_price, discount) 
SELECT 'x0000014', '00000003', '00000903', '00004003', 140, p.unit_price, 0
FROM product AS p
WHERE p.product_id = '00000903';

CALL process_payment ('x0000013', 'CREDIT', '1234 4567 8900 0000', '01/2026', 'FEDEX3', 'FEDEX3', '544 Bushwick Place, Honduras');
CALL process_payment ('x0000014', 'CREDIT', '1234 4567 8900 0000', '01/2026', 'FEDEX3', 'FEDEX3', '544 Bushwick Place, Honduras');



