CREATE DATABASE sales

CREATE TABLE employees (
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    last_name VARCHAR(20) NOT NULL,
    first_name VARCHAR(10) NOT NULL,
    birth_date DATE,
    supervisor_id INT
);
    
CREATE TABLE customers (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(255),
    contact_name VARCHAR(255),
    address VARCHAR(255),
    city VARCHAR(255),
    postal_code VARCHAR(10),
    country VARCHAR(50)
);
CREATE TABLE orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    employee_id INT,
    order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
);

INSERT INTO customers (customer_name, contact_name, address, city, postal_code, country) VALUES
('Trần Bình', 'Trọng', 'Quận 8', 'HCM', 70000, 'VN'),
('Tran Bao', 'An', 'Bình Thạnh', 'HCM', 70000, 'VN'),
('Tasty', 'Finn', 'Streetroad 19B', 'Liverpool', 'L1 0AA', 'UK');
---------------
-- Question 1: To return all columns and rows 

SELECT customer_id, customer_name, contact_name,
       address, city, postal_code, country
FROM customers;

-- Select all the different countries from the "Customers" table
SELECT DISTINCT country
FROM customers;
--  Select all customers from VN 
SELECT *
FROM customers
WHERE country = 'VN';

-- Lists the number of customers in each country
SELECT country, COUNT(customer_id) AS NumberOfCustomers
FROM customers
GROUP BY country;
-- Lists the number of customers in each country. Only include countries with
-- more than 1 customer 
SELECT country, COUNT(customer_id) AS NumberOfCustomers
FROM customers
GROUP BY country
HAVING COUNT(customer_id) >= 2;
-- 

SELECT customer_id, customer_name, country 
FROM customers 
Order By customer_name;