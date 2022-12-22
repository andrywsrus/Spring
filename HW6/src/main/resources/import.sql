
DROP TABLE IF EXISTS products CASCADE;
DROP TABLE IF EXISTS customers CASCADE;
DROP TABLE IF EXISTS orders CASCADE;

CREATE TABLE IF NOT EXISTS  customers(id bigint auto_increment, name varchar(255) not null, PRIMARY KEY(id));
CREATE TABLE IF NOT EXISTS  products(id bigint auto_increment, title varchar(255) not null, price integer not null, PRIMARY KEY(id));
CREATE TABLE IF NOT EXISTS orders(id bigint auto_increment, customer_id bigint, product_id bigint, price bigint, FOREIGN KEY(customer_id) REFERENCES customers(id), FOREIGN KEY(product_id) REFERENCES products(id), PRIMARY KEY(id));

INSERT into customers(name) values ('CostomerSurname'),('Chestnov'), ('Shupeyko');
INSERT into products(title, price) values ('Tomata', 10),('Milk', 20),('Cucumber', 30);
INSERT into orders(customer_id, product_id, price) values (1, 1, 11),(1, 2, 22), (1, 3, 33);


