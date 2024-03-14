CREATE OR REPLACE FUNCTION tax_before()
RETURNS TRIGGER AS
$$
BEGIN
	NEW.price = NEW.price + NEW.price * 0.2;
	RETURN NEW;
END;
$$ 
LANGUAGE 'plpgsql';

CREATE TRIGGER tax_before_trigger
BEFORE INSERT 
ON products
FOR EACH ROW
EXECUTE PROCEDURE tax_before();
