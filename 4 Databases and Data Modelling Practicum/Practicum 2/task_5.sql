DROP PROCEDURE IF EXISTS process_payment;

DELIMITER //

CREATE PROCEDURE 
	process_payment 
	(IN order_detail_id CHAR(8), 
	IN payment_method VARCHAR(20), 
	IN cc_no VARCHAR(20), 
	IN cc_exp_date VARCHAR(10), 
	IN cc_owner_name VARCHAR(100), 
	IN shipping_mtd VARCHAR(50), 
	IN shipping_addr VARCHAR(500))
	
	BEGIN
		DECLARE sell_unit INT;
		DECLARE prod_id CHAR(8);
		DECLARE payment_amt DECIMAL(15,2);
		
		SET sell_unit = (SELECT quantity FROM order_detail WHERE order_detail.order_detail_id = order_detail_id);
		SET prod_id = (SELECT order_detail.product_id FROM order_detail WHERE order_detail.order_detail_id = order_detail_id); 
		SET payment_amt = (SELECT total_payable(order_detail_id));
		
		#error message if stock below 10
		IF (SELECT est_remaining_stock(sell_unit, prod_id)) < 0 THEN
			SIGNAL SQLSTATE "45000" SET MESSAGE_TEXT = "UNABLE TO PROCESS PAYMENT";
		ELSE
			#insert payment details
			INSERT INTO payment (order_detail_id, pay_method, pay_amt, cc_no, cc_exp_date, cc_owner_name) 
			VALUES (order_detail_id, payment_method, payment_amt, cc_no, cc_exp_date, cc_owner_name);
			
			#update product table remaining stock
			UPDATE product SET remaining_stock = remaining_stock - sell_unit WHERE product_id = prod_id;
			
			#insert shipping order details
			INSERT INTO shipping_order (order_detail_id, shipping_method, shipping_addr) 
			VALUES (order_detail_id, shipping_mtd, shipping_addr); 	
		END IF;	
	END //

DELIMITER ;