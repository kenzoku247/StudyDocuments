use QLMB

select * from CHUNGNHAN
select * from CHUYENBAY
select * from MAYBAY
select * from NHANVIEN

sp_help CHUYENBAY

insert into CHUYENBAY
values ('VN431', 'SGN','CAH',3693,'05:55','06:55',236),
		('VN320', 'SGN','DAD',2798,'06:00','07:10',221),
		('VN464', 'SGN','DLI',2002,'07:20','08:05',225),
		('VN216', 'SGN','DIN',4170,'10:30','14:20',262),
		('VN280', 'SGN','HPH',11979,'06:00','08:00',1279),
		('VN254', 'SGN','HUI',8765,'18:40','20:00',781),
		('VN338', 'SGN','BMV',4081,'15:25','16:25',375),
		('VN440', 'SGN','BMV',4081,'18:30','19:30',426),
		('VN651', 'DAD','SGN',2798,'19:30','08:00',221),
		('VN276', 'DAD','CXR',1283,'09:00','12:00',203),
		('VN374', 'HAN','VII',510,'11:40','13:25',120),
		('VN375', 'VII','CXR',752,'14:15','16:00',181),
		('VN269', 'HAN','CXR',1262,'14:10','15:50',202),
		('VN315', 'HAN','DAD',134,'11:45','13:00',112),
		('VN317', 'HAN','UIH',827,'15:00','16:15',190),
		('VN741', 'HAN','PXU',395,'06:30','08:30',120),
		('VN474', 'PXU','PQC',1586,'08:40','11:20',102),
		('VN476', 'UIH','PQC',485,'09:15','11:50',117)

sp_help MAYBAY		
insert into MAYBAY
values (747,'Boeing 747 - 400',13488),
		(737,'Boeing 737 - 800',5413),
		(340,'Airbus A340 - 300',11392),
		(757,'Boeing 757 - 300',6416),
		(777,'Boeing 777 - 300',10306),
		(767,'Boeing 767 - 400ER',10360),
		(320,'Airbus A320',4168),
		(319,'Airbus A319',2888),
		(727,'Boeing 727',2406),
		(154,'Tupolev',6565)

insert into NHANVIEN
values (242518965,'Tran Van Son', 120433),
		(141582651,'Doan Thi Mai', 178345),
		(011564812,'Ton Van Quy', 153972),
		(567354612,'Quan Cam Ly', 256481),
		(552455318,'La Que', 101745),
		(550156548,'Nguyen Thi Cam', 205187),
		(390487451,'Le Van Luat', 212156),
		(274878974,'Mai Quoc Minh', 99890),
		(254099823,'Nguyen Thi Quynh', 24450),
		(356187925,'Nguyen Vinh Bao', 44740),
		(355548984,'Tran Thi Hoai An', 212156),
		(310454876,'Ta Van Do', 212156),
		(489456522,'Nguyen Thi Quy Linh', 127984),
		(489221823,'Bui Quoc Chinh', 23980),
		(548977562,'Le Van Quy', 84476),
		(310454877,'Tran Van Hao', 33546),
		(142519864,'Nguyen Thi Xuan Dao', 227489),
		(269734834,'Truong Tuan Anh', 289950),
		(287321212,'Duong Van Minh', 48090),
		(552455348,'Bui Thi Dung', 92013),
		(248965255,'Tran Thi Ba', 43723),
		(159542516,'Le Van Ky', 48250),
		(348121549,'Nguyen Van Thanh', 32899),
		(574489457,'Bui Van Lap', 20)

insert into CHUNGNHAN
values (567354612,747),
		(567354612,737),
		(567354612,757),
		(567354612,777),
		(567354612,767),
		(567354612,727),
		(567354612,340),
		(552455318,737),
		(552455318,319),
		(552455318,747),
		(552455318,767),
		(390487451,340),
		(390487451,320),
		(390487451,319),
		(274878974,757),
		(274878974,767),
		(355548984,154),
		(310454876,154),
		(142519864,747),
		(142519864,757),
		(142519864,777),
		(142519864,767),
		(142519864,737),
		(142519864,340),
		(142519864,320),
		(269734834,747),
		(269734834,737),
		(269734834,340),
		(269734834,757),
		(269734834,777),
		(269734834,767),
		(269734834,320),
		(269734834,319),
		(269734834,727),
		(269734834,154),
		(242518965,737),
		(242518965,757),
		(141582651,737),
		(141582651,757),
		(141582651,767),
		(011564812,737),
		(011564812,757),
		(574489457,154)

