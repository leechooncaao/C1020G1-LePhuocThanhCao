
-- Viết câu lệnh hiện thị tất cả các dòng có tên là Huong
SELECT *
FROM students
WHERE TEN = 'Huong';

-- Viết câu lệnh lấy ra tổng số tiền của Huong
SELECT SUM(SOTIEN)
FROM students
WHERE TEN = 'Huong';

-- Viết câu lệnh lấy ra tên danh sách của tất cả học viên, không trùng lặp
SELECT DISTINCT *
FROM students;