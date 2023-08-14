CREATE TABLE DEBIT_CARD
(
	ID BIGINT NOT NULL AUTO_INCREMENT,
	ACCOUNT_OWNER VARCHAR(100) NOT NULL,
	ACCOUNT_NUMBER VARCHAR(30) NOT NULL,
	CARD_TYPE VARCHAR(100) NOT NULL,
    ACCOUNT_BALANCE VARCHAR(30) NOT NULL,
    WIFI_ENABLED BIT NOT NULL,
    PRIMARY KEY(ID),
    UNIQUE KEY(ACCOUNT_NUMBER,ACCOUNT_OWNER)
);


CREATE TABLE CREDIT_CARD
(
	ID BIGINT NOT NULL AUTO_INCREMENT,
	ACCOUNT_OWNER VARCHAR(100) NOT NULL,
	ACCOUNT_NUMBER VARCHAR(30) NOT NULL,
	CARD_TYPE VARCHAR(100) NOT NULL,
    CREDIT_USED VARCHAR(30) NOT NULL,
    CREDIT_LIMIT VARCHAR(30) NOT NULL,
    PRIMARY KEY(ID),
    UNIQUE KEY(ACCOUNT_NUMBER,ACCOUNT_OWNER)
);