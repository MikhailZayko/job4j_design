CREATE OR REPLACE FUNCTION f_delete_data(d_id INT)
RETURNS VOID
LANGUAGE 'plpgsql'
AS $$
BEGIN
	DELETE FROM products
	WHERE id = d_id;
END;
$$;

SELECT f_delete_data(1);