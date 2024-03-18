start transaction;

declare curs_products scroll cursor for select * from products;

fetch last from curs_products;

move backward 4 from curs_products;

fetch prior from curs_products;

move backward 7 from curs_products;

fetch prior from curs_products;

move backward 4 from curs_products;

fetch prior from curs_products;

fetch prior from curs_products;

close curs_products;

commit;