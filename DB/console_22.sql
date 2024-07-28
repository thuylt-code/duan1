CREATE DATABASE PRO1041
USE PRO1041
drop database PRO1041
CREATE TABLE San_pham(
                         ID INT IDENTITY PRIMARY KEY,
                         ma_san_pham VARCHAR(10),
                         ten_san_pham NVARCHAR(200),
                         ngay_tao DATE,
                         trang_thai INT
);

CREATE TABLE San_pham_chi_tiet(
                                  ID INT IDENTITY PRIMARY KEY,
                                  id_kich_thuoc INT,
                                  id_mau_sac INT,
                                  id_chat_lieu INT,
                                  id_da INT,
                                  id_san_pham INT,
                                  id_xuat_xu INT,
                                  ma_san_pham_chi_tiet VARCHAR(10),
                                  ten_san_pham_chi_tiet NVARCHAR(200),
                                  so_luong INT,
                                  don_gia MONEY,
                                  trang_thai INT
);

CREATE TABLE Kich_thuoc(
                           ID INT IDENTITY PRIMARY KEY,
                           ma_kich_thuoc VARCHAR(10),
                           kich_thuoc FLOAT,
                           trang_thai INT
);

CREATE TABLE Mau_sac(
                        ID INT IDENTITY PRIMARY KEY,
                        ma_mau VARCHAR(10),
                        ten_mau NVARCHAR(200),
                        trang_thai INT
);

CREATE TABLE Chat_lieu(
                          ID INT IDENTITY PRIMARY KEY,
                          ma_chat_lieu VARCHAR(10),
                          ten_chat_lieu NVARCHAR(200),
                          trang_thai INT
);

CREATE TABLE Da(
                   ID INT IDENTITY PRIMARY KEY,
                   ma_da VARCHAR(10),
                   ten_da NVARCHAR(200),
                   trang_thai INT
);

CREATE TABLE Xuat_xu(
                        ID INT IDENTITY PRIMARY KEY,
                        ten_nuoc NVARCHAR(100),
                        trang_thai INT
);

CREATE TABLE Hoa_don(
                        ID INT IDENTITY PRIMARY KEY,
                        ma_hoa_don VARCHAR(10),
                        id_khach_hang INT,
                        id_nhan_vien INT,
                        ten_khach_hang NVARCHAR(50),
                        dia_chi_khach_hang NVARCHAR(255),
                        so_dt NVARCHAR(13),
                        ngay_tao DATE,
                        tong_tien MONEY,
                        hinh_thuc_thanh_toan NVARCHAR(50),
                        id_voucher INT,
                        trang_thai INT
);

CREATE TABLE Hoa_don_chi_tiet(
                                 ID INT IDENTITY PRIMARY KEY,
                                 ma_hoa_don_chi_tiet VARCHAR(10),
                                 id_hoa_don INT,
                                 id_san_pham_chi_tiet INT,
                                 so_luong INT,
                                 don_gia MONEY,
                                 thanh_tien MONEY,
                                 trang_thai INT
);

CREATE TABLE Voucher(
                        ID INT IDENTITY PRIMARY KEY,
                        ma_voucher VARCHAR(10),
                        ten_voucher NVARCHAR(50),
                        so_luong_voucher INT,
                        gioi_han_giam_toi_thieu MONEY,
                        gioi_han_giam_toi_da MONEY,
                        giam_gia int,
                        ngay_bat_dau DATE,
                        ngay_ket_thuc DATE,
                        hinh_thuc_giam NVARCHAR(50),
                        trang_thai INT
);

CREATE TABLE Khach_hang(
                           ID INT PRIMARY KEY IDENTITY,
                           ma_khach_hang VARCHAR(10),
                           ten_khach_hang NVARCHAR(50),
                           gioi_tinh BIT,
                           so_dt NVARCHAR(13),
                           dia_chi NVARCHAR(255),
                           email VARCHAR(50),
                           trang_thai INT
);

CREATE TABLE Nhan_vien(
                          ID INT PRIMARY KEY IDENTITY,
                          ma_nhan_vien VARCHAR(10),
                          ho_ten NVARCHAR(50),
                          so_dt NVARCHAR(13),
                          email VARCHAR(50),
                          dia_chi NVARCHAR(255),
                          ngay_sinh DATE,
                          gioi_tinh BIT,
                          ngay_bat_dau DATE,
                          mat_khau NVARCHAR(50),
                          id_chuc_vu INT,
                          trang_thai INT
);

