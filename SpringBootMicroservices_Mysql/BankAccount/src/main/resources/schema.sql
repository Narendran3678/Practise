create table if not exists `customers` (
	`customerid` bigint not null auto_increment,
    `customername` varchar(100) not null default '',
    `emailid` varchar(100) not null default '',
    `mobilenumber` varchar(100) not null default '',
    `activeflag` tinyint default '1',
    `createdby` varchar(100) default '',
    `createdtime` timestamp default current_timestamp,
    `modifiedby` varchar(100) default '',
    `modifiedtime` timestamp default current_timestamp,
    primary key (`customerid`),
    unique key (`emailid`)
);

create table if not exists `accounts` (
	`customerid` bigint not null default '0',
	`accountnumber` varchar(50) not null default '',
	`accounttype` varchar(100) not null default '',
    `branchaddress` varchar(100) not null default '',
    `createdby` varchar(100) default '',
    `createdtime` timestamp default current_timestamp,
    `modifiedby` varchar(100) default '',
    `modifiedtime` timestamp default current_timestamp,
	primary key (`customerid`),
    unique key (`accountnumber`),
    foreign key (`customerid`) references `customers`(`customerid`)
);

--select * from accounts;
--select * from customers;
--select * from loans;
--select * from cards;

