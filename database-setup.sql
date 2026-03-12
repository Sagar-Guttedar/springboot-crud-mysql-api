-- ============================================
-- SpringBoot CRUD - MySQL Setup Script
-- ============================================

-- Step 1: Create the database
CREATE DATABASE IF NOT EXISTS cruddb;
USE cruddb;

-- Step 2: (Optional) The table is auto-created by JPA/Hibernate
-- But you can manually create it using the SQL below:

CREATE TABLE IF NOT EXISTS employees (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    department VARCHAR(100) NOT NULL,
    salary DOUBLE NOT NULL,
    phone VARCHAR(20)
);

-- Step 3: Insert sample data for testing
INSERT INTO employees (first_name, last_name, email, department, salary, phone) VALUES
('Alice', 'Johnson', 'alice.johnson@example.com', 'Engineering', 85000.00, '+91-9000000001'),
('Bob', 'Williams', 'bob.williams@example.com', 'HR', 60000.00, '+91-9000000002'),
('Charlie', 'Brown', 'charlie.brown@example.com', 'Engineering', 90000.00, '+91-9000000003'),
('Diana', 'Prince', 'diana.prince@example.com', 'Finance', 75000.00, '+91-9000000004'),
('Ethan', 'Hunt', 'ethan.hunt@example.com', 'Management', 110000.00, '+91-9000000005');

-- Step 4: Verify the data
SELECT * FROM employees;
