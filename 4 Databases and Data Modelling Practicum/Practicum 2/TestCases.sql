Test Cases for Task 1
Current stock = 44
SQL statement: SELECT est_remaining_stock(4, '00000905');
Output = 40
Current stock = 4
SQL statement: SELECT est_remaining_stock(4, '00000905');
Output = 0
Current stock = 4
SQL statement: SELECT est_remaining_stock(8, '00000905');
Output = -4


Test Cases for Task 2
order_detail_id = x0000001 (record available from the populate_tables.sql )
SQL statement: SELECT total_payable('x0000001');
Output = 523.60


Test Cases for Task 3
Current stock = 50
SQL statement:
INSERT INTO order_detail (order_detail_id, employee_id, product_id, cust_id,
quantity, unit_price)
SELECT 'x0000002', '00000001', '00000905', '00004002', 41, p.unit_price
FROM product AS p
WHERE p.product_id = '00000905';
Output: Error message shown

Current stock = 50
SQL statement:
INSERT INTO order_detail (order_detail_id, employee_id, product_id, cust_id,
quantity, unit_price)
SELECT 'x0000002', '00000001', '00000905', '00004002', 40, p.unit_price
FROM product AS p
WHERE p.product_id = '00000905';
Output: Order created.

Current stock = 100
SQL statement:
INSERT INTO order_detail (order_detail_id, employee_id, product_id, cust_id,
quantity, unit_price)
SELECT 'x0000002', '00000001', '00000904', '00004002', 41, p.unit_price
FROM product AS p
WHERE p.product_id = '00000904';
INSERT INTO order_detail (order_detail_id, employee_id, product_id, cust_id,
quantity, unit_price)
SELECT 'x0000003', '00000001', '00000904', '00004002', 4, p.unit_price
FROM product AS p
WHERE p.product_id = '00000904';
Output: 2 orders created. The order with 41 items purchased has a 5% discount added.


Test Cases for Task 4
SQL statement: UPDATE product SET remaining_stock = 4 WHERE product_id = '00000905';
Output: Supplier order created for 96 items
SQL statement: UPDATE product SET remaining_stock = 80 WHERE product_id = '00000905';
Output: Previous supplier order delivered set to 1 (aka true )