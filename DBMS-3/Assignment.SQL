Assignment 2:
select p.productId,p.name,count(pc.productId) from products p inner join productCat pc on p.productId=pc.productId GROUP BY pc.productId HAVING count(pc.productId)>1;

select count(productId) as total from products where price between 0 and 100;

select count(productId) as total from products where price between 100 and 500;

select count(productId) as total from products where price>500;

select c.catName,count(pc.category) from categories c inner join productcat pc on c.catName=pc.category group by pc.category;

select c.userId,c.name,c.number,count(o.userId) from customers c inner join orders o on c.userId=o.userId where DATEDIFF(CURDATE(),o.Date)<=30 group by o.userId;
 
select c.name from customers c inner join orders o on c.userId=o.userId where CURDATE()-o.DATE<=30 group by o.userId order by count(o.totalcost) desc limit 10;



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
