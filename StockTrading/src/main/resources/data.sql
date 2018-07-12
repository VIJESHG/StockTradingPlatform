insert into trader(trad_id,name,email,address,live_ords,status) values(1,'abc','abc@gmail.com','assdhffheril',0,1);
insert into Sector(sec_id, name, descr) values(1,'IT','information tech');
insert into Company(ticker, name, sec_id) values('APPL','Apple',1);
insert into Company(ticker, name, sec_id) values('GOOG','Google.inc',1);
insert into orders (order_id,status,request,price,num_of_shares,ticker,order_type,time_stamp,trader_id) 
values(1,'PENDING','BUY',100,5,'APPL','MARKET','2018-07-11',1);

