create database BikeStores
use BikeStores
CREATE TABLE customers (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    phone VARCHAR(25),
    email VARCHAR(255),
    street VARCHAR(255),
    city VARCHAR(50),
    state VARCHAR(25),
    zip_code VARCHAR(5)
);
CREATE TABLE categories (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(255)
);

CREATE TABLE brands (
    brand_id INT AUTO_INCREMENT PRIMARY KEY,
    brand_name VARCHAR(255)
);

CREATE TABLE products (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(255),
    brand_id INT,
    category_id INT,
    model_year SMALLINT,
    list_price DECIMAL(10,2),
    FOREIGN KEY (brand_id) REFERENCES brands(brand_id),
    FOREIGN KEY (category_id) REFERENCES categories(category_id)
);
CREATE TABLE stores (
    store_id INT AUTO_INCREMENT PRIMARY KEY,
    store_name VARCHAR(255),
    phone VARCHAR(25),
    email VARCHAR(255),
    street VARCHAR(255),
    city VARCHAR(255),
    state VARCHAR(10),
    zip_code VARCHAR(5)
);
CREATE TABLE staffs (
    staff_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(255),
    phone VARCHAR(25),
    active TINYINT,
    store_id INT,
    manager_id INT,
    FOREIGN KEY (store_id) REFERENCES stores(store_id),
    FOREIGN KEY (manager_id) REFERENCES staffs(staff_id)
);
CREATE TABLE stocks (
    store_id INT,
    product_id INT,
    quantity INT,
    PRIMARY KEY (store_id, product_id),
    FOREIGN KEY (store_id) REFERENCES stores(store_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);
CREATE TABLE orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    order_status TINYINT,
    order_date DATE,
    required_date DATE,
    shipped_date DATE,
    store_id INT,
    staff_id INT,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
    FOREIGN KEY (store_id) REFERENCES stores(store_id),
    FOREIGN KEY (staff_id) REFERENCES staffs(staff_id)
);
CREATE TABLE order_items (
    order_id INT,
    item_id INT,
    product_id INT,
    quantity INT,
    list_price DECIMAL(10,2),
    discount DECIMAL(4,2),
    PRIMARY KEY (order_id, item_id),
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);
INSERT INTO brands (brand_name) VALUES
('Electra'),
('Haro'),
('Heller'),
('Pure Cycles'),
('Ritchey'),
('Strider'),
('Sun Bicycles'),
('Surly'),
('Trek');
------------
INSERT INTO categories (category_name) VALUES
('Children Bicycles'),
('Comfort Bicycles'),
('Cruisers Bicycles'),
('Cyclocross Bicycles'),
('Electric Bikes'),
('Mountain Bikes'),
('Road Bikes');
-----------------
INSERT INTO products (product_name, brand_id, category_id, model_year, list_price) VALUES
('Trek 820 - 2016', 9, 6, 2016, 379.99),
('Ritchey Timberwolf Frameset - 2016', 5, 6, 2016, 749.99),
('Surly Wednesday Frameset - 2016', 8, 6, 2016, 999.99),
('Trek Fuel EX 8 29 - 2016', 9, 6, 2016, 2899.99),
('Heller Shagamaw Frame - 2016', 3, 6, 2016, 1320.99),
('Surly Ice Cream Truck Frameset - 2016', 8, 6, 2016, 469.99),
('Trek Slash 8 27.5 - 2016', 9, 6, 2016, 3999.99),
('Trek Remedy 29 Carbon Frameset - 2016', 9, 6, 2016, 1799.99),
('Trek Conduit+ - 2016', 9, 5, 2016, 2999.99),
('Surly Straggler - 2016', 8, 4, 2016, 1549.00);
-----------------------
INSERT INTO customers (first_name, last_name, phone, email, street, city, state, zip_code) VALUES
('Debra', 'Burks', NULL, 'debra.burks@yahoo.com', '9273 Thorne Ave.', 'Orchard Park', 'NY', '14127'),
('Kasha', 'Todd', NULL, 'kasha.todd@yahoo.com', '910 Vine Street', 'Campbell', 'CA', '95008'),
('Tameka', 'Fisher', NULL, 'tameka.fisher@aol.com', '769C Honey Creek St.', 'Redondo Beach', 'CA', '90278'),
('Daryl', 'Spence', NULL, 'daryl.spence@aol.com', '988 Pearl Lane', 'Uniondale', 'NY', '11553'),
('Charlotte', 'Rice', '(916) 381-6003', 'charlotte.rice@msn.com', '107 River Dr.', 'Sacramento', 'CA', '95820');
-----------------------
INSERT INTO stores (store_name, phone, email, street, city, state, zip_code) VALUES
('Santa Cruz Bikes', '(831) 476-4321', 'santacruz@bikes.shop', '3700 Portola Drive', 'Santa Cruz', 'CA', '95060'),
('Baldwin Bikes', '(516) 379-8888', 'baldwin@bikes.shop', '4200 Chestnut Lane', 'Baldwin', 'NY', '11432'),
('Rowlett Bikes', '(972) 530-5555', 'rowlett@bikes.shop', '8000 Fairway Avenue', 'Rowlett', 'TX', '75088');
-----------------------------
INSERT INTO stocks (store_id, product_id, quantity) VALUES
(1, 1, 27),
(1, 2, 5),
(1, 3, 6),
(1, 4, 23),
(1, 5, 22),
(1, 6, 0),
(1, 7, 8),
(1, 8, 0),
(1, 9, 11),
(1, 10, 15);
------------------------
INSERT INTO staffs
(first_name, last_name, email, phone, active, store_id, manager_id) VALUES
('Fabiola', 'Jackson', 'fabiola.jackson@bikes.shop', '(831) 555-5554', 1, 1, NULL),
('Mireya', 'Copeland', 'mireya.copeland@bikes.shop', '(831) 555-5555', 1, 1, 1),
('Genna', 'Serrano', 'genna.serrano@bikes.shop', '(831) 555-5556', 1, 1, 2),
('Virgie', 'Wiggins', 'virgie.wiggins@bikes.shop', '(831) 555-5557', 1, 1, 2),
('Jannette', 'David', 'jannette.david@bikes.shop', '(516) 379-4444', 1, 2, 1);

