drop table if exists NEEDTAXCONTROL;
create table NEEDTAXCONTROL(
	ID VARCHAR2(32) not null ,

	OTHER VARCHAR2(32),

	DEADLINE DATE(7),

	BEER VARCHAR2(32),

	YELLOW VARCHAR2(32),

	WHITE VARCHAR2(32),

	NEEDTAX VARCHAR2(32),

	ENT VARCHAR2(32),

	CREDIT_ VARCHAR2(32)
);
