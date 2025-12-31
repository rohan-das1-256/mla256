show databases;
use employee;
show tables;
drop table employees;
CREATE TABLE IF NOT EXISTS employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    department VARCHAR(100),
    salary DECIMAL(10,2) NOT NULL,
    joined_on DATE NOT NULL,
    is_active TINYINT(1) NOT NULL DEFAULT 1
);

desc employees;


