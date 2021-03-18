Assignment 1;

CREATE TABLE Admin(adminId int NOT NULL AUTO_INCREMENT,name varchar(50),email vrachar(30) UNIQUE,number varchar(10) UNIQUE,PRIMARY KEY(adminId));

CREATE TABLE Customers(userId int NOT NULL AUTO_INCREMENT,name varchar(50),email varchar(30) UNIQUE,number varchar(10) UNIQUE,PRIMARY KEY(userId);

CREATE TABLE Products(productId int NOT NULL AUTO_INCREMENT,name varchar(50) UNIQUE,Price int,status varchar(10),Date DATE,PRIMARY KEY(productId));

CREATE TABLE Categories(catId int NOT NULL AUTO_INCREMENT,catName varchar(30),parentCat varchar(30),PRIMARY KEY(catId);

CREATE TABLE Inventory(itemId int NOT NULL AUTO_INCREMENT,name varchar(50) UNIQUE,quantity int,PRIMARY KEY(itemId));

CREATE TABLE Orders(orderId int NOT NULL AUTO_INCREMENT,userId int,productId int,Date DATE,status varchar(20),totalCost int,PRIMARY KEY(orderId));

CREATE TABLE CustomersAddress(userId int,address varchar(30),PRIMARY KEY(userId,address),FOREIGN KEY(userId) REFERENCES CUSTOMERS(userId) ON DELETE CASCADE ON UPDATE CASCADE);

CREATE TABLE ProductCat(productid int,category varchar(20),PRIMARY KEY(productId,category));

CREATE TABLE ProductImages(imageId int NOT NULL AUTO_INCREMENT PRIMARY KEY,images BLOB,productId int,PRIMARY KEY(imageId,product Id));




Assignment 2:
select p.productId,p.name,count(pc.productId) from products p inner join productCat pc on p.productId=pc.productId GROUP BY pc.productId HAVING count(pc.productId)>1;

select count(productId) as total from products where price between 0 and 100;

select count(productId) as total from products where price between 100 and 500;

select count(productId) as total from products where price>500;

select c.catName,count(pc.category) from categories c inner join productcat pc on c.catName=pc.category group by pc.category;

select c.userId,c.name,c.number,c.email,count(o.userId) as numOfOrder from customers c inner join orders o on c.userId=o.userId where DATEDIFF(CURDATE(),o.Date)<=30 group by o.userId;
 
select c.name from customers c inner join orders o on c.userId=o.userId where CURDATE()-o.DATE<=30 group by o.userId order by count(o.totalcost) desc limit 10;

select p1.name,count(o.productId) from products p1 inner join orders o on p1.productId=o.productId where DATEDIFF(CURDATE(),o.Date)<=60 group by o.productId order by count(o.productId) desc limit 20;

select month(Date) as ForMonth,sum(totalCost) from Orders where MONTH(CURDATE())-Month(Date)<=6 Group by Month(Date);

Update Products p1 set p1.status='Inactive' where p1.status='In Stock' and p1.productId not in (select o1.productId from orders o1 where DATEDIFF(CURDATE(),o1.Date)<=90);

select p.name,pc.category from products p inner join productCat pc on p.productId=pc.productId where pc.category='cloths';

select p1.name,o1.status from products p1 inner join orders o1 on p1.productId=o1.productId where o1.status='cancelled' group by o1.productId order by count(o1.productId) desc limit 10;

CREATE VIEW OrderDetails AS select o1.orderId,p1.name as ProductName,o1.totalCost,c1.name,c1.email,o1.Date,o1.status from orders o1 inner join customers c1 on o1.userId=c1.userId inner join products p1 on o1.productId=p1.productId where DATEDIFF(CURDATE(),o1.Date)<=60;

select ProductName,status from OrderDetails where status='shipped';

select ProductName from OrderDetails group by productname order by count(productname) desc limit 5;


Assignment:4

CREATE DATABASE zip;
USE zip;
CREATE TABLE cities(cityId int NOT NULL AUTO_INNCREMENT PRIMARY KEY,city varchar(30) UNIQUE,state varchar(30));
CREATE TABLE zipcode(zipcode int UNIQUE NOT NULL,region varchar(30) UNIQUE,city varchar(30),PRIMARY KEY(zipcode,city));

INSERT INTO cities(city,state) VALUES ('Udaipur','Rajasthan');
INSERT INTO cities(city,state) VALUES ('chittorgarh','Rajasthan');
INSERT INTO cities(city,state) VALUES ('rajsamand','Rajasthan');
INSERT INTO cities(city,state) VALUES ('bhilwara','Rajasthan');
INSERT INTO cities(city,state) VALUES ('jaipur','Rajasthan');
INSERT INTO cities(city,state) VALUES ('dispur','Assam');
INSERT INTO cities(city,state) VALUES ('Bikaner','Rajasthan');
INSERT INTO cities(city,state) VALUES ('Shimla','Himachal');
INSERT INTO cities(city,state) VALUES ('rishikesh','Utrakhand');
INSERT INTO cities(city,state) VALUES ('indore','MP');
INSERT INTO cities(city,state) VALUES ('gwalior','MP');
INSERT INTO cities(city,state) VALUES ('bhopal','MP');
INSERT INTO cities(city,state) VALUES ('pali','Rajasthan');
INSERT INTO cities(city,state) VALUES ('panaji','Goa');
INSERT INTO cities(city,state) VALUES ('jodhpur','Rajasthan');
INSERT INTO cities(city,state) VALUES ('kota','Rajasthan');
INSERT INTO cities(city,state) VALUES ('Udaipur','Rajasthan');
INSERT INTO cities(city,state) VALUES ('Udaipur','Rajasthan');
INSERT INTO cities(city,state) VALUES ('Udaipur','Rajasthan');

INSERT INTO zipcode(zipcode,region,city) VALUES (31031,'Hiran Magri','Udaipur');
INSERT INTO zipcode(zipcode,region,city) VALUES (31032,'Old city','Udaipur');
INSERT INTO zipcode(zipcode,region,city) VALUES (31039,'sector 6','Udaipur');
INSERT INTO zipcode(zipcode,region,city) VALUES (31131,'jhotwara','jaipur');
INSERT INTO zipcode(zipcode,region,city) VALUES (31139,'malviya nagar','jaipur');
INSERT INTO zipcode(zipcode,region,city) VALUES (31021,'Madhuban','chittorgarh');
INSERT INTO zipcode(zipcode,region,city) VALUES (41031,'sector 9','gwalior');

select z.zipcode,z.region,c.city,c.state from zipcode z inner join cities c on z.city=c.city order by c.state,c.city
