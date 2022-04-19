create database QLMB
use QLMB
-- drop database QLMB

create table CHUYENBAY(
	MaCB char(5) primary key,
	GaDi varchar(50) not null,
	GaDen varchar(50) not null,
	DoDai int not null,
	GioDi time not null,
	GioDen time not null,
	ChiPhi int not null
);

create table MAYBAY(
	MaMB int primary key,
	Hieu varchar(50) not null,
	TamBay int not null
);



create table NHANVIEN(
	MaNV char(9) primary key,
	Ten varchar(50) not null,
	Luong int not null
);

create table CHUNGNHAN(
	MaNV char(9) foreign key references NHANVIEN(MaNV),
	MaMB int foreign key references MAYBAY(MaMB)
);


INSERT INTO CHUYENBAY 
VALUES('VN431', 'SGN', 'CAH', 3693, '05:55', '06:55', 236),
('VN320', 'SGN', 'DAD', 2798, '06:00', '07:10', 221),
('VN464', 'SGN', 'DLI', 2002, '07:20', '08:05', 225),
('VN216', 'SGN', 'DIN', 4170, '10:30', '14:20', 262),
('VN280', 'SGN', 'HPH', 11979, '06:00', '08:00', 1279),
('VN254', 'SGN', 'HUI', 8765, '18:40', '20:00', 781),
('VN338', 'SGN', 'BMV', 4081, '15:25', '16:25', 375),
('VN440', 'SGN', 'BMV', 4081, '18:30', '19:30', 426),
('VN651', 'DAD', 'SGN', 2798, '19:30', '08:00', 221),
('VN276', 'DAD', 'CXR', 1283, '09:00', '12:00', 203),
('VN374', 'HAN', 'VII', 510, '11:40', '13:25', 120),
('VN375', 'VII', 'CXR', 752, '14:15', '16:00', 181),
('VN269', 'HAN', 'CXR', 1262, '14:10', '15:50', 202),
('VN315', 'HAN', 'DAD', 134, '11:45', '13:00', 112),
('VN317', 'HAN', 'UIH', 827, '15:00', '16:15', 190),
('VN741', 'HAN', 'PXU', 395, '06:30', '08:30', 120),
('VN474', 'PXU', 'PQC', 1586, '08:40', '11:20', 102),
('VN476', 'UIH', 'PQC', 485, '09:15', '11:50', 117);

INSERT INTO MAYBAY VALUES(747, 'Boeing 747 - 400', 13488),
(737, 'Boeing 737 - 800', 5413),
(340, 'Airbus A340 - 300', 11392),
(757, 'Boeing 757 - 300', 3416),
(777, 'Boeing 777 - 300', 10306),
(767, 'Boeing 767 - 400ER', 10360),
(320, 'Airbus A320', 4168),
(319, 'Airbus A319', 2888),
(727, 'Boeing 727', 2406),
(154, 'Tupolev 154', 6565);

INSERT INTO NHANVIEN VALUES(16684, 'Tran Van Son', 185613),
(65156, 'Doan Thi Mai', 200000),
(54548, 'Ton Van Quy', 543298),
(61652, 'Quan Cam Ly', 61654),
(64166, 'La Que', 123535),
(23461, 'Nguyen Thi Cam', 549451),
(16518, 'Le Van Luat', 416823),
(31923, 'Mai Quoc Minh', 284858),
(72751, 'Nguyen Thi Quynh', 240642),
(15424, 'Nguyen Vinh Bao', 652165);

INSERT INTO CHUNGNHAN VALUES(16684, 737),
(65156,777),
(54548,767),
(61652, 340),
(64166, 154),
(23461, 320),
(16518, 319),
(31923, 340),
(72751, 777),
(15424, 320);
