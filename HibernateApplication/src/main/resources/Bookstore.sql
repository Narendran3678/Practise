CREATE DATABASE bookstore;

USE bookstore;

CREATE TABLE PUBLISHER (
	CODE VARCHAR(4) NOT NULL,
	PUBLISHER_NAME VARCHAR(100) NOT NULL,
    CREATETIME TIMESTAMP DEFAULT NOW(),
    MODIFYTIME TIMESTAMP DEFAULT NOW(),
	PRIMARY KEY (CODE)
);

CREATE TABLE BOOK (
	ISBN VARCHAR(50) NOT NULL,
	BOOK_NAME VARCHAR(100) NOT NULL,
	PUBLISHER_CODE VARCHAR(4),
	CREATETIME TIMESTAMP DEFAULT NOW(),
    MODIFYTIME TIMESTAMP DEFAULT NOW(),
	PRIMARY KEY (ISBN),
	FOREIGN KEY (PUBLISHER_CODE) REFERENCES PUBLISHER (CODE)
);

CREATE TABLE CHAPTER (
	BOOK_ISBN VARCHAR(50) NOT NULL,
	CHAPTER_NUM INT NOT NULL,
	TITLE VARCHAR(100) NOT NULL,
	CREATETIME TIMESTAMP DEFAULT NOW(),
    MODIFYTIME TIMESTAMP DEFAULT NOW(),
	PRIMARY KEY (BOOK_ISBN, CHAPTER_NUM),
	FOREIGN KEY (BOOK_ISBN) REFERENCES BOOK (ISBN)
);

CREATE TABLE STUDENT (
	ID INT NOT NULL AUTO_INCREMENT,
	FIRST_NAME VARCHAR(100) NOT NULL DEFAULT '',
	LAST_NAME VARCHAR(100) NOT NULL DEFAULT '',
	EMAIL_ID VARCHAR(100) NOT NULL DEFAULT '',
	GRADE DECIMAL(3,2) DEFAULT 0.0 ,
	CREATETIME TIMESTAMP DEFAULT NOW(),
	MODIFIEDTIME TIMESTAMP DEFAULT NOW(),
	PRIMARY KEY(ID)
);


CREATE TABLE USER
(
	ID INT NOT NULL AUTO_INCREMENT,
	SALUTATION VARCHAR(100) NOT NULL DEFAULT '',
	FIRST_NAME VARCHAR(100) NOT NULL DEFAULT '',
	LAST_NAME VARCHAR(100) NOT NULL DEFAULT '',
	EMAIL_ID VARCHAR(100) NOT NULL DEFAULT '',
	PHONE_NUMBER VARCHAR(10) NOT NULL DEFAULT '',
	HOUSE_NUMBER VARCHAR(10) NOT NULL DEFAULT '',
	STREET VARCHAR(70) NOT NULL DEFAULT '',
	CITY VARCHAR(50) NOT NULL DEFAULT '',
	STATE VARCHAR(50) NOT NULL DEFAULT '',
	COUNTRY VARCHAR(20) NOT NULL DEFAULT '',
	POSTAL_CODE VARCHAR(10) NOT NULL DEFAULT '',
	PRIMARY KEY(ID)
);















