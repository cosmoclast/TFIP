UPDATE product SET remaining_stock = 100 WHERE product_id = '00000906';

INSERT INTO order_detail (order_detail_id, employee_id, product_id, cust_id,
quantity, unit_price)
SELECT 'x0000002', '00000001', '00000906', '00004002', 49, p.unit_price
FROM product AS p
WHERE p.product_id = '00000906';

SELECT total_payable("x0000002");
/*output should be 1442.5845 but rounded up to 1442.59*/