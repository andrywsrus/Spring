DROP TABLE IF EXISTS products;
CREATE TABLE IF NOT EXISTS  products(id bigint auto_increment, title varchar(255) not null, price integer not null, PRIMARY KEY(id));
insert into products(title, price) values ('Tomato', 10),('Milk', 20), ('Cucumber', 30);