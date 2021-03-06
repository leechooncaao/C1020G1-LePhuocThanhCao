-- task 2 : Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.
SELECT *
FROM employees
WHERE full_name REGEXP '^[HTK]{1,15}';

-- task 3 : Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
SELECT 
	full_name,
    birthday,
    CURDATE() AS `current_date`,
    TIMESTAMPDIFF(YEAR, birthday, CURDATE()) AS age,
    address
FROM customers
WHERE (TIMESTAMPDIFF(YEAR, birthday, CURDATE())  BETWEEN 25 AND 50 ) AND
		(address IN ('Đà Nẵng', 'Quảng Trị'));
        
-- task 4 :Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.        
SELECT 
	con.customer_id,
    cus.full_name,
    ct.type_name AS type_customer,
    COUNT(*) AS quantity_booking
FROM customers cus
JOIN customer_types ct USING (type_customer_id)
JOIN contracts con USING (customer_id)
WHERE ct.type_name = 'Diamond'
GROUP BY con.customer_id;

-- task 5 :Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, 
-- NgayKetThuc, TongTien (Với TongTien được tính theo công thức như sau: 
-- GiaDichVu + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) 
-- cho tất cả các Khách hàng đã từng đặt phỏng. 
-- (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).

DROP TEMPORARY TABLE IF EXISTS accompanied_total_payment;
CREATE TEMPORARY TABLE accompanied_total_payment
SELECT 
	dc.contract_id,
    SUM(acs.price*dc.quantity) AS total_price
FROM detailed_contracts dc
JOIN accompanied_services acs USING (accompanied_service_id)
GROUP BY dc.contract_id;

SELECT 
	con.contract_id,
	cus.customer_id,
    cus.full_name,
    ct.type_name AS type_customer,
    serv.service_name,
    con.start_day,
    con.end_day,
    TIMESTAMPDIFF(DAY, con.start_day, con.end_day) * st.service_price + atp.total_price AS total_payment
FROM customers cus
JOIN customer_types ct USING (type_customer_id)
LEFT JOIN contracts con USING (customer_id)
LEFT JOIN services serv ON serv.service_id = con.service_id
LEFT JOIN service_types st ON st.service_type_id = serv.service_type_id
LEFT JOIN accompanied_total_payment atp ON atp.contract_id = con.contract_id;

-- task 6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ 
-- chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2020 (Quý 1 là tháng 1, 2, 3).

SELECT 
	serv.service_id,
    serv.service_name,
    serv.area,
    st.service_price,
    st.name AS type,
    con.start_day
FROM services serv
JOIN service_types st USING (service_type_id)
JOIN contracts con USING (service_id)
WHERE  YEAR(con.start_day) = 2020 AND (con.start_day NOT BETWEEN '2020-01-01' AND '2020-01-03');

-- task 7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, 
-- TenLoaiDichVu của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2020 
-- nhưng chưa từng được Khách hàng đặt phòng  trong năm 2021

-- 1st way
DROP TEMPORARY TABLE IF EXISTS in_2020;
CREATE TEMPORARY TABLE in_2020
SELECT 
	service_id,
    start_day
FROM contracts
WHERE YEAR(start_day) IN (2020)
GROUP BY service_id;

DROP TEMPORARY TABLE IF EXISTS in_2021;
CREATE TEMPORARY TABLE in_2021
SELECT 
	service_id,
    start_day
FROM contracts
WHERE YEAR(start_day) IN (2021)
GROUP BY service_id;

SELECT 
	in_2020.service_id,
    serv.service_name,
    serv.area,
    serv.max_tenant,
    st.service_price,
    st.name AS service_type
FROM in_2020
JOIN services serv USING (service_id)
JOIN service_types st ON st.service_type_id = serv.service_type_id
WHERE NOT EXISTS (SELECT * FROM in_2021 WHERE in_2020.service_id = in_2021.service_id );


-- task 8.	Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoTenKhachHang không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên

