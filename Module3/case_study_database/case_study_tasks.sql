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

-- task 5 :Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).













