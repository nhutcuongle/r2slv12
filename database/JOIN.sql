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


-- Lấy tên sản phẩm và giá niêm yết từ bảng "products" 
-- cùng với tên thương hiệu tương ứng từ bảng "brands". Chỉ bao gồm các sản phẩm có giá niêm yết lớn hơn 1000 đô la.
SELECT p.product_name, p.list_price, b.brand_name
FROM products p INNER JOIN brands b ON p.brand_id = b.brand_id
WHERE p.list_price > 1000;

-- Truy xuất tất cả khách hàng từ bảng "customers" cùng
-- với các đơn hàng tương ứng của họ từ bảng "orders". Chỉ bao gồm những khách hàng đã đặt hàng 
SELECT c.customer_id, c.first_name, c.last_name, o.order_id, o.order_status, o.order_date, o.required_date, o.shipped_date
FROM customers c INNER JOIN orders o ON c.customer_id = o.customer_id
WHERE o.order_status = 4;

-- Truy xuất họ và tên của nhân viên cùng với họ và tên của người quản lý tương ứng của họ. 
-- Giả sử bảng "staffs" chứa một cột "manager_id" tham chiếu đến một hàng khác trong cùng bảng "staffs".

SELECT e.first_name AS employee_first_name,e.last_name AS employee_last_name, m.first_name AS manager_first_name, m.last_name AS manager_last_name
FROM staffs e LEFT JOIN staffs m ON e.manager_id = m.staff_id;

-- Truy xuất tất cả sản phẩm từ bảng "products" cùng với tên thương hiệu 
-- tương ứng từ bảng "brands". Bao gồm cả những sản phẩm không có thương hiệu trùng khớp.
SELECT p.product_id, p.product_name, p.list_price, b.brand_name
FROM products p LEFT JOIN brands b ON p.brand_id = b.brand_id;

-- Lấy tên sản phẩm và năm sản xuất từ ​​bảng "products" cùng với tên thương hiệu tương ứng từ bảng "brands".
-- Chỉ bao gồm các sản phẩm có năm sản xuất từ ​​năm 2016 trở lên.

SELECT p.product_name, p.model_year, b.brand_name
FROM products p INNER JOIN brands b ON p.brand_id = b.brand_id
WHERE p.model_year >= 2016;


-- Lấy ID đơn hàng, tên sản phẩm và số lượng từ bảng "order_items" cùng với thông tin sản phẩm tương ứng từ bảng "products".

SELECT a.order_id, b.product_name, a.quantity
FROM order_items a INNER JOIN products b ON a.product_id = b.product_id;


-- Truy xuất tất cả sản phẩm từ bảng "products" cùng với tên danh mục tương ứng từ bảng "categories". 
-- Bao gồm tất cả sản phẩm, nhưng giới hạn kết quả chỉ hiển thị các sản phẩm thuộc danh mục 'Xe đạp leo núi'.

SELECT p.product_id, p.product_name, p.list_price, c.category_name
FROM products p LEFT JOIN categories c ON p.category_id = c.category_id
WHERE c.category_name = 'Mountain Bikes';

-- Lấy tên sản phẩm, giá niêm yết và tên danh mục từ bảng "products" cùng với tên thương hiệu tương ứng từ bảng "brands".
-- Chỉ bao gồm các sản phẩm có giá niêm yết lớn hơn 500 đô la và tên danh mục là 'Xe đạp điện'.
SELECT p.product_name, p.list_price, c.category_name, b.brand_name
FROM products p INNER JOIN categories c ON p.category_id = c.category_id INNER JOIN brands b ON p.brand_id = b.brand_id
WHERE p.list_price > 500 AND c.category_name = 'Electric Bikes';

-- Truy xuất tất cả khách hàng từ bảng "customers" cùng với các đơn hàng tương ứng của họ từ bảng "orders".
-- Bao gồm tất cả khách hàng, nhưng chỉ bao gồm các đơn hàng có ngày giao hàng là null.
-- CÂU NÀY CẦN
SELECT c.customer_id, c.first_name, c.last_name, o.order_id, o.order_date, o.shipped_date
FROM customers c LEFT JOIN orders o ON c.customer_id = o.customer_id
    AND o.shipped_date IS NULL;

-- Lấy tên cửa hàng từ bảng "stores" cùng với số lượng đơn hàng đã được đặt từ mỗi cửa hàng.
-- Bao gồm tất cả các cửa hàng, ngay cả khi chúng chưa nhận được bất kỳ đơn hàng nào.

SELECT s.store_name, COUNT(o.order_id) AS total_orders
FROM stores s LEFT JOIN orders o ON s.store_id = o.store_id
GROUP BY s.store_id

-- Truy vấn này lấy tất cả các đơn hàng cho một cửa hàng cụ thể (ID cửa hàng = 1) cùng với thông tin nhân viên đã xử lý chúng.
SELECT o.order_id, o.order_date, o.store_id, s.staff_id, s.first_name, s.last_name
FROM orders o INNER JOIN staffs s ON o.staff_id = s.staff_id
WHERE o.store_id = 1;

-- Truy vấn này lấy ra tất cả khách hàng đã đặt hàng trong năm 2016.
SELECT c.customer_id, c.first_name, c.last_name, o.order_id, o.order_date
FROM customers c INNER JOIN orders o ON c.customer_id = o.customer_id
WHERE YEAR(o.order_date) = 2016;

-- Truy vấn này lấy thông tin về nhân viên và các đơn đặt hàng tương ứng của họ, 
-- nhưng chỉ áp dụng cho các đơn đặt hàng được đặt trong vòng mười hai tháng qua.
SELECT s.staff_id, s.first_name, s.last_name, o.order_id, o.order_date
FROM staffs s INNER JOIN orders o
ON s.staff_id = o.staff_id
WHERE o.order_date >= DATE_SUB(CURDATE(), INTERVAL 200 MONTH);


