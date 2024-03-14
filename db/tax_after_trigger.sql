CREATE OR REPLACE FUNCTION tax_after()
RETURNS TRIGGER AS
$$
BEGIN
	UPDATE products
	set price = price + price * 0.2
	WHERE id = (SELECT id FROM inserted);
	RETURN NEW;
END;
$$
LANGUAGE 'plpgsql';

CREATE TRIGGER tax_after_trigger
AFTER INSERT
ON products
REFERENCING NEW TABLE AS inserted
FOR EACH STATEMENT
EXECUTE PROCEDURE tax_after();