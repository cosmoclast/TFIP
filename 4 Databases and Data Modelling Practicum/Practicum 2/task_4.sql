DROP TRIGGER IF EXISTS after_product_update;

DELIMITER //

CREATE TRIGGER after_product_update AFTER UPDATE ON product
	FOR EACH ROW
	BEGIN			
		IF (SELECT remaining_stock FROM product WHERE product.product_id = NEW.product_id) <= 10 THEN
			#checking whether this is the first order from supplier for this product
			IF (SELECT COUNT(delivered) FROM supplier_order WHERE supplier_order.product_id = NEW.product_id) = 0 THEN 
				INSERT INTO supplier_order (product_id, stock) VALUES (NEW.product_id, OLD.max_stock - NEW.remaining_stock);
			#checking whether prev delivery in in transit or arrived
			ELSEIF (SELECT COUNT(delivered) FROM supplier_order WHERE supplier_order.product_id = NEW.product_id AND supplier_order.delivered = 0) = 0 THEN 
				INSERT INTO supplier_order (product_id, stock) VALUES (NEW.product_id, OLD.max_stock - NEW.remaining_stock);
			END IF;
		ELSE
			UPDATE supplier_order SET delivered = 1 WHERE supplier_order.product_id = NEW.product_id;
		END IF;	
	END //
	
DELIMITER ;