create database Dana_Finest;
use Dana_Finest;
drop database Dana_Finest;
create table admins(
id int primary key auto_increment,
admin_name varchar(50) not null,
password_ad varchar(50) not null,
full_name varchar(50) not null,
image text,
dob date not null,
gender boolean not null,
email varchar(30) not null,
address varchar(100),
position varchar(20) not null,
phoneNumber varchar(10) not null
);
create table customers(
	id int primary key auto_increment,
    name_customer varchar(50) not null,
    phone varchar(10) not null,
    address varchar(100),
    gender boolean,
    age int,
    image text
);
create table categories(
id int primary key auto_increment,
category_product varchar(20) not null
);
create table products(
id int primary key auto_increment,
name_product varchar(50) not null,
price decimal(15, 3) not null,
description_product text not null,
packing_date datetime not null,
id_category int not null,
foreign key(id_category) references categories(id)
);
create table orders(
id int primary key auto_increment,
time_order datetime not null,
id_customer int not null,
address varchar(100),
status_order int,
total_price decimal(15,3) not null,
-- status: 0(Đã đặt hàng);1(Chưa thanh toán);2(Đã thanh toán) 
foreign key(id_customer) references customers(id)
);
create table details_order(
id int primary key auto_increment,
id_order int not null,
id_product int not null,
quantity int not null,
price_detail_order decimal(15,3) not null,
foreign key(id_order) references orders(id),
foreign key(id_product) references products(id)
);
