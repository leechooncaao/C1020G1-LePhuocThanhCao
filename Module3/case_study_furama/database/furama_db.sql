DROP DATABASE IF EXISTS furama_management;
CREATE DATABASE furama_management;
USE furama_management;

-- Creating tables
CREATE TABLE `position`(
	position_id INT AUTO_INCREMENT,
    position_name VARCHAR(45),
    
    PRIMARY KEY(position_id)
);

CREATE TABLE education_degree(
	education_degree_id INT AUTO_INCREMENT,
    education_degree_name VARCHAR(45),
    
    PRIMARY KEY(education_degree_id)
);

CREATE TABLE division(
	division_id INT AUTO_INCREMENT,
    division_name VARCHAR(45),
    
    PRIMARY KEY(division_id)
);

CREATE TABLE `user`(
	username VARCHAR(255),
    `password` VARCHAR(255),
    
    PRIMARY KEY(username)
);

CREATE TABLE `role`(
	role_id INT AUTO_INCREMENT,
    role_name VARCHAR(255),
    
    PRIMARY KEY(role_id)
);

CREATE TABLE user_role(
	role_id INT,
    username VARCHAR(255),
    
    PRIMARY KEY(role_id,username),
    FOREIGN KEY(role_id) REFERENCES `role`(role_id),
    FOREIGN KEY(username) REFERENCES `user`(username)
);

CREATE TABLE employee(
	employee_id INT AUTO_INCREMENT,
    employee_name VARCHAR(45) NOT NULL,
    employee_birthday DATE NOT NULL,
    employee_id_card VARCHAR(45) NOT NULL,
    employee_salary DOUBLE NOT NULL,
    employee_phone VARCHAR(45) NOT NULL,
    employee_email VARCHAR(45),
    employee_address VARCHAR(45),
    position_id INT,
    education_degree_id INT,
    division_id INT,
    username VARCHAR(255),
    
    PRIMARY KEY(employee_id),
    FOREIGN KEY(position_id) REFERENCES `position`(position_id),
    FOREIGN KEY(education_degree_id) REFERENCES education_degree(education_degree_id),
    FOREIGN KEY(division_id) REFERENCES division(division_id),
    FOREIGN KEY(username) REFERENCES `user`(username)
);

CREATE TABLE customer_type(
	customer_type_id INT AUTO_INCREMENT,
    customer_type_name VARCHAR(45),
    
    PRIMARY KEY(customer_type_id)
);

CREATE TABLE customer(
	customer_id INT AUTO_INCREMENT,
    customer_type_id INT,
    customer_name VARCHAR(45) NOT NULL,
    customer_birthday DATE NOT NULL,
    customer_gender BIT(1) NOT NULL,
    customer_id_card VARCHAR(45) NOT NULL,
    customer_phone VARCHAR(45) NOT NULL,
    customer_email VARCHAR(45),
    customer_address VARCHAR(45),
    
    PRIMARY KEY(customer_id),
    FOREIGN KEY(customer_type_id) REFERENCES customer_type(customer_type_id)
);

CREATE TABLE service_type(
	service_type_id INT AUTO_INCREMENT,
    service_type_name VARCHAR(45),
    
    PRIMARY KEY(service_type_id)
);

CREATE TABLE rent_type(
	rent_type_id INT AUTO_INCREMENT,
    rent_type_name VARCHAR(45),
    rent_type_cost DOUBLE,
    
    PRIMARY KEY(rent_type_id)
);

CREATE TABLE service(
	service_id INT AUTO_INCREMENT,
    service_name VARCHAR(45) NOT NULL,
    service_area INT,
    service_cost DOUBLE NOT NULL,
    service_max_people INT,
    rent_type_id INT,
    service_type_id INT,
    standard_room VARCHAR(45),
    description_other_convenience VARCHAR(45),
    pool_area DOUBLE,
    number_of_floors INT,
    
    PRIMARY KEY(service_id),
    FOREIGN KEY(rent_type_id) REFERENCES rent_type(rent_type_id),
    FOREIGN KEY(service_type_id) REFERENCES service_type(service_type_id)
);

CREATE TABLE contract(
	contract_id INT AUTO_INCREMENT,
    contract_start_date DATE NOT NULL,
    contract_end_date DATE NOT NULL,
    contract_deposit DOUBLE NOT NULL,
    contract_total_money DOUBLE NOT NULL,
    employee_id INT,
    customer_id INT,
    service_id INT,
    
    PRIMARY KEY(contract_id),
    FOREIGN KEY(employee_id) REFERENCES employee(employee_id),
    FOREIGN KEY(customer_id) REFERENCES customer(customer_id),
    FOREIGN KEY(service_id) REFERENCES service(service_id)
);

CREATE TABLE attach_service(
	attach_service_id INT AUTO_INCREMENT,
    attach_service_name VARCHAR(45) NOT NULL,
    attach_service_cost DOUBLE NOT NULL,
    attach_service_unit INT NOT NULL,
    attach_service_status VARCHAR(45),
    
    PRIMARY KEY (attach_service_id)
);

CREATE TABLE contract_detail(
	contract_detail_id INT AUTO_INCREMENT,
    contract_id INT,
    attach_service_id INT,
    quantity INT NOT NULL,
    
    PRIMARY KEY(contract_detail_id),
    FOREIGN KEY(contract_id) REFERENCES contract(contract_id),
    FOREIGN KEY(attach_service_id) REFERENCES attach_service(attach_service_id)
);


-- Inserting data
INSERT INTO `position` (position_name)
VALUES 
		('receptionist'),
		('waiter'),
		('specialist'),
		('supervisor'),
		('manager'),
		('director');
        
INSERT INTO education_degree (education_degree_name)  
VALUES 
		('intermediate'),
		('college'),
		('university'),
		('postgraduate');
        
