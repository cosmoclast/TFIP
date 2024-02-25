DROP FUNCTION IF EXISTS est_remaining_stock;

DELIMITER //

CREATE FUNCTION est_remaining_stock (sell_unit INT, product_id CHAR(8))
	RETURNS INT
	BEGIN
		DECLARE remaining_stock INT;
			SELECT (product.remaining_stock - sell_unit) INTO remaining_stock
			FROM product 
			WHERE product.product_id = product_id;
		RETURN remaining_stock;
	END //
	
DELIMITER ;











