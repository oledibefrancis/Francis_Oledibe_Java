use northwind

-- What are the categories of products in the database?
SELECT category  
from products;


-- What products are made by Dell?
SELECT * 
from products
where product_name 
like 'Dell%'


-- List all the orders shipped to Pennsylvania.
SELECT *
FROM orders 
WHERE ship_city = 'Pennsylvania'


-- List the first name and last name of all employees with last names that start with the letter W.
SELECT *
FROM employees 
WHERE first_name 
LIKE 'W%'
And last_name 
LIKE 'w%'


-- List all customers from zip codes that start with 55.
SELECT *
FROM customers 
WHERE postal_code 
LIKE '55%'


-- List all customers from zip codes that end with 0.
SELECT *
FROM customers 
WHERE postal_code 
LIKE '0%'


-- List the first name, last name, and email for all customers with a ".org" email address.
SELECT first_name, last_name, email 
FROM customers 
WHERE email 
like '%.org'


-- List the first name, last name, and phone number for all customers from the 202 area code.
SELECT first_name, last_name, phone
FROM customers 
WHERE phone  
like '1-(202)%'


-- List the first name, last name, and phone number for all customers from the 202 area code, ordered by last name, first name.
SELECT first_name, last_name, phone
FROM customers 
WHERE phone  
like '1-(202)%'
ORDER BY last_name , first_name  






