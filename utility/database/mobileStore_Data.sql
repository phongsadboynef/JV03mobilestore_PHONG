INSERT INTO `role`
VALUES 
(1, 'ADMIN', CURRENT_TIMESTAMP(), NULL),
(2, 'USER', CURRENT_TIMESTAMP(), NULL),
(3, 'CUSTOMER', CURRENT_TIMESTAMP(), NULL);

INSERT INTO `user` 
VALUES
(1, 'kimkhoivu@gmail.com', 'khoivu123', 'Khôi', 'Vũ Kim', '1987-10-27', 1, 1, CURRENT_TIMESTAMP(), NULL),
(2, 'nguyenvana@yahoo.com', 'nguyenvana123', 'A', 'Nguyễn Văn', '1997-10-26', 1, 1, CURRENT_TIMESTAMP(), NULL),
(3, 'tranthib@gmail.com', 'tranthib456', 'B', 'Trần Thị', '1994-12-30', 0, 2, CURRENT_TIMESTAMP(), NULL),
(4, 'dinhvanc@hotmail.com', 'dinhvanc456', 'C', 'Đinh Văn', '1996-03-31', 1, 2, CURRENT_TIMESTAMP(), NULL),
(5, 'truongmyd@gmail.com', 'truongmyd789', 'D', 'Trương Mỹ', '1998-05-15', 0, 2, CURRENT_TIMESTAMP(), NULL);


INSERT INTO customer
VALUES
(1, 'trinhthie@gmail.com', 'trinhthie123', 'E', 'Trịnh Thị', '1981-08-26', 0, 'Vàng', 3, CURRENT_TIMESTAMP(), NULL),
(2, 'hoangdinhf@hotmail.com', 'hoangdinhf456', 'F', 'Hoàng Đình', '1982-09-11', 1, 'Đồng', 3, CURRENT_TIMESTAMP(), NULL),
(3, 'nguyenthingocg@yahoo.com', 'nguyenthingocg789', 'G', 'Nguyễn Thị Ngọc', '1991-03-12', 0, 'Bạc', 3, CURRENT_TIMESTAMP(), NULL),
(4, 'chungvanh@specialmail.com', 'chungvanh123', 'H', 'Chung Văn', '1993-07-16', 1, 'Đồng', 3, CURRENT_TIMESTAMP(), NULL),
(5, 'luongmyi@somemail.com', 'luongmyi456', 'I', 'Lương Mỹ', '1999-02-18', 0, 'Bạch Kim',3, CURRENT_TIMESTAMP(), NULL);