CREATE TABLE Chuc_vu(
                        ID INT PRIMARY KEY IDENTITY,
                        ma_chuc_vu VARCHAR(10),
                        ten_chuc_vu NVARCHAR(50)
);


ALTER TABLE San_pham_chi_tiet
    ADD CONSTRAINT FK_San_pham_chi_tiet_San_pham
        FOREIGN KEY (id_san_pham) REFERENCES San_pham(ID) ON DELETE CASCADE;

ALTER TABLE San_pham_chi_tiet
    ADD CONSTRAINT FK_San_pham_chi_tiet_Kich_thuoc
        FOREIGN KEY (id_kich_thuoc) REFERENCES Kich_thuoc(ID) ON DELETE CASCADE;

ALTER TABLE San_pham_chi_tiet
    ADD CONSTRAINT FK_San_pham_chi_tiet_Mau_sac
        FOREIGN KEY (id_mau_sac) REFERENCES Mau_sac(ID) ON DELETE CASCADE;

ALTER TABLE San_pham_chi_tiet
    ADD CONSTRAINT FK_San_pham_chi_tiet_Chat_lieu
        FOREIGN KEY (id_chat_lieu) REFERENCES Chat_lieu(ID) ON DELETE CASCADE;

ALTER TABLE San_pham_chi_tiet
    ADD CONSTRAINT FK_San_pham_chi_tiet_Da
        FOREIGN KEY (id_da) REFERENCES Da(ID) ON DELETE CASCADE;

ALTER TABLE San_pham_chi_tiet
    ADD CONSTRAINT FK_San_pham_chi_tiet_Xuat_xu
        FOREIGN KEY (id_xuat_xu) REFERENCES Xuat_xu(ID) ON DELETE CASCADE;

ALTER TABLE Hoa_don_chi_tiet
    ADD CONSTRAINT FK_Hoa_don_chi_tiet_Hoa_don
        FOREIGN KEY (id_hoa_don) REFERENCES Hoa_don(ID) ON DELETE CASCADE;

ALTER TABLE Hoa_don_chi_tiet
    ADD CONSTRAINT FK_Hoa_don_chi_tiet_San_pham_chi_tiet
        FOREIGN KEY (id_san_pham_chi_tiet) REFERENCES San_pham_chi_tiet(ID) ON DELETE CASCADE;

ALTER TABLE Hoa_don
    ADD CONSTRAINT FK_Hoa_don_Voucher
        FOREIGN KEY (id_voucher) REFERENCES Voucher(ID) ON DELETE CASCADE;
---
ALTER TABLE Hoa_don
    ADD CONSTRAINT FK_HoaDon_Khach_hang
        FOREIGN KEY (id_khach_hang) REFERENCES Khach_hang(ID) ON DELETE CASCADE;

ALTER TABLE Hoa_don
    ADD CONSTRAINT FK_HoaDon_Nhan_vien
        FOREIGN KEY (id_nhan_vien) REFERENCES Nhan_vien(ID) ON DELETE CASCADE;

ALTER TABLE Nhan_vien
    ADD CONSTRAINT FK_Nhan_vien_Chuc_vu
        FOREIGN KEY (id_chuc_vu) REFERENCES Chuc_vu(ID) ON DELETE CASCADE;

INSERT INTO Chuc_vu(ma_chuc_vu, ten_chuc_vu)
VALUES('QL', N'Quản Lý'),
      ('NV', N'Nhân Viên')

INSERT INTO San_pham (ma_san_pham, ten_san_pham, ngay_tao, trang_thai)
VALUES('SP001', N'Vòng cổ', '2024-01-01', 1),
      ('SP002', N'Lắc tay', '2024-01-02', 0),
      ('SP003', N'Nhẫn', '2024-01-03', 1),
      ('SP004', N'Khuyên tai', '2024-01-04', 1),
      ('SP005', N'Vòng chân', '2024-01-05', 1),
      ('SP006', N'Mặt dây chuyền', '2024-01-06', 1),
      ('SP007', N'Bông tai', '2024-01-07', 0),
      ('SP008', N'Nhẫn cưới', '2024-01-08', 1),
      ('SP009', N'Lắc chân', '2024-01-09', 1),
      ('SP010', N'Khuyên mũi', '2024-01-10', 1),
      ('SP011', N'Vòng cổ kim cương', '2024-01-11', 0),
      ('SP012', N'Vòng tay vàng', '2024-01-12', 1),
      ('SP013', N'Nhẫn vàng', '2024-01-13', 1),
      ('SP014', N'Khuyên tai bạc', '2024-01-14', 1),
      ('SP015', N'Lắc chân bạc', '2024-01-15', 1);

