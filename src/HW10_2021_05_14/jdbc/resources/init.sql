CREATE SCHEMA IF NOT EXISTS test;
USE test;

DROP TABLE IF EXISTS students;
CREATE TABLE students(id BIGINT PRIMARY KEY AUTO_INCREMENT,name VARCHAR(100),surname VARCHAR(100),course_name VARCHAR (100));
INSERT INTO students (name,surname,course_name) VALUES('Andrey','Zaharenko','Java SE Core');
INSERT INTO students (name,surname,course_name) VALUES('Mark','Zaharenko','Java SE Core');