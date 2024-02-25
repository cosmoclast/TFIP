DROP TRIGGER IF EXISTS before_order;

DELIMITER //

CREATE TRIGGER before_order BEFORE INSERT ON order_detail
	FOR EACH ROW
	BEGIN
		#error message if stock below 10
		IF (SELECT est_remaining_stock(NEW.quantity, NEW.product_id)) < 10 THEN
			SIGNAL SQLSTATE "45000" SET MESSAGE_TEXT = "STOCK CANNOT DROP BELOW 10";		
		ELSE 
			#update the discount to 0.05
			IF (NEW.quantity > 40) THEN
				SET NEW.discount = 0.05; 
			ELSE
				SET NEW.discount = 0;
			END IF;
		END IF;	
	END //

DELIMITER ; 		