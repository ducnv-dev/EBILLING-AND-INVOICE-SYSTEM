--Create Database--
create DATABASE EBILLING
GO
USE EBILLING
GO
------------------------------------------------------------------
					-- CREATE TABLES --
------------------------------------------------------------------

-------------------- CREATE TABLE UserType -----------------------
CREATE TABLE UserType
(
	userTypeCode nvarchar(20) NOT NULL,
	userTypeName nvarchar(50) NOT NULL,	
)
GO

-------------------- CREATE TABLE UserID --------------------------
CREATE TABLE Users
(
	userCode int identity(1,1) NOT NULL,
	userLogin nvarchar(50) NOT NULL,
	[password] nvarchar(20) NOT NULL,
	fullName nvarchar(100) NOT NULL,
	userTypeCode nvarchar(20) NOT NULL,	
	userAddress nvarchar(100),
	userphone nvarchar(15),
	userEmail nvarchar(100),
	userActive bit,
)
GO
				-- ADD PRIMARY KEY
-------------------------------------------------------------------
ALTER TABLE Users
	ADD CONSTRAINT PK_userCode
	primary key(userCode)
GO

ALTER TABLE UserType
	ADD CONSTRAINT PK_userTypeCode 
	primary key(userTypeCode)
GO
-------------------------------------------------------------------
				-- ADD FOREIGN KEY
-------------------------------------------------------------------
ALTER TABLE Users
	ADD CONSTRAINT FK_userTypeCode 
	foreign key(userTypeCode)
	references UserType(userTypeCode)
GO
-------------------------------------------------------------------
			-- INSERT DATA EXAMPLE FOR TABLE IN DATABASE
-------------------------------------------------------------------
					-- INSERT DATA INTO TABLE UserType
-------------------------------------------------------------------
INSERT INTO UserType
	VALUES('M','Manage')
INSERT INTO UserType
	VALUES('A','Accountant')
INSERT INTO UserType
	VALUES('S','Seller')
GO
-------------------------------------------------------------------
					-- INSERT DATA INTO TABLE Users
-------------------------------------------------------------------
INSERT INTO Users
	VALUES(	'ducnv','ducnv',
			'Nguyen Van Duc','M','Ha Noi',
			'0983932993','ducnvgc00560@fpt.edu.vn',1)
GO

INSERT INTO Users
	VALUES(	'muoimd','muoimd',
			'Mai Duc Muoi','S','Ha Noi',
			'0987432123','muoimd@fpt.edu.vn',1)
GO
INSERT INTO Users
	VALUES(	'QuyenND','quyennd',
			'Nguyen Gia Quyen','A','Ha Noi',
			'0983938882','Quyennd00560@fpt.edu.vn',1)
GO
------------------------------------------------------------
CREATE TABLE PRODUCT_TYPE(
	TYPE_CODE INT identity(1,1) NOT NULL PRIMARY KEY,
	[TYPE_NAME] NVARCHAR(MAX) NOT NULL
)
GO
INSERT INTO PRODUCT_TYPE
	VALUES('CLOTHES')
INSERT INTO PRODUCT_TYPE
	VALUES('FURNITURE')
INSERT INTO PRODUCT_TYPE
	VALUES('FOOTWEAR')
INSERT INTO PRODUCT_TYPE
	VALUES('APPAREL')
GO

------------------------------------------------------------
CREATE TABLE SUPPLIER(
	SUPPLIER_CODE INT identity(1,1) NOT NULL PRIMARY KEY,
	[SUPPLIER_NAME] NVARCHAR(MAX) NOT NULL
)
GO
INSERT INTO SUPPLIER
	VALUES('VIETAN')
INSERT INTO SUPPLIER
	VALUES('HUNGPHONG')
INSERT INTO SUPPLIER
	VALUES('NGAPHUONG')
INSERT INTO SUPPLIER
	VALUES('HOANGGIA')
GO
		
