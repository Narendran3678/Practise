
create table EMPLOYEE (
ID integer AUTO_INCREMENT , FIRSTNAME varchar(100), LASTNAME varchar(100),EMAILID varchar(100),phonenumber varchar(10), SALARY real, createtime timestamp default now(),PRIMARY KEY (ID));


insert into employee values
('101','John','Smith','john@gmail.com','9856435671','12000',now()),
('102','Sean','Smith','sean@gmail.com','9816412671','15000',now()),
('103','Regina','Williams','regina@gmail.com','9832443673','15500',now()),
('104','Natasha','George','natasha@gmail.com','967641574','14600',now());

commit;