CREATE SCHEMA springdb;

USE SPRINGDB;

DROP TABLE EMPLOYEE_ROLES;
DROP TABLE EMPLOYEE;
DROP TABLE ROLES;
DROP TABLE USERS;
DROP TABLE AUTHORITIES;

CREATE TABLE USERS (
	ID BIGINT NOT NULL AUTO_INCREMENT,
    USERNAME VARCHAR(100) NOT NULL,
    PASSWORD VARCHAR(100) NOT NULL,
    EMAILID VARCHAR(100) NOT NULL,
    ENABLED  TINYINT NOT NULL DEFAULT '1',
    PRIMARY KEY(ID),
    UNIQUE KEY(USERNAME,EMAILID)
);

CREATE TABLE AUTHORITIES (
	USERNAME VARCHAR(100) NOT NULL,
    AUTHORITY VARCHAR(100) NOT NULL,
    UNIQUE KEY(USERNAME,AUTHORITY),
    FOREIGN KEY (USERNAME) REFERENCES USERS(USERNAME)
);

CREATE TABLE ROLES (
	ID BIGINT NOT NULL AUTO_INCREMENT,
    ROLE_ID BIGINT NOT NULL,
    ROLENAME VARCHAR(100) NOT NULL,
    PRIMARY KEY(ID),
    UNIQUE(ROLE_ID,ROLENAME)
);
CREATE TABLE EMPLOYEE (
  ID BIGINT NOT NULL AUTO_INCREMENT,
  FIRSTNAME VARCHAR(255) DEFAULT NULL,
  LASTNAME VARCHAR(255) DEFAULT NULL,
  EMAILID VARCHAR(255) DEFAULT NULL,
  PASSWORD VARCHAR(100) NOT NULL,
  PHONENUMBER VARCHAR(255) DEFAULT NULL,
  AGE BIGINT DEFAULT 0,
  SALARY DOUBLE DEFAULT NULL,
  ACTIVE_FLAG TINYINT NOT NULL DEFAULT 1,
  CREATETIME DATETIME(6) DEFAULT NULL,
  LASTMODIFIED DATETIME(6) DEFAULT NULL,
  PRIMARY KEY (ID),
  UNIQUE KEY(EMAILID)
);

CREATE TABLE EMPLOYEE_ROLES (
ROLES_ID BIGINT,
EMPLOYEE_ID BIGINT,
UNIQUE KEY(ROLES_ID,EMPLOYEE_ID),
FOREIGN KEY (ROLES_ID) REFERENCES ROLES(ID),
FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE(ID)
);


INSERT INTO EMPLOYEE (salary, createtime, lastmodified, emailid, firstname, lastname, phonenumber,password,age,active_flag)
VALUES ('30000',sysdate(),  sysdate(), 'divya@gmail.com','Divya', 'Naren', '8200212110','Divya',18,1);

INSERT INTO EMPLOYEE (salary, createtime, lastmodified, emailid, firstname, lastname, phonenumber,password,age,active_flag)
VALUES ('50000',sysdate(),  sysdate(), 'naren@gmail.com','Narendran', 'Naren', '7092802533','Narendran',18,1);

INSERT INTO EMPLOYEE (salary, createtime, lastmodified, emailid, firstname, lastname, phonenumber,password,age,active_flag)
VALUES ('100000',sysdate(),  sysdate(), 'sam@gmail.com','Sam', 'Sam', '8912428787','Sam',18,1);

INSERT INTO EMPLOYEE (salary, createtime, lastmodified, emailid, firstname, lastname, phonenumber,password,age,active_flag)
VALUES ('100000',sysdate(),  sysdate(), 'john@gmail.com','John', 'John', '8912428787','Sam',18,1);

INSERT INTO EMPLOYEE (salary, createtime, lastmodified, emailid, firstname, lastname, phonenumber,password,age,active_flag)
VALUES ('110000',sysdate(),  sysdate(), 'Zeno@gmail.com','Zeno', 'Zeno', '8912428787','Zeno',38,1);

