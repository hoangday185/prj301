create database flowerShopDB  
--drop database flowerShopDB
use flowerShopDB
use WS1
--drop table categoryFlower
create table categoryFlower(
	CategoryId  DECIMAL(18,0) IDENTITY(1000,1) not null,
	CategoryName nvarchar(30) not null,
	constraint PK_Cateogry_Id PRIMARY KEY(CategoryId),
);
--drop table flower
create table flower (
  flowerID DECIMAL(18,0) IDENTITY(100000,2) not null,
  flowerName nvarchar(30) not null,
  categoryID DECIMAL(18,0) not null,
  price Decimal(18, 0) not null,
  amout Decimal(18,0) not null,
  urlImg nvarchar(100) not null,
  status int not null,
  constraint PK_FLOWER_ID PRIMARY KEY(flowerID),
   constraint PK__CATEGORYID_CATEGORY_ID
  FOREIGN KEY (categoryID) REFERENCES CategoryFlower(CategoryId)
)

--drop table orderFlower

create table orderFlower(
  OrderID decimal(18,0) IDENTITY(1000000,2) not null Primary key,
  CusId decimal(18,0) not null,
  OrderDate date not null,
  priceShip nvarchar(10) not null,
  shipperID DECIMAL(18,0),
  status int not null,
)
--drop table orderDetail
create table orderDetail(
 OrderID decimal(18,0) not null,
 floID DECIMAL(18,0) not null,
 quantity int not null
)

--drop table Account

create table Account(
   accountID DECIMAL(18,0) IDENTITY(100,2) not null Primary key,
   email nvarchar(30) not null,
   password nvarchar(30) not null,
   role int not null,
   status int not null,
)
--drop table shipper 
create table Shipper(
	shipperID DECIMAL(18,0) IDENTITY(3000000,1) not null Primary key,
	shipperName nvarchar(50) not null,
	address nvarchar(100),
	gender int,
	birthday Date ,
	salary Decimal(18,0) not null,
	phone nvarchar(10) not null,
	dateStart Date, 
	accountId Decimal not null,
)
--drop table Admin
Create table Admin (
	AdminID DECIMAL(18,0) IDENTITY(2000000,1) not null Primary key,
	AdminName nvarchar(50) not null,
	address nvarchar(100),
	gender int,
	birthday Date ,
	salary Decimal(18,0) not null,
	phone nvarchar(10) not null,
	dateStart Date, 
	accountId Decimal not null,
)
--drop table customer
Create table customer (
	CutomerID DECIMAL(18,0) IDENTITY(4000000,1) not null Primary key,
	CusName nvarchar(50) not null,
	address nvarchar(100),
	gender int,
	birthday Date ,
	phone nvarchar(10) not null,
	dateStart Date, 
	accountId Decimal not null,
)
--drop table feedback
create table feedback (
 FeedbackID Decimal(18,0) IDENTITY(50000000,1) not null Primary key, 
 CusId DECIMAL(18,0) not null, 
 OrderID decimal(18,0) not null,
 Descripton nvarchar(100) not null,
 DateFeedback date not null, 
)
ALTER TABLE OrderFlower
ADD CONSTRAINT FK_ID_SHIPPER
FOREIGN KEY (shipperID) REFERENCES Shipper(shipperID);

ALTER TABLE Feedback
ADD CONSTRAINT FK_Feedback_Flower
FOREIGN KEY (orderID) REFERENCES orderFlower(OrderID);

ALTER TABLE OrderFlower
ADD CONSTRAINT FK_Order_Flower
FOREIGN KEY (CusID) REFERENCES customer(cutomerID);

ALTER TABLE Feedback
ADD CONSTRAINT FK_Feedback_Customer
FOREIGN KEY (CusID) REFERENCES customer(cutomerID);

--ALTER TABLE Feedback
--ADD CONSTRAINT FK_Order
--FOREIGN KEY (OrderID) REFERENCES orderFlower(OrderID);

ALTER TABLE Customer 
ADD CONSTRAINT FK_Customer_ID
FOREIGN KEY (accountID) REFERENCES Account(accountId);

ALTER TABLE Shipper
ADD CONSTRAINT FK_Shipper_ACCOUNT_ID
FOREIGN KEY (accountID) REFERENCES Account(accountId);

ALTER TABLE Admin
ADD CONSTRAINT FK_Admin_ACCOUNT_ID
FOREIGN KEY (accountID) REFERENCES Account(accountId);

ALTER TABLE orderDetail
ADD CONSTRAINT FK_Flower_ID
FOREIGN KEY (floID) REFERENCES flower(flowerId);

ALTER TABLE orderDetail
ADD CONSTRAINT FK_ORDER_ID
FOREIGN KEY (orderID) REFERENCES orderFlower(orderID)



