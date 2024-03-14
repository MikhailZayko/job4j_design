CREATE OR REPLACE FUNCTION history_of_price_func()
RETURNS TRIGGER AS
$$
BEGIN
	INSERT INTO history_of_price (name, price, date) VALUES
	(NEW.name, NEW.price, current_date);
	RETURN NEW;
END;
$$
LANGUAGE 'plpgsql';

CREATE TRIGGER history_of_price_trigger
AFTER INSERT
ON products
FOR EACH ROW
EXECUTE PROCEDURE history_of_price_func();