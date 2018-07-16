drop table if exists AL_PRODUCT;
create table AL_PRODUCT(
	ID VARCHAR2(10) not null ,

	BATCH VARCHAR2(30),

	PRODUCTNAME VARCHAR2(50),

	TEMP2 VARCHAR2(200),

	CREATOR VARCHAR2(10),

	LASTUPDATETIME DATE(7),

	TEMP3 VARCHAR2(200),

	PRODUCTTYPE VARCHAR2(10),

	CREATEDATE DATE(7),

	SPEC VARCHAR2(10),

	TEMP1 VARCHAR2(200),

	COLLECTIONTYPE VARCHAR2(10),

	TEMP4 VARCHAR2(200)
);