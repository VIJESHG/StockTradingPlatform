drop table Trader if exists;
drop table Sector if exists;
drop table Company if exists;
drop table Orders if exists;
drop table Transaction if exists;



create table Sector(
	sec_id int(11) not null PRIMARY KEY,
	name varchar(16) not null unique,
	descr varchar(40)
	
);

create table Company(
	ticker varchar(8) not null PRIMARY KEY,
	name varchar(32) not null,
	sec_id int(11),
	foreign key(sec_id) references Sector(sec_id)
);

create table Trader(
	trad_id int(11) not null PRIMARY KEY AUTO_INCREMENT,
	name varchar(20) not null,
	email varchar(32),
	address varchar(40),
	live_ords int(8),
	status int(1)
);


create table Orders(
order_id int(11) not null PRIMARY KEY AUTO_INCREMENT,
ticker varchar(8) not null,
request varchar(32) not null,
order_type varchar(32) not null,
price int(11),
num_of_shares int(11) not null,
trader_id int(11) not null,
status varchar(32) not null,
time_stamp TIMESTAMP not null,
foreign key(trader_id) references Trader(trad_id),
foreign key (ticker) references Company(ticker)
);

create table Transaction(
	trans_id int(11) not null PRIMARY KEY AUTO_INCREMENT,
	order_id int(11) not null,
	trader_id int(11) not null,
	time_stamp TIMESTAMP not null,
	status varchar(32) not null,
	price int(11),
	num_of_shares int(11) not null,
	order_type varchar(32) not null
);