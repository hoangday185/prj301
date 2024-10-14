use flowerShopDB
select * from Account
select * from Shipper
select * from customer
select * from Admin
insert into Account values ('admin01@gmail.com','admin',1,0)
insert into Account values ('shipper01@gmail.com','shipper',2,1)
UPDATE Account
SET  status = 0
WHERE role = '1'
insert into Account values ('shipper02@gmail.com','shipper',2,1)
insert into Account values ('shipper03@gmail.com','shipper',2,1)
insert into Account values ('customer01@gmail.com','customer',3,0)
insert into Account values ('customer02@gmail.com','customer',3,0)
insert into Account values ('customer03@gmail.com','customer',3,0)
insert into Account values ('customer06@gmail.com','customer',3,1)
insert into Account values ('customer07@gmail.com','customer',3,1)
insert into 
	Shipper values('shipper01',
				   N'Đồng Nai', 1,'2000-09-10', 
				   7000000, '0123xxxxxx', '2021-01-01', 102)
insert into 
	Shipper values('shipper02',
				   N'Đồng Nai', 1,'2000-09-10', 
				   7000000, '0123xxxxxx', '2021-01-01', 110)
insert into 
	Shipper values('shipper03',
				   N'Đồng Nai', 1,'2000-09-10', 
				   7000000, '0123xxxxxx', '2021-01-01', 112)
insert into 
	Admin values('admin01',
				   N'Hồ Chí Minh', 1,'1988-08-01', 
				   15000000, '0123xyxxxx', '2019-01-03', 100)
insert into 
	customer values('cus01',
				   N'Quận 7', 1,'1988-08-01', 
				   '0123xyzxxx', '2019-01-03', 106)
insert into 
	customer values('cus03',
				   N'Quận 9', 1,'1988-08-01', 
				   '0123xyzxxx', '2019-01-03', 108)
insert into 
	customer values('cus06',
				   N'Quận 7', 1,'1988-08-01', 
				   '0123xyzxxx', '2019-01-03', 138)
insert into 
	customer values('cus07',
				   N'Quận 7', 1,'1988-08-01', 
				   '0123xyzxxx', '2019-01-03', 140)
select shipperID, shipperName, address, 
	   gender,birthday, salary, phone,dateStart 
	   from Shipper where accountId = 0
select CutomerID, CusName, 
       address, gender, birthday, 
	   phone , dateStart, accountId from customer  where CutomerID = 4000000
select  AdminID, AdminName, address, 
	   gender,birthday, salary, phone,dateStart 
	   from Admin where accountId = 0
select shipperID, shipperName, gender ,phone from Shipper where shipperID = 
insert into 
	categoryFlower values(N'Hoa lá')
	insert into 
	categoryFlower values(N'Hoa nước')
	insert into 
	categoryFlower values(N'Hoa đất')
insert into flower values(N'Hoa sen',1000, 100000, 100, N'img/01-hoasen.png',1)
insert into flower values(N'Hoa súng',1000, 100000, 150, N'img/01-hoasen.png',1)
insert into flower values(N'Hoa râm bụt',1000, 100000, 130, N'img/01-hoasen.png',1)
select CategoryId, CategoryName from categoryFlower where CategoryId = 1000
select 
        flowerID,flowerName,
		categoryID, price, amout, urlImg,status  
			from flower
select OrderID, CusId, OrderDate, 
		priceShip, shipperID, status from orderFlower
		
select * from flower
select * from orderFlower
select * from orderDetail
insert into 
	orderFlower values(4000000,'2023-11-30','28000',NULL,1)
insert into orderDetail values(1000006,100002,3)
insert into orderDetail values(1000006,100004,7)
insert into 
	orderFlower values(4000010,'2023-10-30','25000',NULL,1)
insert into orderDetail values(1000004,100002,5)
insert into orderDetail values(1000004,100000,3)
insert into 
	orderFlower values(4000000,'2023-09-30','30000',NULL,1)
insert into orderDetail values(1000002,100004,3)
insert into orderDetail values(1000002,100002,5)
insert into orderDetail values(1000002,100000,1)
--4000009, 4000010, 4000000
insert into 
	orderFlower values(4000009,'2023-10-30','20000',NULL,1)
insert into orderDetail values(1000000,100000,20)
insert into orderDetail values(1000000,100002,10)

select OrderID, floID, quantity from orderDetail
         where OrderID in 
		( select OrderID from orderFlower where status = 1 )

select floID, quantity from orderDetail where OrderID = 1000000
select shipperID, shipperName from Shipper

UPDATE Account
SET status =  where accountID =  


select * from orderFlower
select * from Shipper
	select * from customer
	select* from flower
	select CategoryId, CategoryName from categoryFlower