INSERT INTO Kich_thuoc (ma_kich_thuoc, kich_thuoc, trang_thai)
VALUES('KT001', 3.0, 0),
      ('KT002', 3.5, 1),
      ('KT003', 4.0, 1),
      ('KT004', 4.5, 1),
      ('KT005', 5.0, 0),
      ('KT006', 5.5, 1),
      ('KT007', 6.0, 1),
      ('KT008', 6.5, 0),
      ('KT009', 7.0, 1),
      ('KT010', 7.5, 1);

INSERT INTO Mau_sac (ma_mau, ten_mau, trang_thai)
VALUES('MS001', N'Đỏ', 1),
      ('MS002', N'Xanh', 0),
      ('MS003', N'Vàng', 1),
      ('MS004', N'Trắng', 1),
      ('MS005', N'Đen', 0),
      ('MS006', N'Hồng', 1),
      ('MS007', N'Tím', 1),
      ('MS008', N'Cam', 0),
      ('MS009', N'Nâu', 1),
      ('MS010', N'Bạc', 1);

INSERT INTO Chat_lieu (ma_chat_lieu, ten_chat_lieu, trang_thai)
VALUES('CL001', N'Vàng', 1),
      ('CL002', N'Bạc', 1),
      ('CL003', N'Bạch kim', 0),
      ('CL004', N'Titan', 1),
      ('CL005', N'Đồng', 1);

INSERT INTO Da (ma_da, ten_da, trang_thai)
VALUES('DA001', N'Đá Thạch Anh', 1),
      ('DA002', N'Đá Ruby', 0),
      ('DA003', N'Đá Sapphire', 0),
      ('DA004', N'Đá Iolite', 1),
      ('DA005', N'Đá Spinel', 1);

INSERT INTO Xuat_xu (ten_nuoc, trang_thai)
VALUES
    (N'Việt Nam', 1),
    (N'Trung Quốc', 0),
    (N'Hàn Quốc', 1),
    (N'Áo', 1),
    (N'Mỹ', 1),
    (N'Anh', 1),
    (N'Pháp', 1),
    (N'Đức', 1),
    (N'Ý', 1);

INSERT INTO San_pham_chi_tiet (id_kich_thuoc, id_mau_sac, id_chat_lieu, id_da, id_san_pham, id_xuat_xu, ma_san_pham_chi_tiet, ten_san_pham_chi_tiet, so_luong, don_gia, trang_thai)
VALUES(1, 1, 1, 1, 1, 1, 'SPCT001', N'Vòng cổ vàng', 10, 2000000, 1),
      (2, 2, 2, 2, 2, 2, 'SPCT002', N'Lắc tay bạc', 15, 1500000, 1),
      (3, 3, 3, 3, 3, 3, 'SPCT003', N'Nhẫn kim cương', 5, 5000000, 0),
      (4, 4, 4, 4, 4, 4, 'SPCT004', N'Khuyên tai bạc', 20, 1000000, 1),
      (5, 5, 5, 5, 5, 5, 'SPCT005', N'Vòng chân đồng', 8, 1800000, 1),
      (6, 6, 4, 1, 6, 6, 'SPCT006', N'Mặt dây chuyền titan', 12, 1200000, 1),
      (7, 7, 3, 2, 7, 7, 'SPCT007', N'Bông tai bạch kim', 6, 3000000, 1),
      (8, 8, 2, 3, 8, 8, 'SPCT008', N'Nhẫn cưới bạc', 10, 2500000, 1),
      (9, 9, 1, 4, 9, 9, 'SPCT009', N'Lắc chân vàng', 9, 2200000, 1);

