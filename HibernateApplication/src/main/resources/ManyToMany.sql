use devdb;
set autocommit=1;

DROP TABLE PROJECT_TECHNOLOGY;
DROP TABLE TECHNOLOGY;
DROP TABLE PROJECT;

CREATE TABLE TECHNOLOGY
(
	ID BIGINT NOT NULL AUTO_INCREMENT,
    TECH_NAME VARCHAR(200) NOT NULL,
	TECH_VERSION VARCHAR(20) NOT NULL,
    PRIMARY KEY(ID)
);
CREATE TABLE PROJECT
(
	ID BIGINT NOT NULL AUTO_INCREMENT,
    PROJECT_NAME VARCHAR(200) NOT NULL,
    PROJECT_LEAD VARCHAR(20) NOT NULL,
    PRIMARY KEY(ID)
); 
CREATE TABLE PROJECT_TECHNOLOGY
(
	TECH_ID BIGINT NOT NULL,
    PROJECT_ID BIGINT NOT NULL,
	PRIMARY KEY(TECH_ID,PROJECT_ID),
    FOREIGN KEY (TECH_ID) REFERENCES TECHNOLOGY (ID),
    FOREIGN KEY (PROJECT_ID) REFERENCES PROJECT (ID)
);
DELETE FROM PROJECT_TECHNOLOGY;
DELETE FROM PROJECT;
DELETE FROM TECHNOLOGY;

SELECT * FROM PROJECT;
SELECT * FROM TECHNOLOGY;
SELECT * FROM PROJECT_TECHNOLOGY;
COMMIT;

