CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

INSERT INTO company (id, name) VALUES
    (1, 'Company A'),
    (2, 'Company B'),
    (3, 'Company C'),
    (4, 'Company D'),
    (5, 'Company E');

INSERT INTO person (id, name, company_id) VALUES
    (1, 'John', 1),
    (2, 'Alice', 1),
    (3, 'Bob', 1),
    (4, 'Emma', 2),
    (5, 'Mike', 2),
    (6, 'Sarah', 2),
    (7, 'David', 5),
    (8, 'Emily', 5),
    (9, 'James', 5);

INSERT INTO person (id, name, company_id) VALUES
    (10, 'Tom', 3),
    (11, 'Olivia', 3),
    (12, 'Daniel', 3),
    (13, 'Sophia', 3),
    (14, 'Liam', 4),
    (15, 'Mia', 4),
    (16, 'Ethan', 4),
    (17, 'Ava', 4);
	
INSERT INTO person (id, name) VALUES
	(18, 'No Company Person 1'),
	(19, 'No Company Person 2');