INSERT INTO orders
(customer_id, order_status, order_date, required_date, shipped_date, store_id, staff_id) VALUES
(1, 4, '2016-01-01', '2016-01-03', '2016-01-03', 1, 2),
(2, 4, '2016-01-01', '2016-01-04', '2016-01-03', 2, 5),
(3, 4, '2016-01-02', '2016-01-05', '2016-01-03', 2, 5),
(4, 4, '2016-01-03', '2016-01-04', '2016-01-05', 1, 3),
(5, 4, '2016-01-03', '2016-01-06', '2016-01-06', 2, 4);

INSERT INTO order_items
(order_id, item_id, product_id, quantity, list_price, discount) VALUES
(1, 1, 10, 1, 599.99, 0.20),
(1, 2, 8, 2, 1799.99, 0.07),
(1, 3, 10, 2, 1549.00, 0.05),
(1, 4, 10, 2, 599.99, 0.05),
(1, 5, 4, 1, 2899.99, 0.20),
(2, 1, 10, 1, 599.99, 0.07),
(2, 2, 10, 2, 599.99, 0.05),
(3, 1, 3, 1, 999.99, 0.05),
(3, 2, 10, 1, 599.99, 0.05),
(4, 1, 2, 2, 749.99, 0.10);


-- Retrieve the first name, last name, and email of all customers
select first_name, last_name, email
from customers
-- Returns the customers located in California (state is CA)
select first_name, last_name,state
from customers
where state ='CA'

-- Sorts the customers by their first names in ascending order
select *
from customers
order by  first_name 

-- Returns all the cities of customers located in California and the number of customers
-- in each city 

SELECT city, COUNT(customer_id) as soluongkhachhang
from customers
where state='CA' 
group by customer_id

-- Return the city in California which has more than ten customers
select city, COUNT(customer_id) AS NumberOfCustomers
from customers
where state='CA'
GROUP BY city
HAVING COUNT(customer_id) > 10;


-- Retrieve the product name and model year from the "products" table where the list
-- price is from 1000 to 2000
select model_year, product_name
from products
where list_price BETWEEN 1000 AND 2000; 

--  Retrieve the first name and email from the "staffs" table where the active status is 1
SELECT first_name, email,active
FROM staffs 
WHERE active = 1;

-- Retrieve the product name and brand ID from the "products" table where the model
-- year is 2016 and the list price is greater than 1000
SELECT product_name, brand_id 
FROM products 
WHERE model_year = 2016 AND list_price > 1000;

-- Retrieve the order ID and customer ID from the "orders" table where the shipped date
-- is not null 
SELECT order_id, customer_id 
FROM orders 
WHERE shipped_date IS NOT NULL;

-- Retrieve the product ID, list price and quantity from the "order_items" table where
-- the discount is greater than 0 and quantity equal 2
SELECT product_id, list_price, quantity 
FROM order_items 
WHERE discount > 0 and quantity = 2;

-- Find Stores with more than 5 Products in Stock and ordered by the number of
-- products 
SELECT store_id, COUNT(product_id) AS soluong
FROM stocks
WHERE quantity > 0
GROUP BY store_id
HAVING COUNT(product_id) > 5
ORDER BY soluong DESC;

-- This query retrieves customers whose email address ends with "@yahoo.com" and
-- orders the result by customer name
SELECT first_name, last_name, email 
FROM customers 
WHERE email LIKE '%@yahoo.com%'
order BY first_name ASC, last_name ASC;

-- This query calculates the average list price of products for each category and
-- includes only categories with an average price greater than 500, ordered by the average
-- price in descending order
SELECT category_id, AVG(list_price) AS average_price
FROM products
GROUP BY category_id
HAVING AVG(list_price) > 500
ORDER BY average_price DESC;

-- This query counts the total number of products for each brand and includes only
-- brands that have more than 2 products, ordering the result by the total number of
-- products in descending order.

SELECT brand_id, COUNT(product_id) AS total_products
FROM products
GROUP BY brand_id
HAVING COUNT(product_id) > 2
ORDER BY total_products DESC;




