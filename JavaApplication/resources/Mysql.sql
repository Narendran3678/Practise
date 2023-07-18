use devdb;
CREATE TABLE `customers` (
    `customerNumber` INT(11) NOT NULL,
    `customerName` VARCHAR(50) NOT NULL,
    `phone` VARCHAR(50) NOT NULL,
    `addressLine1` VARCHAR(100) NOT NULL,
    `city` VARCHAR(50) NOT NULL,
    `state` VARCHAR(50) DEFAULT NULL,
    `postalCode` VARCHAR(15) DEFAULT NULL,
    `country` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`customerNumber`)
);
insert  into `customers`(`customerNumber`,`customerName`,`phone`,`addressLine1`,`city`,`state`,`postalCode`,`country`) values 
(103,'Atelier graphique','40.32.2555','54, rue Royale','Nantes',NULL,'44000','France'),
(112,'Signal Gift Stores','7025551838','8489 Strong St.','Las Vegas','NV','83030','USA'),
(114,'Australian Collectors, Co.','03 9520 4555','636 St Kilda Road','Melbourne','Victoria','3004','Australia');


create table EMPLOYEE (
ID integer, FIRSTNAME varchar(100), LASTNAME varchar(100),EMAILID varchar(100),phonenumber varchar(10), SALARY real, createtime timestamp default now(),PRIMARY KEY (ID));

insert into employee values
('101','John','Smith','john@gmail.com','9856435671','12000',now()),
('102','Sean','Smith','sean@gmail.com','9816412671','15000',now()),
('103','Regina','Williams','regina@gmail.com','9832443673','15500',now()),
('104','Natasha','George','natasha@gmail.com','967641574','14600',now());

create table MESSAGES (msg1 varchar(100), msg2 varchar(100));
insert into messages values('Happy New Year!', 'Happy Holidays!');