--C1: Cho biết thông tin về các nhân viên có lương nhỏ hơn 10000select *from NHANVIENwhere Luong < 1000--C2: Cho biết thông tin về các chuyến bay có độ dài đường bay nhỏ hơn 10000km và lớn hơn 8000kmselect *from CHUYENBAYwhere DoDai  between 8000 and 10000--C3: Cho biết thông tin về các chuyến bay xuất phát từ Sài Gòn (SGN) đi Ban Mê Thuột (BMV)select *from CHUYENBAYwhere GaDi = 'SGN' and GaDen = 'BMV'--C4: Có bao nhiêu chuyến bay xuất phát từ Sài Gòn (SGN)select count(MaCB) as Soluongfrom CHUYENBAYwhere GaDi = 'SGN' --C5: Có bao nhiêu loại máy bay Boeingselect count(MaMB) as Soluongfrom MAYBAYwhere Hieu like 'Boeing%'--C6: Cho biết tổng số lương phải trả cho các nhân viênselect sum(luong)from NHANVIEN--C7: . Cho biết mã số và tên của các phi công lái máy bay Boeingselect nv.MaNV, Tenfrom NHANVIEN nv, CHUNGNHAN cn, MAYBAY mbwhere nv.MaNV = cn.MaNV and cn.MaMB = mb.MaMB and mb.Hieu like 'Boeing%'group by nv.MaNV, Ten--C8: Cho biết mã số và tên của các phi công có thể lái được máy bay có mã số là 747select nv.MaNV, Tenfrom NHANVIEN nv, CHUNGNHAN cnwhere nv.MaNV = cn.MaNV  and cn.MaMB = 747--C9: Cho biết mã số của các loại máy bay mà nhân viên có họ Nguyễn có thể láiselect MaMBfrom NHANVIEN nv, CHUNGNHAN cnwhere nv.MaNV = cn.MaNV and Ten like 'Nguyen%'--C10: Cho biết mã số của các phi công vừa lái được Boeing vừa lại được Airbus A320select nv.MaNV, Tenfrom NHANVIEN nv, CHUNGNHAN cn, MAYBAY mbwhere nv.MaNV = cn.MaNV and cn.MaMB = mb.MaMB and mb.Hieu like 'Boeing%'group by nv.MaNV, Tenintersectselect nv.MaNV, Tenfrom NHANVIEN nv, CHUNGNHAN cn, MAYBAY mbwhere nv.MaNV = cn.MaNV and cn.MaMB = mb.MaMB and mb.Hieu like 'Airbus A320'group by nv.MaNV, Ten--C11: Cho biết các loại máy bay có thể thực hiện được chuyến bay VN280select MaMB, Hieufrom CHUYENBAY cb, MAYBAY mbwhere mb.TamBay >= cb.DoDai and cb.MaCB = 'VN280'--C12: Cho biết các chuyến bay có thể thực hiện bởi máy bay Airbus A320select MaCBfrom CHUYENBAY cb, MAYBAY mbwhere mb.TamBay >= cb.DoDai and mb.MaMB = 320 and TamBay >= DoDai--C13: Với mỗi loại máy bay có phi công lái, cho biết mã số, loại máy bay và tổng số phi công có thể lái loại máy bay đóselect count(nv.MaNV) as Soluong, cn.MaMB, mb.Hieufrom NHANVIEN nv, CHUNGNHAN cn, MAYBAY mbwhere nv.MaNV = cn.MaNV and cn.MaMB = mb.MaMBgroup by cn.MaMB, mb.Hieu--C14: Giả sử một hành khách muốn đi thẳng từ ga A đến ga B rồi quay trở về ga A. Cho biết các đường bay nào có thể đáp ứng yêu cầu nàyselect distinct a.MaCB
from CHUYENBAY as a, CHUYENBAY as b
where a.GaDen <> b.GaDen and a.GaDen = b.GaDi--C15: Với mỗi ga có chuyến bay xuất phát từ đó, cho biết có bao nhiêu chuyến bay khởi					'Chua xong'
-- hành từ ga đó và cho biết tổng chi phí phải trả chi phi công lái các chuyến bay khởi hành từ ga đó.
select GaDi, count(MaCB) as SoCB, sum(ChiPhi) as TongCP
from CHUYENBAY 
group by GaDi

