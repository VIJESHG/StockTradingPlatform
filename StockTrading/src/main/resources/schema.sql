drop table Trader if exists;
drop table Sector if exists;
drop table Company if exists;

create table Sector(
	sec_id int(11) not null PRIMARY KEY,
	name varchar(16) not null unique,
	descr varchar(40),
	
);

create table Company(
	ticker varchar(8) not null PRIMARY KEY,
	name varchar(32) not null,
	sec_id int(11) foreign key references Sector(sec_id)
);

create table Trader(
	trad_id int(11) not null PRIMARY KEY,
	name varchar(20) not null,
	email varchar(32),
	address varchar(40),
	live_ords int(8),
	status int(1)
);
