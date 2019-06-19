create database  Employee;
#show databases; 
use Employee;
#drop database employee;


CREATE TABLE IF NOT EXISTS `account` (

	`AID` int(10) auto_increment not null,
    `username` varchar(50) not null,
    `password` varchar(50) not null,
    `type`		varchar(10),
	PRIMARY KEY (`AID`)
);
show table status;
show tables;

INSERT INTO `account` (`username` , `password` , `type`) values 
	('sokhom','12345', 'admin'),
	('sengkry','98765', 'admin');

select * from account;



CREATE TABLE IF NOT EXISTS `employees` (

	`eID` int(10) auto_increment not null,
    `username` varchar(50) not null,	
    `password` varchar(50) not null,
    `email`		varchar(50) ,
    `salary` double(10),
    `phone`		int(20),
    `position`	varchar(30) not null,
    
	PRIMARY KEY (`eID`)
);