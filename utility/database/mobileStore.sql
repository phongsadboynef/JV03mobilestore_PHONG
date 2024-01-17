CREATE DATABASE mobileStore
USE mobileStore;

CREATE TABLE role(
	
    id int auto_increment,
    name varchar(255),
    createdAt timestamp,
    deletedAt timestamp,
    
    primary key(id)
);

CREATE TABLE user(

    id int auto_increment,
    email varchar(255),
    password varchar(255),
    usrFirstName varchar(255),
    usrLastName varchar(255),
    usrDOB date,
    id_role int,
    createdAt timestamp,
    deletedAt timestamp,
      
    primary key(id)
);

CREATE TABLE customer(
    id int auto_increment,
    email varchar(255),
    password varchar(255),
    custFirstName varchar(255),
    custLastName varchar(255),
    customerRank varchar(50),
    id_role int,
    createdAt timestamp,
    deletedAt timestamp,
      
    primary key(id)
);

CREATE TABLE address(
	id int auto_increment,
	addressTitle varchar(50),
	addressLine1 varchar(255),
	addressLine2 varchar(255),
	city varchar(50),
	country varchar(100),
	postalCode varchar(30),
	phoneNumber varchar(50),
    id_customer int,
    createdAt timestamp,
    deletedAt timestamp,
      
    primary key(id)
);

CREATE TABLE color(

	id int auto_increment,
    colorName varchar(255),
    createdAt timestamp,
    deletedAt timestamp,
    
    primary key(id)
);

CREATE TABLE storage(
	
	id int auto_increment,
    storageName varchar(255),
    createdAt timestamp,
    deletedAt timestamp,
    
    primary key(id)
);

CREATE TABLE tag(
	
	id int auto_increment,
    tagName varchar(255),
    createdAt timestamp,
    deletedAt timestamp,
    
    primary key(id)
);

CREATE TABLE promotion(
	
	id int auto_increment,
    promotionName varchar(100),
    promotionDescription varchar(255),
    createdAt timestamp,
    deletedAt timestamp,
    
    primary key(id)
);

CREATE TABLE category(
	
	id int auto_increment,
    categoryName varchar(255),
    createdAt timestamp,
    deletedAt timestamp,
    
    primary key(id)
);

CREATE TABLE product(

	id int auto_increment,
	images varchar(255),
	title varchar(255),
	id_category int,
	createdAt timestamp,
    deletedAt timestamp,
	
	primary key(id)
);

CREATE TABLE productdetail(
	
	id_product_detail int auto_increment,
	id_color int,
	id_product int,
	id_storage int,
	id_tag int,
	id_promotion int,
	sku varchar(255),
	price double,
	discountPrice double,
	quantity int,
	description varchar(255),
	createdAt timestamp,
    deletedAt timestamp,
	
	primary key(id_product_detail)
);

CREATE TABLE review(
	
	id int auto_increment,
	reviewTitle varchar(100),
	reviewDate timestamp,
	id_user int,
	createdAt timestamp,
    deletedAt timestamp,
	
	primary key(id)
);

CREATE TABLE reviewdetail(
	id_review int,
	id_user int,
	id_product int,
	rating int,
	reviewComment varchar(255),
	createdAt timestamp,
    deletedAt timestamp,

	primary key(id_review)
);

CREATE TABLE comment(
	
	id int auto_increment,
	commentTitle varchar(100),
	commentContent varchar(255),
	email varchar(255),
	mobile varchar(255),
	id_product int,
	createdAt timestamp,
    deletedAt timestamp,
	
	primary key(id)
);

CREATE TABLE cart(
	id int auto_increment,
	id_user int,
	total int,
	createdAt timestamp,
    deletedAt timestamp,
    
    primary key(id)
);

CREATE TABLE cartdetail(
	id int auto_increment,
	id_cart int,
	id_product int,
	id_product_detail int,
	quantity int,
	createdAt timestamp,
    deletedAt timestamp,
    
    primary key(id)
);