INSERT INTO division(division_name)        
VALUES 
		('sale-marketing'),
		('administration'),
		('service'),
		('management');
        
INSERT INTO `user`
VALUES 
		('thanh cao','12345'),
		('hong thanh','12345'),
		('hong son','12345'),
		('anh dung','12345'),
		('huu kien','12345'),
		('bao thinh','12345');
        
INSERT INTO `role`(role_name)        
VALUES ('admin'), ('user'), ('member');

INSERT INTO user_role
VALUES 
	(1,'thanh cao'),
	(2,'hong thanh'),
	(2,'hong son'),
	(2,'anh dung'),
	(3,'huu kien'),
	(3,'bao thinh');
        
INSERT INTO employee (
					employee_name,
                    employee_birthday,
                    employee_id_card,
                    employee_salary,
                    employee_phone,
                    employee_email,
                    employee_address,
                    position_id,
                    education_degree_id,
                    division_id,
                    username)        
VALUES 
		('Le Phuoc Thanh Cao','1996-12-13','2132323',1000,'01233112','lephuocthanhcao@gmail.com','Hue',6,4,2,'thanh cao'),
		('Dang Thi Hong Thannh','1994-07-05','2133222',800,'02313211','dangthihongthanh@gmail.com','Quang Nam',2,1,4,'hong thanh'),
		('Pham Hong Son','1997-11-22','4531223',400,'032122323','phamhongson@gmail.com','Tay Ninh',1,3,3,'hong son'),
		('Ho Anh Dung','1996-08-28','7989789',400,'031213232','hoanhdung@gmail.com','Nghe An',2,1,1,'anh dung'),
		('Tran Huu Kien','1991-12-23','13232331',900,'033211312','tranhuukien@gmail.com','Nghe An',5,4,3,'huu kien'),
		('Tran Huynh Bao Thinh','2000-10-03','11333121',200,'01233112','tranhuynhbaothinh@gmail.com','Hoi An',2,3,4,'bao thinh');

INSERT INTO customer_type(customer_type_name)
VALUES ('Diamond'), ('Platinium'), ('Gold'), ('Silver'), ('Member');

INSERT INTO customer(
					customer_type_id,
					customer_name,
					customer_birthday,
					customer_gender,
					customer_id_card,
					customer_phone,
					customer_email,
					customer_address)
VALUES 
		(1,'Le Hoang Minh Tuan', '1994-02-05', 1,'32131311', '032132131', 'lehoangminhtuan@gmail.com', 'Da Nang'),
		(2,'Nguyen Thanh Tung', '1993-05-21', 1,'7987978', '051331232', 'nguyenthanhtung@gmail.com', 'Da Nang'),
		(3,'Nguyen Long Phin', '1999-01-18', 1,'98799797', '0121323321', 'nguyenlongphin@gmail.com', 'Quang Nam'),
		(3,'Nguyen Ngoc Thinh', '1995-11-24', 1,'98798988', '03213112312', 'nguyenngocthinh@gmail.com', 'Quang Ngai'),
		(4,'Nguyen Viet Dung', '1994-09-11', 1,'87879797', '032132131', 'nguyenvietdung@gmail.com', 'Da Nang');
        
INSERT INTO service_type(service_type_name)        
VALUES ('Villa'), ('House'), ('Room');

INSERT INTO rent_type(rent_type_name, rent_type_cost)
VALUES 
		('BY HOUR', 100),
		('BY DAY', 300),
		('BY MONTH', 400),
		('BY YEAR', 450);
        
INSERT INTO service(
					service_name,
					service_area,
					service_cost,
					service_max_people,
					rent_type_id,
					service_type_id,
					standard_room,
					description_other_convenience,
					pool_area,
					number_of_floors)        
VALUES 
		('Villa la Cassinella',200,1000,4,4,1,'Vip','excellent',30,3),
		('Villa Poletti',300,2000,4,3,1,'Presidental','romantic',35,3),
		('Orchard House',75,800,5,2,2,'Luxurious','peaceful',20,1),
		('Corner House',100,1000,5,3,2,'Standard','natural',20,2),
		('Ideation Zone',40,200,2,1,3,'Collaborative','nothing',0,1),
		('Gathering Field',45,250,2,2,3,'Social ','nothing',0,1);
        
INSERT INTO contract(
					contract_start_date,
					contract_end_date,
					contract_deposit,
					contract_total_money,
					employee_id,
					customer_id,
					service_id) 
VALUES 
		('2020-01-01', '2020-01-15', 500, 1500, 1, 2, 1),
		('2020-03-10', '2020-04-10', 700, 2300, 4, 3, 3),
		('2020-11-02', '2020-12-15', 1000, 3500, 2, 1, 5),
		('2019-05-20', '2019-07-20', 800, 2300, 3, 5, 2),
		('2018-09-01', '2019-09-29', 750, 1800, 6, 4, 6),
		('2020-10-20', '2020-10-23', 200, 900, 5, 2, 5);
        
INSERT INTO attach_service(
							attach_service_name,
							attach_service_cost,
							attach_service_unit,
							attach_service_status)     
VALUES 
		('Massage',10,5,'available'),
		('Car rental',12,2,'available'),
		('Food',10,3,'available'),
		('Beverage',8,3,'available'),
		('Karaoke',5,4,'available');
        
INSERT INTO contract_detail(
							contract_id,
							attach_service_id,
							quantity) 
VALUES 
		(1,1,3),
		(1,2,5),
		(1,3,4),
		(2,3,1),
		(2,5,3),
		(3,4,8),
		(3,2,4),
		(4,1,2),
		(4,5,3),
		(5,4,5),
		(5,3,7),
		(6,2,3),
		(6,1,4);

















