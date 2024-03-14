CREATE OR REPLACE PROCEDURE delete_data()
LANGUAGE 'plpgsql'
AS $$
BEGIN
	DELETE FROM products
	WHERE count = 0;
END;
$$;

CALL delete_data();