CREATE TABLE orders(
	
	id int auto_increment,
	id_user int,
	id_payment int,
	total_price double,
	create_date datetime,
	createdAt timestamp,
    deletedAt timestamp,
	
	primary key(id)
);

CREATE TABLE orderdetail(
	
	id_order int auto_increment,
	id_product_detail int,
	id_user int,
	price double,
	quantity int,
	create_date datetime,
	createdAt timestamp,
    deletedAt timestamp,
	
	primary key(id_order)
);

CREATE TABLE payment(
	id int auto_increment,
	amount double,
	provider varchar(255),
	status varchar(50),
	id_order int,
	createdAt timestamp,
    deletedAt timestamp,
    
    primary key(id)
);

ALTER TABLE user ADD CONSTRAINT FK_id_role_User
FOREIGN KEY (id_role) REFERENCES role(id);

ALTER TABLE customer ADD CONSTRAINT FK_id_role_Customer
FOREIGN KEY (id_role) REFERENCES role(id);

ALTER TABLE address ADD CONSTRAINT FK_id_customer_Address
FOREIGN KEY (id_customer) REFERENCES customer(id);

ALTER TABLE product ADD CONSTRAINT FK_id_category_Product
FOREIGN KEY (id_category) REFERENCES category(id);

ALTER TABLE productdetail ADD CONSTRAINT FK_id_color_ProductDetail
FOREIGN KEY (id_color) REFERENCES color(id);

ALTER TABLE productdetail ADD CONSTRAINT FK_id_product_ProductDetail
FOREIGN KEY (id_product) REFERENCES product(id);

ALTER TABLE productdetail ADD CONSTRAINT FK_id_storage_ProductDetail
FOREIGN KEY (id_storage) REFERENCES storage(id);

ALTER TABLE productdetail ADD CONSTRAINT FK_id_tag_ProductDetail
FOREIGN KEY (id_tag) REFERENCES tag(id);

ALTER TABLE productdetail ADD CONSTRAINT FK_id_promotion_ProductDetail
FOREIGN KEY (id_promotion) REFERENCES promotion(id);

ALTER TABLE review ADD CONSTRAINT FK_id_user_Review
FOREIGN KEY (id_user) REFERENCES user(id);

ALTER TABLE reviewdetail ADD CONSTRAINT FK_id_review_ReviewDetail
FOREIGN KEY (id_review) REFERENCES review(id);

ALTER TABLE reviewdetail ADD CONSTRAINT FK_id_product_ReviewDetail
FOREIGN KEY (id_product) REFERENCES product(id);

ALTER TABLE reviewdetail ADD CONSTRAINT FK_id_user_ReviewDetail
FOREIGN KEY (id_user) REFERENCES user(id);

ALTER TABLE comment ADD CONSTRAINT FK_id_product_Comment
FOREIGN KEY (id_product) REFERENCES product(id);

ALTER TABLE cart ADD CONSTRAINT FK_id_user_Cart
FOREIGN KEY (id_user) REFERENCES user(id);

ALTER TABLE cartdetail ADD CONSTRAINT FK_id_user_CartDetail
FOREIGN KEY (id_cart) REFERENCES cart(id);

ALTER TABLE cartdetail ADD CONSTRAINT FK_id_product_CartDetail
FOREIGN KEY (id_product) REFERENCES product(id);

ALTER TABLE cartdetail ADD CONSTRAINT FK_id_product_detail_CartDetail
FOREIGN KEY (id_product_detail) REFERENCES productdetail(id_product_detail);

ALTER TABLE orders ADD CONSTRAINT FK_id_user_Order
FOREIGN KEY (id_user) REFERENCES user(id);

ALTER TABLE orderdetail ADD CONSTRAINT FK_id_product_detail_OrderDetail
FOREIGN KEY (id_product_detail) REFERENCES productdetail(id_product_detail);

ALTER TABLE orderdetail ADD CONSTRAINT FK_id_user_OrderDetail
FOREIGN KEY (id_user) REFERENCES user(id);

ALTER TABLE payment ADD CONSTRAINT FK_id_order_Payment
FOREIGN KEY (id_order) REFERENCES orders(id);