INSERT INTO Nhan_vien (ma_nhan_vien, ho_ten,ngay_sinh,ngay_bat_dau,mat_khau, gioi_tinh, so_dt, dia_chi, email, id_chuc_vu, trang_thai)
VALUES
    ('NV001', N'Nguyen Van An', '1990-01-01', '2020-01-01', 'password1', 1, '0909125456', N'123 Nguyen Trai, HCMC', 'nguyenvana@gmail.com', 1, 1),
    ('NV001', N'Nguyen Van Bình', '1990-01-02', '2020-01-02', 'password2', 1, '0909125459', N'456 Le Loi, HCMC', 'tranthib@gmail.com', 2, 1),
    ('NV003', N'Le Van Chung', '1992-03-03', '2022-03-01', 'password3', 1, '0909723478', N'789 Tran Hung Dao, HCMC', 'levanc@gmail.com', 2, 1),
    ('NV004', N'Pham Thi Dung', '1991-04-04', '2019-04-01', 'password4', 0, '0907123575', N'123 Cach Mang Thang 8, HCMC', 'phamthid@gmail.com', 2, 1),
    ('NV005', N'Vo Van Phuong', '1988-05-05', '2018-05-01', 'password5', 1, '0909123665', N'456 Nguyen Hue, HCMC', 'vovane@gmail.com', 2, 1),
    ('NV006', N'Hoang Thi Phuong', '1993-06-06', '2017-06-01', 'password6', 0, '0909122171', N'789 Ly Tu Trong, HCMC', 'hoangthif@gmail.com', 2, 1),
    ('NV007', N'Bui Van Giang', '1990-07-07', '2020-07-01', 'password7', 1, '0909123817', N'123 Pasteur, HCMC', 'buivang@gmail.com', 2, 1),
    ('NV008', N'Dang Thi Huong', '1987-08-08', '2021-08-01', 'password8', 0, '0909123937', N'456 Hai Ba Trung, HCMC', 'dangthih@gmail.com', 2, 0),
    ('NV009', N'Nguyen Van Duong', '1994-09-09', '2019-09-01', 'password9', 1, '0909153457', N'789 Nguyen Dinh Chieu, HCMC', 'nguyenvani@gmail.com', 2, 0),
    ('NV010', N'Le Thi Mai', '1991-10-10', '2022-10-01', 'password10', 0, '0909123767', N'123 Dien Bien Phu, HCMC', 'lethij@gmail.com', 2, 1);

INSERT INTO Khach_hang (ma_khach_hang, ten_khach_hang, gioi_tinh, so_dt, dia_chi, email, trang_thai)
VALUES
    ('KH001', N'Nguyen Van Phuong', 1, '0901125456', N'123 Đường Nguyễn Trãi', 'nvp@gmail.com', 1),
    ('KH002', N'Nguyen Van Dung', 1, '0901126456', N'123 Cầu Giấy', 'nvd@egmail.com', 1),
    ('KH003', N'Pham Thu Phuong', 0, '0923454789', N'789 Đường Pham Van Huyen', 'ptp@gmail.com', 1),
    ('KH004', N'Pham Thi Dung', 0, '0934467890', N'012 Đường Pham Tat Thanh', 'ptd@gmail.com', 1),
    ('KH005', N'Vu Thi Em', 0, '0945698901', N'345 Đường Nguyen Chi Thanh', 'vte@gmail.com', 1),
    ('KH006', N'Do Van Phu', 1, '0956729012', N'678 Đường Dong Da', 'dvp@gmail.com', 1),
    ('KH007', N'Hoang Thi Giang', 0, '0967990128', N'901 Đường Le Loi', 'htg@gmail.com', 1),
    ('KH008', N'Bui Van Hoang', 1, '0978909234', N'234 Đường Ba Dinh', 'bvh@gmail.com', 1),
    ('KH009', N'Nguyen Thi Nhi', 0, '0988012345', N'567 Đường Nguyen Vuong', 'ntn@gmail.com', 1),
    ('KH010', N'Tran Van Dung', 1, '0990183456', N'890 Đường Chua Lang', 'tvd@gmail.com', 1),
    ('KH011', N'Le Thi Kim', 0, '0911123856', N'123 Đường Thanh Cong', 'ltk@gmail.com', 1),
    ('KH012', N'Pham Van Linh', 1, '0922284567', N'456 Đường Giap Bat', 'pvl@gmail.com', 1),
    ('KH013', N'Vu Thi Minh', 0, '0933345878', N'789 Đường Ba Dinh', 'vtm@gmail.com', 1),
    ('KH014', N'Do Van Ninh', 1, '0944456889', N'012 Đường HCM', 'dvn@gmail.com', 1),
    ('KH015', N'Hoang Thi Oanh', 0, '0955867890', N'345 Đường Quoc Oai', 'hto@gmail.com', 1);