--C16: Với mỗi ga xuất phát, cho biết có bao nhiêu chuyến bay có thể khởi hành trước 12:00 
select GaDi, count(MaCB) as SoCB
from CHUYENBAY 
where GioDi < '12:00'
group by GaDi

--C17: Với mỗi phi công có thể lái nhiều hơn 3 loại máy bay, cho biết mã số phi công và tầm
--     bay lớn nhất của các loại máy bay mà phi công đó có thể láiselect MaNV, max(Tambay) as MAXtamfrom CHUNGNHAN cn, MAYBAY mb where cn.MaMB = mb.MaMB and MaNV in (select MaNVfrom CHUNGNHANgroup by MaNVhaving count(MaMB) > 3)group by MaNV--C18: Cho biết mã số của các phi công có thể lái được nhiều loại máy bay nhấtselect top(1) MaNV, count(MaMB) as Soluongfrom CHUNGNHANgroup by MaNVorder by count(MaMB) desc--C19: Cho biết mã số của các phi công có thể lái được ít loại máy bay nhất.select top(1) MaNV, count(MaMB) as Soluongfrom CHUNGNHANgroup by MaNVorder by count(MaMB) asc--C20: Tìm các chuyến bay có thể được thực hiện bởi tất cả các loại máy bay Boeingselect *from CHUYENBAY cbwhere DoDai < (select min(TamBay)from MAYBAY mbwhere mb.Hieu like 'Boeing%')--C21: Tìm các chuyến bay có thể được lái bởi các phi công có lương lớn hơn 100.000select distinct MaCBfrom NHANVIEN nv, MAYBAY mb, CHUYENBAY cb, CHUNGNHAN cnwhere nv.MaNV = cn.MaNV and cn.MaMB = mb.MaMB and TamBay > DoDai and nv.MaNV in(select nv.MaNVfrom NHANVIEN nvwhere Luong > 100000)group by MaCB--C22: Cho biết tên các phi công có lương nhỏ hơn chi phí thấp nhất của đường bay từ Sài
--	   Gòn (SGN) đến Buôn mê Thuột (BMV)select Tenfrom NHANVIEN nvwhere Luong <(select min(ChiPhi)from CHUYENBAY cbwhere GaDi = 'SGN' and GaDen = 'BMV')--C23: Cho biết mã số của các phi công có lương cao nhấtselect top (1) MaNVfrom NHANVIENorder by Luong descselect MaNVfrom NHANVIEN--C24: Cho biết mã số của các nhân viên có lương cao thứ nhìselect top (1) MaNVfrom NHANVIENwhere MaNV in(select top (2) MaNVfrom NHANVIENorder by Luong desc)order by Luong asc--C25: Cho biết tên và lương của các nhân viên không phải là phi công và có lương lớn hơn
--	   lương trung bình của tất cả các phi công
select Ten, Luong
from NHANVIEN nv
where nv.MaNV not in 
(
	select MaNV
	from CHUNGNHAN cn
) and Luong >
(
	select avg(Luong)
	from NHANVIEN nv
	where nv.MaNV in 
(
	select MaNV
	from CHUNGNHAN cn
)
)

--C26: Cho biết tên các phi công có thể lái các máy bay có tầm bay lớn hơn 4.800km nhưng
--	   không có chứng nhận lái máy bay Boeing
select distinct nv.Ten
from NHANVIEN nv, CHUNGNHAN cn, MAYBAY mb
where nv.MaNV = cn.MaNV and cn.MaMB = mb.MaMB and TamBay > 4800 and Hieu not like 'Boeing%'

--C27: Cho biết tên các phi công lái ít nhất 3 loại máy bay có tầm xa hơn 3200kmselect Ten
from NHANVIEN nv, CHUNGNHAN cn, MAYBAY mb
where nv.MaNV = cn.MaNV and cn.MaMB = mb.MaMB and TamBay > 3200
group by nv.Ten
having count(cn.MaMB) >=3