-- 1st way : 
SELECT DISTINCT full_name
FROM customers;

-- 2nd way :
SELECT 
	full_name
FROM customers
GROUP BY full_name;

-- 3rd way:

SELECT 
    full_name
FROM
    customers 
UNION SELECT 
    full_name
FROM
    customers;


-- task 9.	Thực hiện thống kê doanh thu theo tháng, 
-- nghĩa là tương ứng với mỗi tháng trong năm 2020 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng

-- create a table for 12 months
CREATE TEMPORARY TABLE temp_month(month INT NOT NULL);

INSERT INTO temp_month VALUES (1),(2),(3),(4),(5),(6),(8),(9),(10),(11),(12);

select *
from temp_month;

-- calculate total payment of every contract
DROP TEMPORARY TABLE IF EXISTS accompanied_total_payment;
CREATE TEMPORARY TABLE accompanied_total_payment
SELECT 
	dc.contract_id,
    SUM(acs.price*dc.quantity) AS total_price
FROM detailed_contracts dc
JOIN accompanied_services acs USING (accompanied_service_id)
GROUP BY dc.contract_id;

DROP TEMPORARY TABLE IF EXISTS total;
CREATE TEMPORARY TABLE total
SELECT 
	con.contract_id,
	cus.customer_id,
    cus.full_name,
    ct.type_name AS type_customer,
    serv.service_name,
    con.start_day,
    con.end_day,
    TIMESTAMPDIFF(DAY, con.start_day, con.end_day) * st.service_price + atp.total_price AS total_payment
FROM customers cus
JOIN customer_types ct USING (type_customer_id)
LEFT JOIN contracts con USING (customer_id)
LEFT JOIN services serv ON serv.service_id = con.service_id
LEFT JOIN service_types st ON st.service_type_id = serv.service_type_id
LEFT JOIN accompanied_total_payment atp ON atp.contract_id = con.contract_id;     

select *
from total;              

-- get final result
SELECT 
	tm.`month`,
    COUNT(MONTH(t.start_day)) AS number_registered,
    SUM(t.total_payment) AS total
FROM temp_month tm
	LEFT JOIN total t ON tm.`month` = MONTH(t.start_day)
WHERE YEAR(t.start_day) = 2020 OR YEAR(t.start_day) IS NULL OR MONTH(t.start_day) IS NULL
GROUP BY tm.`month`;

-- task 10 : Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. 
-- Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem 
-- (được tính dựa trên việc count các IDHopDongChiTiet).

SELECT 
	con.contract_id,
    con.start_day,
    con.end_day,
    con.deposit,
    COUNT(dcon.detailed_contract_id) AS number_accompanied_service
FROM contracts con
	JOIN detailed_contracts dcon USING (contract_id)
GROUP BY con.contract_id;

-- task 11 : Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có 
-- TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.

SELECT 
	customer_id,
    c.address,
    ct.type_name AS type_customer,
    aserv.name_service,
    aserv.price,
    aserv.`status`
FROM customers c
	JOIN customer_types ct USING (type_customer_id)
    JOIN contracts con USING (customer_id)
    JOIN detailed_contracts dcon ON dcon.contract_id = con.contract_id
    JOIN accompanied_services aserv ON dcon.accompanied_service_id = aserv.accompanied_service_id
WHERE c.address IN ('Vinh', 'Quảng Ngãi') AND ct.type_name = 'Diamond';

-- task 12 :Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, 
-- TenDichVu, SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc 
-- của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 nhưng 
-- chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.

SELECT 
	con.contract_id,
    emp.full_name AS employee_name,
    cus.full_name AS customer_name,
    cus.phone_number AS customer_phone,
    serv.service_name,
    con.deposit,
    SUM(dcon.quantity) AS number_accompanied_service