INSERT INTO Voucher (ma_voucher, ten_voucher, so_luong_voucher, gioi_han_giam_toi_thieu, gioi_han_giam_toi_da,giam_gia, ngay_bat_dau, ngay_ket_thuc, hinh_thuc_giam, trang_thai)
VALUES
    ('VC001', N'Voucher 1', 100, 100000, 30000,20000, '2024-01-01', '2024-01-30', N'Giảm giá theo số tiền', 1),
    ('VC002', N'Voucher 2', 200, 200000, 50000 ,20, '2024-03-01', '2024-03-30', N'Giảm giá theo %', 1),
    ('VC003', N'Voucher 3', 300, 150000, 25000, 10,'2024-03-01', '2024-03-30', N'Giảm giá theo %', 0),
    ('VC004', N'Voucher 4', 400, 200000, 30000,20, '2024-07-01', '2024-07-30', N'Giảm giá theo %', 1),
    ('VC005', N'Voucher 5', 500, 250000, 50000,40000, '2024-09-01', '2024-09-30', N'Giảm giá theo số tiền', 1),
    ('VC006', N'Voucher 6', 600, 300000, 60000,50000, '2024-10-01', '2024-10-30', N'Giảm giá theo số tiền', 0),
    ('VC007', N'Voucher 7', 700, 350000, 50000,50000, '2024-11-01', '2024-12-30', N'Giảm giá theo số tiền', 1);

INSERT INTO Hoa_don (ma_hoa_don, id_khach_hang, id_nhan_vien, ten_khach_hang, dia_chi_khach_hang, so_dt, ngay_tao, tong_tien, hinh_thuc_thanh_toan, id_voucher, trang_thai)
VALUES('HD001', 1, 1, N'Nguyen Van Phuong', N'123 Đường Nguyễn Trãi','0901125456', '2024-01-01', 5000000, 'Tiền mặt', 1, 1),
      ('HD002', 2, 2, N'Nguyen Van Dung', N'123 Cầu Giấy','0901126456', '2024-01-01', 5000000, 'Tiền mặt', 2, 1),
      ('HD003', 3, 3, N'Pham Thu Phuong', N'789 Đường Pham Van Huyen', '0923454789', '2024-01-01', 5000000, 'Tiền mặt', 2, 1),
      ('HD004', 4, 4, N'Pham Thi Dung', N'012 Đường Pham Tat Thanh', '0934467890', '2024-01-01', 5000000, 'Tiền mặt', 4, 1),
      ('HD005', 5, 5, N'Vu Thi Em', N'345 Đường Nguyen Chi Thanh', '0945698901', '2024-01-01', 5000000, 'Tiền mặt', 5, 1),
      ('HD006', 6, 6, N'Do Van Phu', N'678 Đường Dong Da', '0956729012', '2024-01-01', 5000000, 'Tiền mặt', 5, 1),
      ('HD007', 7, 7, N'Hoang Thi Giang', N'901 Đường Le Loi', '0967990128', '2024-01-01',  5000000, 'Tiền mặt', 7, 1);

INSERT INTO Hoa_don_chi_tiet (ma_hoa_don_chi_tiet, id_hoa_don, id_san_pham_chi_tiet, so_luong, don_gia, thanh_tien, trang_thai)
VALUES
    ('HDCT001', 1, 1, 2, 500000, 1000000, 1),
    ('HDCT002', 2, 2, 1, 3000000, 3000000, 1),
    ('HDCT003', 3, 3, 3, 2000000, 6000000, 1),
    ('HDCT004', 4, 4, 4, 7000000, 28000000, 1),
    ('HDCT005', 5, 5, 5, 8000000, 40000000, 0),
    ('HDCT006', 6, 6, 6, 9000000, 54000000, 1);


SELECT * FROM San_pham
SELECT * FROM San_pham_chi_tiet
SELECT * FROM Kich_thuoc
SELECT * FROM Mau_sac
SELECT * FROM Chat_lieu
SELECT * FROM Da
SELECT * FROM Xuat_xu
SELECT * FROM Hoa_don
SELECT * FROM Hoa_don_chi_tiet
SELECT * FROM Voucher
SELECT * FROM Khach_hang
SELECT * FROM Nhan_vien
SELECT * FROM Chuc_vu