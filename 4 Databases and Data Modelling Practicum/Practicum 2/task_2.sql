DROP FUNCTION IF EXISTS total_payable;

DELIMITER //

CREATE FUNCTION total_payable (order_detail_id CHAR(8))
	RETURNS DECIMAL(15,2)
	BEGIN
		DECLARE total_amt DECIMAL(17,2);
			SELECT ((CEILING((order_detail.quantity * order_detail.unit_price * (1-order_detail.discount)) * 100)) / 100) INTO total_amt
			FROM order_detail
			WHERE UPPER(order_detail.order_detail_id) = UPPER(order_detail_id);
		RETURN total_amt;
	END //
	
DELIMITER ;







