CREATE DATABASE mobileStore
USE mobileStore;

CREATE TABLE user(

    id int auto_increment,
    email varchar(255),
    password varchar(255),
    id_role int,
      
    primary key(id)
);

CREATE TABLE role(
	
    id int auto_increment,
    name varchar(255),
    
    primary key(id)
);

CREATE TABLE color(

	id int auto_increment,
    colorName varchar(255),
    
    primary key(id)
	
);

CREATE TABLE storage(
	
	id int auto_increment,
    storageName varchar(255),
    
    primary key(id)
);

CREATE TABLE tag(
	
	id int auto_increment,
    tagName varchar(255),
    
    primary key(id)
);

CREATE TABLE promotion(
	
	id int auto_increment,
    promotionName varchar(255),
    
    primary key(id)
);

CREATE TABLE category(
	
	id int auto_increment,
    categoryName varchar(255),
    
    primary key(id)
);

CREATE TABLE product(

	id int auto_increment,
	images varchar(255),
	title varchar(255),
	price double,
	discountPrice double,
	id_category int,
	id_rating int,
	tags varchar(255),
	
	primary key(id)
);

CREATE TABLE productdetail(
	
	id_product_detail int auto_increment,
	id_color int,
	id_product int,
	id_storage int,
	id_promotion int,
	sku varchar(255),
	quantity int,
	description varchar(255),
	
	primary key(id_product_detail)
);

CREATE TABLE rating(
	
	id int auto_increment,
	id_product int,
	ratingTotal int,
	
	primary key(id)
);

CREATE TABLE ratingdetail(
	id_rating int,
	id_user int,
	id_product int,
	ratingScore int,
	ratingTitle varchar(255),
	ratingDate datetime,
	ratingContent varchar(255),

	primary key(id_rating)
);

CREATE TABLE orders(
	
	id int auto_increment,
	id_user int,
	total_price double,
	create_date datetime,
	
	primary key(id)
);

CREATE TABLE orderdetail(
	
	id_order int auto_increment,
	id_product_detail int,
	id_user int,
	price double,
	quantity int,
	create_date datetime,
	
	primary key(id_order)
);

CREATE TABLE comment(
	
	id int auto_increment,
	commentContent varchar(255),
	email varchar(255),
	mobile varchar(255),
	
	primary key(id)
);


ALTER TABLE user ADD CONSTRAINT FK_id_role_User
FOREIGN KEY (id_role) REFERENCES role(id);

ALTER TABLE productdetail ADD CONSTRAINT FK_id_color_ProductDetail
FOREIGN KEY (id_color) REFERENCES color(id);

ALTER TABLE productdetail ADD CONSTRAINT FK_id_product_ProductDetail
FOREIGN KEY (id_product) REFERENCES product(id);

ALTER TABLE productdetail ADD CONSTRAINT FK_id_storage_ProductDetail
FOREIGN KEY (id_storage) REFERENCES storage(id);

ALTER TABLE productdetail ADD CONSTRAINT FK_id_promotion_ProductDetail
FOREIGN KEY (id_promotion) REFERENCES promotion(id);

ALTER TABLE product ADD CONSTRAINT FK_id_category_Product
FOREIGN KEY (id_category) REFERENCES category(id);

ALTER TABLE orders ADD CONSTRAINT FK_id_user_Order
FOREIGN KEY (id_user) REFERENCES user(id);

ALTER TABLE orderdetail ADD CONSTRAINT FK_id_product_detail_OrderDetail
FOREIGN KEY (id_product_detail) REFERENCES productdetail(id_product_detail);

ALTER TABLE orderdetail ADD CONSTRAINT FK_id_user_OrderDetail
FOREIGN KEY (id_user) REFERENCES user(id);

ALTER TABLE rating ADD CONSTRAINT FK_id_product_Rating
FOREIGN KEY (id_product) REFERENCES product(id);

ALTER TABLE ratingdetail ADD CONSTRAINT FK_id_rating_RatingDetail
FOREIGN KEY (id_rating) REFERENCES rating(id);

ALTER TABLE ratingdetail ADD CONSTRAINT FK_id_product_RatingDetail
FOREIGN KEY (id_product) REFERENCES product(id);

ALTER TABLE ratingdetail ADD CONSTRAINT FK_id_user_RatingDetail
FOREIGN KEY (id_user) REFERENCES user(id);