FROM services serv
JOIN contracts con USING (service_id)
JOIN customers cus ON cus.customer_id = con.customer_id
JOIN employees emp ON emp.employee_id = con.employee_id
JOIN detailed_contracts dcon ON dcon.contract_id = con.contract_id
JOIN accompanied_services aserv ON aserv.accompanied_service_id = dcon.accompanied_service_id
WHERE EXISTS (
			SELECT con.service_id 
			FROM contracts con
			WHERE YEAR(con.start_day) = 2020 AND 
				  MONTH(con.start_day) IN (10,11,12) AND 
				  con.service_id = serv.service_id
	)
	AND NOT EXISTS (
				SELECT con.service_id
				FROM contracts con
				WHERE YEAR(con.start_day) = 2021 AND 
					  MONTH(con.start_day) NOT IN (10,11,12) AND 
					  con.service_id = serv.service_id
    )
GROUP BY dcon.contract_id;

-- task 13 : Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng 
-- đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).

DROP TEMPORARY TABLE IF EXISTS accom_service_used;
CREATE TEMPORARY TABLE accom_service_used
SELECT 
	aserv.name_service AS accompanied_service,
    COUNT(dcon.accompanied_service_id) AS number_using
FROM accompanied_services aserv
JOIN detailed_contracts dcon USING (accompanied_service_id)
GROUP BY aserv.accompanied_service_id;

SELECT *
FROM accom_service_used;

DROP TEMPORARY TABLE IF EXISTS accom_service_max_using;
CREATE TEMPORARY TABLE accom_service_max_using
SELECT 
	MAX(asu.number_using) AS max_using
FROM accom_service_used asu ;

SELECT 
	asu.accompanied_service,
    asmu.max_using
FROM accom_service_used asu 
JOIN accom_service_max_using asmu ON asmu.max_using = asu.number_using;

-- task 14 : Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất.
--  Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.

DROP TEMPORARY TABLE IF EXISTS accom_service_used;
CREATE TEMPORARY TABLE accom_service_used
SELECT 
	aserv.accompanied_service_id,
	aserv.name_service AS accompanied_service_name,
    COUNT(dcon.accompanied_service_id) AS number_using
FROM accompanied_services aserv
JOIN detailed_contracts dcon USING (accompanied_service_id)
GROUP BY aserv.accompanied_service_id;

SELECT *
FROM accom_service_used
WHERE number_using = 1;

-- task 15 : Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, 
-- TenBoPhan, SoDienThoai, DiaChi mới chỉ lập được tối đa 2 hợp đồng từ năm 2020 đến 2021.

CREATE TEMPORARY TABLE employee_contract
SELECT 
	employee_id,
	COUNT(employee_id) AS number_contracts
FROM contracts con
WHERE YEAR(start_day) BETWEEN 2020 AND 2021
GROUP BY employee_id
HAVING COUNT(employee_id) >= 2;

SELECT 
	ec.employee_id,
    e.full_name,
    pos.position_name,
    dep.department_name,
    e.phone_number,
    e.address,
    ec.number_contracts
FROM employees e
JOIN positions pos USING (position_id)
JOIN departments dep USING (department_id)
JOIN employee_contract ec USING (employee_id);

-- task 16 : Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2020 đến năm 2021.

DELETE FROM employees e
WHERE e.employee_id NOT IN (
							SELECT 
								employee_id 
							FROM contracts con
							WHERE YEAR(start_day) BETWEEN 2020 AND 2021
							GROUP BY employee_id
							HAVING COUNT(employee_id) > 0
					);

-- task 17 : Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2020 
-- là lớn hơn 10.000 USD.

-- calculate total payment of every contract
DROP TEMPORARY TABLE IF EXISTS accompanied_total_payment;
CREATE TEMPORARY TABLE accompanied_total_payment
SELECT 
	dc.contract_id,
    SUM(acs.price*dc.quantity) AS total_price
FROM detailed_contracts dc
JOIN accompanied_services acs USING (accompanied_service_id)
GROUP BY dc.contract_id;

