-- task 2 : Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.
SELECT *
FROM employees
WHERE full_name REGEXP '^[HTK]{1,15}';

-- task 3 : Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
SELECT 
	full_name,
    birthday,
    CURDATE() AS current_date,
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
WHERE MONTH(con.start_day) NOT IN (1,2,3);

-- task 7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, 
-- TenLoaiDichVu của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2020 
-- nhưng chưa từng được Khách hàng đặt phòng  trong năm 2021

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

-- SELECT 
-- 	full_name
-- FROM customers
-- GROUP BY full_name
-- HAVING COUNT(full_name)  = 1

-- task 9.	Thực hiện thống kê doanh thu theo tháng, 
-- nghĩa là tương ứng với mỗi tháng trong năm 2020 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng
