----------TABLE PRODUCT-------------
CREATE TABLE PRODUCT(
	PRODUCT_CODE INT identity(1,1) NOT NULL PRIMARY KEY,
	PRODUCT_NAME NVARCHAR(MAX) NOT NULL,
	PRODUCT_TYPE INT NOT NULL,
	SUPPLIER_CODE INT NOT NULL,
	PRODUCT_PRICE INT NOT NULL,
	PRODUCT_AVAILABLEAMOUNT INT NOT NULL,
	PRODUCT_INFO NVARCHAR(MAX)
)
GO
INSERT INTO PRODUCT
	VALUES('Product 001',2,1,1000000,500,'KHONG CO GI DAU')
GO
INSERT INTO PRODUCT
	VALUES('Product 002',1,2,5000000,500,'KHONG CO GI DAU')
GO
INSERT INTO PRODUCT
	VALUES('Product 003',3,4,4500000,500,'KHONG CO GI DAU')
GO
INSERT INTO PRODUCT
	VALUES('Product 004',1,3,3000000,500,'KHONG CO GI DAU')
GO
INSERT INTO PRODUCT
	VALUES('Product 005',4,2,550000,500,'KHONG CO GI DAU')
GO
INSERT INTO PRODUCT
	VALUES('Product 006',3,1,6500000,500,'KHONG CO GI DAU')
GO
INSERT INTO PRODUCT
	VALUES('Product 007',2,2,2000000,500,'KHONG CO GI DAU')
GO
INSERT INTO PRODUCT
	VALUES('Product 008',3,4,4500000,500,'KHONG CO GI DAU')
GO
INSERT INTO PRODUCT
	VALUES('Product 009',1,3,2000000,500,'KHONG CO GI DAU')
GO
INSERT INTO PRODUCT
	VALUES('Product 0010',4,1,6000000,500,'KHONG CO GI DAU')
GO
ALTER TABLE PRODUCT
	ADD CONSTRAINT FK_PRODUCT_TYPE
	foreign key(PRODUCT_TYPE)
	references PRODUCT_TYPE(TYPE_CODE)
GO

ALTER TABLE PRODUCT
	ADD CONSTRAINT FK_SUPLLIER_CODE
	foreign key(SUPPLIER_CODE)
	references SUPPLIER(SUPPLIER_CODE)
GO

---------------------------------------
CREATE TABLE CUSTOMER(
	CUSTOMER_CODE INT identity(1,1) NOT NULL PRIMARY KEY,
	CUSTOMER_NAME NVARCHAR(MAX) NOT NULL,
	CUSTOMER_PHONE NVARCHAR(MAX) NOT NULL,
	CUSTOMER_ADDRESS NVARCHAR(MAX)NOT NULL
)
GO

--------------------------------------

CREATE TABLE EBILL(
	EBILL_CODE INT identity(1,1) NOT NULL PRIMARY KEY,
	CUSTOMER_CODE INT,
	USER_CODE INT,
	EBILL_DATE DATE NOT NULL,
	EBILL_TOTALPRICE INT NOT NULL
)
GO
---------------------------------------
CREATE TABLE EBILL_DETAILS(
	PRODUCT_CODE INT,
	EBILL_CODE INT NOT NULL,
	PRODUCT_QUANTITY INT  NOT NULL
)
GO
---------------------------------------------
ALTER TABLE EBILL
	ADD CONSTRAINT FK_customerCode
	foreign key(CUSTOMER_CODE)
	references CUSTOMER(CUSTOMER_CODE) ON DELETE SET NULL
GO

ALTER TABLE EBILL
	ADD CONSTRAINT FK_userCode_EBILL
	foreign key(USER_CODE)
	references Users(userCode) ON DELETE SET NULL
GO


------------------------------------------
ALTER TABLE EBILL_DETAILS
	ADD CONSTRAINT FK_productCode_Ebill
	foreign key(PRODUCT_CODE)
	references PRODUCT(PRODUCT_CODE) ON DELETE SET NULL
GO

ALTER TABLE EBILL_DETAILS
	ADD CONSTRAINT FK_EbillCode
	foreign key(EBILL_CODE)
	references EBILL(EBILL_CODE)
GO

--ALTER TABLE EBILL_DETAILS
--	ADD CONSTRAINT PK_PRODUCTCode_EBILLCode
--	primary key(PRODUCT_CODE,EBILL_CODE)
--GO
---------------------------------------
INSERT INTO CUSTOMER
	VALUES(	'DucNV','0983932993',
			'Ha Noi')
GO
	