
CREATE TABLE EMPLOYEE (
ID INTEGER AUTO_INCREMENT , 
FIRSTNAME VARCHAR(100), 
LASTNAME VARCHAR(100),
EMAILID VARCHAR(100),
PHONENUMBER VARCHAR(10), 
SALARY REAL, 
CREATETIME TIMESTAMP DEFAULT NOW(),
LASTMODIFIED TIMESTAMP DEFAULT NOW(),PRIMARY KEY (ID));


insert into employee (ID, FIRSTNAME, LASTNAME, EMAILID, PHONENUMBER, SALARY) values
('101','John','Smith','john@gmail.com','9856435671','12000'),
('102','Sean','Smith','sean@gmail.com','9816412671','15000'),
('103','Regina','Williams','regina@gmail.com','9832443673','15500'),
('104','Natasha','George','natasha@gmail.com','967641574','14600');

SELECT ID, FIRSTNAME, LASTNAME, EMAILID, PHONENUMBER, SALARY, CREATETIME ,LASTMODIFIED FROM EMPLOYEE;

commit;