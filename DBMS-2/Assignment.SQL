CREATE DATABASE storeFront;
USE storeFront;

CREATE TABLE Admin(adminId int NOT NULL AUTO_INCREMENT,name varchar(50),email vrachar(30) UNIQUE,number varchar(10) UNIQUE,PRIMARY KEY(adminId));

CREATE TABLE Customers(userId int NOT NULL AUTO_INCREMENT,name varchar(50),email varchar(30) UNIQUE,number varchar(10) UNIQUE,PRIMARY KEY(userId);

CREATE TABLE Products(productId int NOT NULL AUTO_INCREMENT,name varchar(50) UNIQUE,Price int,status varchar(10),Date DATE,PRIMARY KEY(productId));

CREATE TABLE Categories(catId int NOT NULL AUTO_INCREMENT,catName varchar(30),parentCat varchar(30),PRIMARY KEY(catId);

CREATE TABLE Inventory(itemId int NOT NULL AUTO_INCREMENT,name varchar(50) UNIQUE,quantity int,PRIMARY KEY(itemId));

CREATE TABLE Orders(orderId int NOT NULL AUTO_INCREMENT,userId int,productId int,Date DATE,status varchar(20),totalCost int,PRIMARY KEY(orderId));

CREATE TABLE CustomersAddress(userId int,address varchar(30),PRIMARY KEY(userId,address),FOREIGN KEY(userId) REFERENCES CUSTOMERS(userId) ON DELETE CASCADE ON UPDATE CASCADE);

CREATE TABLE ProductCat(productid int,category varchar(20),PRIMARY KEY(productId,category));

CREATE TABLE ProductImages(imageId int NOT NULL AUTO_INCREMENT PRIMARY KEY,images BLOB,productId int,PRIMARY KEY(imageId,product Id));

SHOW TABLES;
DROP TABLE Products;

CREATE TABLE Products(productId int NOT NULL AUTO_INCREMENT,name varcahr(50) UNIQUE,Price int,status varchar(10),date DATE,PRIMARY KEY(productId));



INSERT INTO Admin (name,email,number) VALUES ('Khush','9999295965','xyz@gmail.com');

INSERT INTO Products(name,Price,status,Date,) VALUES ('Shirts',400,'In Stock',NOW());
INSERT INTO Products(name,Price,status,Date,) VALUES ('Shorts',200,'In Stock','2021-01-21');
INSERT INTO Products(name,Price,status,Date,) VALUES ('Jeans',100,'Out Of Stock',NOW());
INSERT INTO Products(name,Price,status,Date,) VALUES ('TV',300,'In Stock',NOW());
INSERT INTO Products(name,Price,status,Date,) VALUES ('Laptop',450,'Out Of Stock','2021-01-29');
INSERT INTO Products(name,Price,status,Date,) VALUES ('Mobile',400,'Out Of Stock',NOW());
INSERT INTO Products(name,Price,status,Date,) VALUES ('Sofa',400,'In Stock','2021-03-01');
INSERT INTO Products(name,Price,status,Date,) VALUES ('Chair',900,'In Stock',NOW());
INSERT INTO Products(name,Price,status,Date,) VALUES ('Table',400,'In Stock',NOW());
INSERT INTO Products(name,Price,status,Date,) VALUES ('chinos',100,'Out Of Stock',NOW());
INSERT INTO Products(name,Price,status,Date,) VALUES ('sneakers',200,'Out Of Stock','2021-02-21');
INSERT INTO Products(name,Price,status,Date,) VALUES ('sandals',310,'Out Of Stock',NOW());
INSERT INTO Products(name,Price,status,Date,) VALUES ('studs',1000,'In Stock','2021-01-21');

INSERT INTO Categories(catName,parentCat) VALUES("Cloths","Top Category");
INSERT INTO Categories(catName,parentCat) VALUES("Upperwear","Cloths");
INSERT INTO Categories(catName,parentCat) VALUES("Bottomwear","Cloths");
INSERT INTO Categories(catName,parentCat) VALUES("Electronic Apliances","Top Category");
INSERT INTO Categories(catName,parentCat) VALUES("Footwear","Top Category");
INSERT INTO Categories(catName,parentCat) VALUES("SportShoes","FootWear");
INSERT INTO Categories(catName,parentCat) VALUES("CasualShoes","FootWear");
INSERT INTO Categories(catName,parentCat) VALUES("Furniture","Top Category");
INSERT INTO Categories(catName,parentCat) VALUES("Chairs","Furniture");
INSERT INTO Categories(catName,parentCat) VALUES("Tables","Furniture");

INSERT INTO ProductImages (productId) VALUES(1);
INSERT INTO ProductImages (productId) VALUES(3);
INSERT INTO ProductImages (productId) VALUES(5);
INSERT INTO ProductImages (productId) VALUES(2);

INSERT INTO ProductCat(productId,category) VALUES (1,'Cloths');
INSERT INTO ProductCat(productId,category) VALUES (1,'Upperwear');
INSERT INTO ProductCat(productId,category) VALUES (2,'Cloths');
INSERT INTO ProductCat(productId,category) VALUES (2,'Bottomwear');
INSERT INTO ProductCat(productId,category) VALUES (3,'Cloths');
INSERT INTO ProductCat(productId,category) VALUES (3,'Bottomwear');
INSERT INTO ProductCat(productId,category) VALUES (4,'Electronic Apliances');
INSERT INTO ProductCat(productId,category) VALUES (5,'Electronic Apliances');
INSERT INTO ProductCat(productId,category) VALUES (6,'Electronic Apliances');
INSERT INTO ProductCat(productId,category) VALUES (7,'Furniture');
INSERT INTO ProductCat(productId,category) VALUES (7,'Chairs');
INSERT INTO ProductCat(productId,category) VALUES (8,'Furnitures');
INSERT INTO ProductCat(productId,category) VALUES (8,'Chairs');
INSERT INTO ProductCat(productId,category) VALUES (9,'Furnitures');
INSERT INTO ProductCat(productId,category) VALUES (9,'Tables');
INSERT INTO ProductCat(productId,category) VALUES (10,'Cloths');
INSERT INTO ProductCat(productId,category) VALUES (10,'Bottomwear');
INSERT INTO ProductCat(productId,category) VALUES (11,'Footwear');
INSERT INTO ProductCat(productId,category) VALUES (11,'CasualShoes');
INSERT INTO ProductCat(productId,category) VALUES (12,'Footwear');
INSERT INTO ProductCat(productId,category) VALUES (12,'CasualShoes');
INSERT INTO ProductCat(productId,category) VALUES (13,'Footwear');
INSERT INTO ProductCat(productId,category) VALUES (13,'SportShoes');

INSERT INTO Customers(name,email,number) VALUES ('vatik','abc@gmail.com','1232123456');
INSERT INTO Customers(name,email,number) VALUES ('abhay','acc@gmail.com','2132123456');
INSERT INTO Customers(name,email,number) VALUES ('vrati','cbc@gmail.com','1332123456');
INSERT INTO Customers(name,email,number) VALUES ('latika','adc@gmail.com','1231113456');
INSERT INTO Customers(name,email,number) VALUES ('ajay','a3c@gmail.com','1232123111');

INSERT INTO CustomersAddress(userId,address) VALUES (1,'Udaipur');
INSERT INTO CustomersAddress(userId,address) VALUES (1,'jaipur');
INSERT INTO CustomersAddress(userId,address) VALUES (2,'raipur');
INSERT INTO CustomersAddress(userId,address) VALUES (3,'ajmer');
INSERT INTO CustomersAddress(userId,address) VALUES (4,'ranchi');
INSERT INTO CustomersAddress(userId,address) VALUES (5,'delhi');

INSERT INTO Inventory(name,quantity) VALUES ('Shirts',30);
INSERT INTO Inventory(name,quantity) VALUES ('Shorts',10);
INSERT INTO Inventory(name,quantity) VALUES ('Jeans',0);
INSERT INTO Inventory(name,quantity) VALUES ('Laptop',0);
INSERT INTO Inventory(name,quantity) VALUES ('TV',30);

INSERT INTO Orders(userId,productId,Date,status,totalCost) VALUES (1,2,NOW(),'not shipped',5000);
INSERT INTO Orders(userId,productId,Date,status,totalCost) VALUES (1,4,'2021-03-01','shipped',2000);
INSERT INTO Orders(userId,productId,Date,status,totalCost) VALUES (2,1,NOW(),'not shipped',2200);
INSERT INTO Orders(userId,productId,Date,status,totalCost) VALUES (4,6,NOW(),'not shipped',5000);
INSERT INTO Orders(userId,productId,Date,status,totalCost) VALUES (3,2,NOW(),'not shipped',5000);
INSERT INTO Orders(userId,productId,Date,status,totalCost) VALUES (3,2,'2021-03-01','not shipped',3000);
INSERT INTO Orders(userId,productId,Date,status,totalCost) VALUES (5,2,'2021-02-01','not shipped',3000);
INSERT INTO Orders(userId,productId,Date,status,totalCost) VALUES (1,3,NOW(),'Cancelled',5000);
INSERT INTO Orders(userId,productId,Date,status,totalCost) VALUES (3,7,'2021-03-11','Cancelled',3000);
INSERT INTO Orders(userId,productId,Date,status,totalCost) VALUES (1,5,'2021-02-01','Cancelled',3000);


select p1.productId,p1.status,p1.name,p2.category,p1.price from Products p1 INNER JOIN ProductCat p2 ON p1.productId=p2.productId where p1.status='In Stock' order by p1.Date desc;

select p1.name from products p1 inner join productimages p2 on p1.productId=p2.productId and p2.images is null;

select catId,catName,parentcat from categories order by parentcat,name;

select c1.catId,c1.catName,c1.parentCat from categories c1 where c1.catName not in (select c2.parentCat from categories c2);

select p1.name ,p1.price from products p1 inner join productCat p2 on p1.productid=p2.productid and p2.category='Cloths';

select name,quantity from inventory where quantity<=50;

select orderId,Date,totalcost from orders order by Date desc LIMIT 50; 

select orderId,totalcost from orders order by totalcost desc LIMIT 10;

select orderId,Date,totalcost from orders where status='not shipped' and CURDATE()-Date>=10;

select c1.name,c1.email from customers c1 inner join orders o1 on c1.userId=o1.userId where c1.userId not in (select c2.userId from customers c2 inner join orders o2 on c2.userId=o2.userId and  CURDATE()-o2.date<=31);

select c1.name,c1.email,o1.orderId from customers c1 inner join orders o1 on c1.userId=o1.userId and CURDATE()-o1.date<=15;

select o1.orderId,p1.name,o1.status from orders o1 inner join products p1 on o1.productId=p1.productId and o1.status='shipped';


select o1.orderId,p1.name,o1.Date,p1.price from orders o1 inner join products p1 on o1.productId=p1.productId and p1.price>=100 and p1.price<=400;