DROP TEMPORARY TABLE IF EXISTS total;
CREATE TEMPORARY TABLE total
SELECT 
	con.contract_id,
	cus.customer_id,
    cus.full_name,
    ct.type_name AS type_customer,
    serv.service_name,
    con.start_day,
    con.end_day,
    TIMESTAMPDIFF(DAY, con.start_day, con.end_day) * st.service_price + atp.total_price AS total_payment
FROM customers cus
JOIN customer_types ct USING (type_customer_id)
LEFT JOIN contracts con USING (customer_id)
LEFT JOIN services serv ON serv.service_id = con.service_id
LEFT JOIN service_types st ON st.service_type_id = serv.service_type_id
LEFT JOIN accompanied_total_payment atp ON atp.contract_id = con.contract_id;     

SELECT *
FROM total;

-- update
CREATE TEMPORARY TABLE diamond_type
SELECT
	type_customer_id
FROM customer_types
WHERE type_name = 'Diamond';

CREATE TEMPORARY TABLE platinium_type
SELECT
	type_customer_id
FROM customer_types
WHERE type_name = 'Platiumn';

UPDATE customers cus
JOIN diamond_type dt USING (type_customer_id)
JOIN platinium_type pt USING (type_customer_id)
SET cus.type_customer_id = dt.type_customer_id
WHERE cus.customer_id IN (
						SELECT customer_id
                        FROM total
                        WHERE total_payment >= 10000
					)
	AND cus.type_customer_id = pt.type_customer_id;
    
-- task 18 : Xóa những khách hàng chỉ có hợp đồng trước năm 2016 (chú ý ràng buộc giữa các bảng).

DROP TEMPORARY TABLE IF EXISTS deleting_customer;
CREATE TEMPORARY TABLE deleting_customer
SELECT customer_id
FROM contracts con1
WHERE EXISTS (
			SELECT con2.customer_id
            FROM contracts con2
            WHERE con2.start_day < '2016-01-01' AND con1.customer_id = con2.customer_id
		)
	AND NOT EXISTS (
				SELECT con2.customer_id
				FROM contracts con2
				WHERE con2.start_day >= '2016-01-01' AND con1.customer_id = con2.customer_id
    );

DELETE FROM contracts
WHERE customer_id IN (
					SELECT *
					FROM deleting_customer
					);

DELETE FROM customers cus
WHERE cus.customer_id IN (
						SELECT *
						FROM deleting_customer
					);
                    
-- task 19 : Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần 
-- trong năm 2020 lên gấp đôi.                    

UPDATE accompanied_services 
SET price = price * 2
WHERE accompanied_service_id IN (
								SELECT 
									dcon.accompanied_service_id
								FROM contracts con
								JOIN detailed_contracts dcon USING (contract_id)
								WHERE YEAR(con.start_day) = 2020
								GROUP BY dcon.accompanied_service_id
								HAVING SUM(quantity) > 10
							);
                            
-- task 20 : Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, 
-- thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, 
-- SoDienThoai, NgaySinh, DiaChi.                            

SELECT 
	employee_id AS id,
    full_name,
    email,
    phone_number,
    birthday,
    address,
    'employee' AS position
FROM employees 
UNION
SELECT 
	customer_id AS id,
    full_name,
    email,
    phone_number,
    birthday,
    address,
    'customer' AS position
FROM customers;

-- task 21 :Tạo khung nhìn có tên là V_NHANVIEN để lấy được thông tin của tất cả các nhân viên 
-- có địa chỉ là “Đà Nẵng” và đã từng lập hợp đồng cho 1 hoặc nhiều Khách hàng bất kỳ  
-- với ngày lập hợp đồng là “12/12/2020”

CREATE VIEW view_employee AS
SELECT *
FROM employees emp
WHERE emp.address = 'Đà Nẵng' AND EXISTS (
									SELECT con.employee_id
                                    FROM contracts con
                                    WHERE  con.start_day = '2020-12-12' AND
                                          con.employee_id = emp.employee_id
									GROUP BY con.employee_id
                                    HAVING COUNT(con.employee_id) > 0
							);
                            
