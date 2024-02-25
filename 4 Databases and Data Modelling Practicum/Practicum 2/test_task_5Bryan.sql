/* 
1. CHECK TABLE - order_details
should have 5 orders, with the last 4 orders for 00000904, 
and the last 3 orders have 5% discount

2. CHECK TABLE - product
QTY for 00000904 should be 60 after QTY 40 has been purchased

3. CHECK TABLE - product
QTY for 00000904 should be 0 after QTY 60 has been purchased

4. CHECK TABLE - supplier_order
The second order should be for 00000904, undelivered after 00000904 QTY dropped to 0

5. CHECK TABLE - product
QTY for 00000904 should be 60 after updating 00000904 QTY 60

6. CHECK TABLE - supplier_order
The second order should be for 00000904, delivered

7. CHECK TABLE - payment NATURAL JOIN shipping_order
There should be 3 payments (1 payment is initially already in the table, and 2 payments just made) and 2 shipping orders placed

8. CHECK TABLE - supplier order
The third order should be for 00000904, undelivered after 00000904 QTY dropped to 10

9. CHECK TABLE - supplier order
The third order should be for 00000904, delivered after 00000904 QTY updated to 50

ERROR: Pay for the third order of QTY 60 of 00000904
This is just to crash the code since remaining stock is QTY 50
*/

/*---------------------------------------------------------------------------------------------------------------------------------*/
/* MAKING ORDERS*/

/* Place order for QTY 40 of 00000904 and 
should not have 5% discount*/
INSERT INTO order_detail (order_detail_id, employee_id, product_id, cust_id,
quantity, unit_price)
SELECT 'x0000002', '00000001', '00000904', '00004002', 40, p.unit_price
FROM product AS p
WHERE p.product_id = '00000904';

/* Place order for QTY 60 of 00000904 and 
should have 5% discount*/
INSERT INTO order_detail (order_detail_id, employee_id, product_id, cust_id,
quantity, unit_price)
SELECT 'x0000003', '00000001', '00000904', '00004002', 60, p.unit_price
FROM product AS p
WHERE p.product_id = '00000904';

/* Place order for QTY 50 of 00000904 and 
should have 5% discount*/
INSERT INTO order_detail (order_detail_id, employee_id, product_id, cust_id,
quantity, unit_price)
SELECT 'x0000004', '00000001', '00000904', '00004002', 50, p.unit_price
FROM product AS p
WHERE p.product_id = '00000904';

/* Place order for QTY 60 of 00000904 and 
should have 5% discount*/
INSERT INTO order_detail (order_detail_id, employee_id, product_id, cust_id,
quantity, unit_price)
SELECT 'x0000005', '00000001', '00000904', '00004002', 60, p.unit_price
FROM product AS p
WHERE p.product_id = '00000904';

/* 1. CHECK TABLE - order_details
should have 5 orders, with the last 4 orders for 00000904, 
and the last 3 orders have 5% discount*/
SELECT * FROM order_detail;

/*---------------------------------------------------------------------------------------------------------------------------------*/
/* MAKING PAYMENTS AND UPDATING STOCK*/

/* Included this just to insert a shipping order for an item that is not 00000904*/
UPDATE product SET remaining_stock = 0 WHERE product_id = '00000902';

/* Pay for the first order of QTY 40 of 00000904*/
CALL process_payment ("x0000002","CREDIT CARD","12345","05/02/2025","TestTest","NINJAVAN","BISHAN");
/* 2. CHECK TABLE - product
QTY for 00000904 should be 60*/
SELECT * FROM product WHERE product_id = (SELECT product_id FROM order_detail WHERE order_detail_id='x0000002');

/* Pay for the second order of QTY 60 of 00000904*/
CALL process_payment ("x0000003","CREDIT CARD","12345","05/02/2025","TestTest","NINJAVAN","AMK");
/* 3. CHECK TABLE - product
QTY for 00000904 should be 0*/
SELECT * FROM product WHERE product_id = (SELECT product_id FROM order_detail WHERE order_detail_id='x0000003');
/* 4. CHECK TABLE - supplier_order
The second order should be for 00000904, undelivered*/
SELECT * FROM supplier_order;

/*Update the QTY for 00000904 to QTY 60*/
UPDATE product SET remaining_stock = 60 WHERE product_id = '00000904';
/* 5. CHECK TABLE - product
QTY for 00000904 should be 60*/
SELECT * FROM product WHERE product_id='00000904';
/* 6. CHECK TABLE - supplier_order
The second order should be for 00000904, delivered*/
SELECT * FROM supplier_order;

/* Pay for the third order of QTY 50 of 00000904*/
CALL process_payment ("x0000004","CREDIT CARD","12345","05/02/2025","TestTest","NINJAVAN","TPY");
/* 7. CHECK TABLE - payment NATURAL JOIN shipping_order
There should be 3 payments and shipping orders placed*/
SELECT * FROM payment NATURAL JOIN shipping_order;
/* 8. CHECK TABLE - supplier order
The third order should be for 00000904, undelivered*/
SELECT * FROM supplier_order;

UPDATE product SET remaining_stock = 50 WHERE product_id = '00000904';
/* 9. CHECK TABLE - supplier order
The third order should be for 00000904, delivered*/
SELECT * FROM supplier_order;

/*ERROR: Pay for the third order of QTY 60 of 00000904
This is just to crash the code since remaining stock is QTY 50*/
CALL process_payment ("x0000005","CREDIT CARD","12345","05/02/2025","TestTest","NINJAVAN","TPY");
