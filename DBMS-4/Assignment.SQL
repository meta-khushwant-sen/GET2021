1.
DELIMITER //
CREATE FUNCTION getOrders(d DATE) RETURNS int DETERMINISTIC
BEGIN
return (select count(orderId) from orders where month(DATE)=month(d) and year(DATE)=year(d) group by DATE);
END;//
select getOrders(CURDATE());


2.
delimiter //
CREATE PROCEDURE averageSale(d DATE)
BEGIN
	select avg(totalCost),productId from orders where month(DATE)=month(d) and year(DATE)=year(d) group by productId;
END;//

CALL averageSale(CURRDATE());//


3.
delimeter //
CREATE PROCEDURE getOrderDetails(d1 DATE.d2 DATE)
BEGIN
	if(d2<=d1)
	then
	set d1=date_format(d1,'%y-%m-01');
	end if;
	select orderId,status  from where DATE between d1 and d2;
END;//

CALL getOrderDetails('2021-02-05','2021-03-16');//



4.
ALTER TABLE orders ADD INDEX iop(productId);

ALTER TABLE orders ADD INDEX pqr(catId);

ALTER TABLE orders ADD INDEX sdf(orderId);



5.

DELIMITER //
CREATE FUNCTION getMonths(d DATE) RETURNS int DETERMINISTIC
BEGIN
return (select Month(Date) from orders where year(DATE)=year(d) group by DATE order by count(orderId) desc limit 1);
END;//

select getMonth(CURRDATE());