--C28: Với mỗi nhân viên, cho biết mã số, tên nhân viên và tổng số loại máy bay Boeing mà			Chua xong
--	   nhân viên đó có thể lái
select *
from ((NHANVIEN nv full join CHUNGNHAN cn on nv.MaNV = cn.MaNV) full join MAYBAY mb on cn.MaMB = mb.MaMB)group by ten

--C29: Với mỗi loại máy bay, cho biết loại máy bay và tổng số phi công có thể lái loại máy bay đó.
select Hieu, count(nv.MaNV) as Soluong
from NHANVIEN nv, CHUNGNHAN cn, MAYBAY mb
where nv.MaNV = cn.MaNV and cn.MaMB = mb.MaMB
group by Hieu



--C30: Với mỗi chuyến bay, cho biết mã số chuyến bay và tổng số phi công không thể lái chuyến đó.		Chua xong
select MaCB, count(nv.MaNV) as Soluong
from NHANVIEN nv, CHUNGNHAN cn, MAYBAY mb, CHUYENBAY cb
where nv.MaNV = cn.MaNV and cn.MaMB = mb.MaMB and TamBay < DoDai
group by MaCB

--C31: Với mỗi loại máy bay, cho biết loại máy bay và tổng số chuyến bay không thể thực hiện bởi loại máy bay đó.
select Hieu, count(MaCB) as Soluong
from  MAYBAY , CHUYENBAY 
where Dodai > TamBay
group by Hieu

--C32: Với mỗi chuyến bay, hãy cho biết mã số chuyến bay và tổng số loại máy bay có thể thực hiện chuyến bay đó		Chua xong--C33: Với mỗi loại máy bay, hãy cho biết loại máy bay và tổng số phi công có lương lớn hơn 100.000 có thể lái loại máy bay đó.select Hieu, count(nv.MaNV) as Soluong
from NHANVIEN nv, CHUNGNHAN cn, MAYBAY mb
where nv.MaNV = cn.MaNV and cn.MaMB = mb.MaMB and Luong > 100000
group by Hieu

--C34: Với mỗi loại máy bay có tầm bay trên 3200km, cho biết tên của loại máy bay và lương
--     trung bình của các phi công có thể lái loại máy bay đó.
select Hieu, avg(nv.Luong) as LuongTB
from NHANVIEN nv, CHUNGNHAN cn, MAYBAY mb
where nv.MaNV = cn.MaNV and cn.MaMB = mb.MaMB and TamBay > 3200
group by Hieu

--C35: Với mỗi phi công, cho biết mã số, tên phi công và tổng số chuyến bay xuất phát từ Sài Gòn mà phi công đó có thể lái
select nv.MaNV, Ten, count(distinct MaCB) as Soluong
from NHANVIEN nv, CHUNGNHAN cn, MAYBAY mb, CHUYENBAY cb
where nv.MaNV = cn.MaNV and cn.MaMB = mb.MaMB and cb.DoDai < mb.TamBay and GaDi ='SGN'
group by nv.MaNV, Ten

--C36: Một hành khách muốn đi từ Hà Nội (HAN) đến nha trang (CXR) mà không phải đổi			Chua xong
--     chuyến bay quá một lần. Cho biết mã chuyến bay, thời gian khời hành từ Hà nội nếu
--     hành khách muốn đến Nha Trang trước 16:00select distinct a.MaCBfrom CHUYENBAY a, CHUYENBAY bwhere (a.GaDi ='HAN'and a.GaDen = 'CXR') or ((a.GaDi ='HAN' or b.GaDen = 'CXR') and a.GaDen = b.GaDi ) and (a.GioDen < '16:00' or b.GioDen < '16:00')--C37: Cho biết thông tin của các đường bay mà tất cả các phi công có thể bay trên đường bay đó đều có lương lớn hơn 100000select MaCBfrom CHUYENBAY cb, CHUNGNHAN cn, NHANVIEN nv, MAYBAY mbwhere cn.MaNV = nv.MaNV and mb.MaMB = cn.MaMB and Luong > 100000 and TamBay > DoDaigroup by MaCBorder by MaCB