-- task 22 :Thông qua khung nhìn V_NHANVIEN thực hiện cập nhật địa chỉ thành “Liên Chiểu” 
-- đối với tất cả các Nhân viên được nhìn thấy bởi khung nhìn này.  

UPDATE view_employee   
SET address = 'Liên Chiểu';

-- task 23 : Tạo Store procedure Sp_1 Dùng để xóa thông tin của một Khách hàng nào đó với 
-- Id Khách hàng được truyền vào như là 1 tham số của Sp_1

DELIMITER //
CREATE PROCEDURE delete_customer_by_id(id INT)
BEGIN
	DECLARE count INT DEFAULT 0;
    SET count = (SELECT COUNT(id) FROM customers WHERE customer_id = id);
    IF count > 0 THEN 
		DELETE FROM customers
        WHERE customer_id = id;
	ELSE 
		SELECT  CONCAT('YOUR PARAMETER ', id, ' IS NOT EXISTS!!!') AS 'ERROR';
    END IF;
END;
// DELIMITER ;

CALL delete_customer_by_id(10);		

-- task 24 : Tạo Store procedure Sp_2 Dùng để thêm mới vào bảng HopDong với yêu cầu Sp_2 
-- phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, với nguyên tắc không được trùng 
-- khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.		

DELIMITER //
CREATE PROCEDURE add_new_contract(
	emp_id INT, cus_id INT, serv_id INT, start_day DATE, end_day DATE, depos DECIMAL(9,2))
BEGIN
		IF NOT EXISTS (SELECT * FROM employees WHERE employee_id = emp_id) THEN
			SELECT 'employee_id does not exist' AS 'ERROR' ;
		ELSEIF NOT EXISTS (SELECT * FROM customers WHERE customer_id = cus_id) THEN
			SELECT 'customer_id does not exist' AS 'ERROR';
		ELSEIF NOT EXISTS (SELECT * FROM services  WHERE service_id  = serv_id) THEN
			SELECT 'service_id does not exist'  AS 'ERROR';
        ELSE         
			INSERT INTO contracts (employee_id, customer_id, service_id, start_day, end_day, deposit)
				VALUES (emp_id, cus_id, serv_id, start_day, end_day, depos);
		END IF;
END ;
// DELIMITER ;

CALL add_new_contract(2,4,5,'2019-02-03','2019-02-25',500);

-- task 25 : Tạo triggers có tên Tr_1 Xóa bản ghi trong bảng HopDong thì hiển thị 
-- tổng số lượng bản ghi còn lại có trong bảng HopDong ra giao diện console của database

DELIMITER //
CREATE TRIGGER show_contract 
	AFTER DELETE ON contracts 
    FOR EACH ROW 
		BEGIN
			SET @number_records = (SELECT COUNT(*) FROM contracts);
        END;
// DELIMITER ;	
SET @number_records = 0;

DELETE FROM contracts
WHERE contract_id = 9;

SELECT @number_records;		

-- task 26 :Tạo triggers có tên Tr_2 Khi cập nhật Ngày kết thúc hợp đồng, cần kiểm tra xem 
-- thời gian cập nhật có phù hợp hay không, với quy tắc sau: Ngày kết thúc hợp đồng phải 
-- lớn hơn ngày làm hợp đồng ít nhất là 2 ngày. Nếu dữ liệu hợp lệ thì cho phép cập nhật, 
-- nếu dữ liệu không hợp lệ thì in ra thông báo “Ngày kết thúc hợp đồng phải lớn hơn 
-- ngày làm hợp đồng ít nhất là 2 ngày” trên console của database