INSERT INTO EMPLOYEE (salary, createtime, lastmodified, emailid, firstname, lastname, phonenumber,password,age,active_flag)
VALUES ('120000',sysdate(),  sysdate(), 'Goku@gmail.com','Goku', 'Goku', '8123228787','Goku',28,1);

INSERT INTO EMPLOYEE (salary, createtime, lastmodified, emailid, firstname, lastname, phonenumber,password,age,active_flag)
VALUES ('140000',sysdate(),  sysdate(), 'Whis@gmail.com','Whis', 'Whis', '8133228787','Whis',48,1);

INSERT INTO EMPLOYEE (salary, createtime, lastmodified, emailid, firstname, lastname, phonenumber,password,age,active_flag)
VALUES ('125000',sysdate(),  sysdate(), 'Vegeta@gmail.com','Vegeta', 'Vegeta', '8133228787','Vegeta',29,1);

INSERT INTO EMPLOYEE (salary, createtime, lastmodified, emailid, firstname, lastname, phonenumber,password,age,active_flag)
VALUES ('115000',sysdate(),  sysdate(), 'Piccolo@gmail.com','Piccolo', 'Piccolo', '8132228717','Piccolo',69,1);

INSERT INTO EMPLOYEE (salary, createtime, lastmodified, emailid, firstname, lastname, phonenumber,password,age,active_flag)
VALUES ('105000',sysdate(),  sysdate(), 'Jiren@gmail.com','Jiren', 'Jiren', '8132228717','Jiren',44,1);


UPDATE EMPLOYEE SET AGE=18;

INSERT INTO ROLES (ROLE_ID,ROLENAME) VALUES (1,'ADMIN');
INSERT INTO ROLES (ROLE_ID,ROLENAME) VALUES (2,'MANAGER');
INSERT INTO ROLES (ROLE_ID,ROLENAME) VALUES (3,'EMPLOYEE');

INSERT INTO EMPLOYEE_ROLES (ROLES_ID,EMPLOYEE_ID) VALUE(1,1);
INSERT INTO EMPLOYEE_ROLES (ROLES_ID,EMPLOYEE_ID) VALUE(2,2);
INSERT INTO EMPLOYEE_ROLES (ROLES_ID,EMPLOYEE_ID) VALUE(3,3);
INSERT INTO EMPLOYEE_ROLES (ROLES_ID,EMPLOYEE_ID) VALUE(1,4);

INSERT INTO USERS (USERNAME,PASSWORD,EMAILID,ENABLED)
VALUES("naren","{bcrypt}$2a$10$GeygHXXSB3jmA/w9GYidbO1oeENJ5.d1pEnGyHd37lZJfXF.9AFMG","naren@gmail.com",1);
#VALUES("naren","{noop}naren","naren@gmail.com",1);

INSERT INTO USERS (USERNAME,PASSWORD,EMAILID,ENABLED)
VALUES("divya","{bcrypt}$2a$10$06.qZNCKJYoQmSUqJUTLMe8tUgXBHZR6WCO6pnHaZp08Jfqk4gd1a","divya@gmail.com",1);
#VALUES("divya","{noop}divya","divya@gmail.com",1);

INSERT INTO AUTHORITIES(USERNAME,AUTHORITY)
VALUE("naren","MANAGER");
INSERT INTO AUTHORITIES(USERNAME,AUTHORITY)
VALUE("naren","EMPLOYEE");
INSERT INTO AUTHORITIES(USERNAME,AUTHORITY)
VALUE("divya","EMPLOYEE");



select username,authority from authorities where username = 'naren';

SELECT * FROM EMPLOYEE;
SELECT * FROM ROLES;
SELECT * FROM EMPLOYEE_ROLES;
SELECT * FROM USERS;
SELECT * FROM AUTHORITIES;

commit;