DROP TRIGGER IF EXISTS time_validator;
DELIMITER //
CREATE TRIGGER time_validator 
	BEFORE UPDATE ON contracts
	FOR EACH ROW
		BEGIN
			IF DATEDIFF(NEW.end_day, OLD.start_day) < 2 THEN
                SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'The end day must be greater than start day 2 days';
            END IF;    
        END;
// DELIMITER ;

UPDATE contracts
SET end_day = '2019-02-03'
WHERE contract_id = 10;

-- task 27 : Tạo user function thực hiện yêu cầu sau:
-- a.	Tạo user function func_1: Đếm các dịch vụ đã được sử dụng với Tổng tiền là > 1000 USD.

CREATE TEMPORARY TABLE service_with_totalpayment
SELECT 
	con.service_id,
    SUM(st.service_price) AS total_payment
FROM contracts con
JOIN services serv USING (service_id)
JOIN service_types st ON st.service_type_id = serv.service_type_id
GROUP BY con.service_id;

DELIMITER //
CREATE FUNCTION count_service()
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE counter INT DEFAULT 0;
    
    SELECT 
		COUNT(service_id)
        INTO counter
	FROM service_with_totalpayment
    WHERE total_payment > 1000;
    
    RETURN counter;
END;
// DELIMITER ;

SELECT count_service();

-- b.	Tạo user function Func_2: Tính khoảng thời gian dài nhất tính từ lúc bắt đầu làm hợp đồng
--      đến lúc kết thúc hợp đồng mà Khách hàng đã thực hiện thuê dịch vụ (lưu ý chỉ xét các 
--      khoảng thời gian dựa vào từng lần làm hợp đồng thuê dịch vụ, không xét trên toàn bộ các lần làm hợp đồng). 
--      Mã của Khách hàng được truyền vào như là 1 tham số của function này.

DELIMITER //
CREATE FUNCTION get_longest_time(cus_id INT)
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE longest_time INT DEFAULT 0;
    
    IF NOT EXISTS (SELECT * FROM contracts WHERE customer_id = cus_id) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'customer_id does not existed !';
	END IF;
    
    SELECT 
        MAX(DATEDIFF(end_day, start_day))
        INTO longest_time
    FROM contracts con
    WHERE customer_id = cus_id;
    
    RETURN longest_time;
END;
// DELIMITER ;

SELECT get_longest_time(2);

-- task 28 : Tạo Store procedure Sp_3 để tìm các dịch vụ được thuê bởi khách hàng với loại dịch vụ
--  là “Room” từ đầu năm 2015 đến hết năm 2021 để xóa thông tin của các dịch vụ đó 
-- (tức là xóa các bảng ghi trong bảng DichVu) và xóa những HopDong sử dụng dịch vụ liên quan 
-- (tức là phải xóa những bản gi trong bảng HopDong) và những bản liên quan khác.

DELIMITER //
CREATE FUNCTION delete_room_service()
RETURNS VARCHAR(30)
DETERMINISTIC
BEGIN
	DROP TEMPORARY TABLE IF EXISTS room_in_2020;
	CREATE TEMPORARY TABLE room_in_2020
	SELECT 
		serv.service_id,
        dcon.contract_id
	FROM services serv
	JOIN service_types st USING (service_type_id)
	JOIN contracts con USING (service_id)
    JOIN detailed_contracts dcon ON con.contract_id = dcon.contract_id
	WHERE st.name = 'room' AND (con.start_day BETWEEN '2015-01-01' AND '2021-12-31');
    
    DELETE FROM detailed_contracts
    WHERE contract_id IN (
						SELECT contract_id
                        FROM room_in_2020
					);
    
	DELETE FROM contracts
    WHERE service_id IN (
						SELECT service_id
                        FROM room_in_2020
					);
                    
	DELETE FROM services
    WHERE service_id IN (
						SELECT service_id
                        FROM room_in_2020
					);
                    
	RETURN 'completed deletion';
END;
// DELIMITER ;

SELECT delete_room_service();












    
    

































