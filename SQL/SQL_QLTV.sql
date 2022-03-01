create database Thu_vien;
use Thu_vien

select * from BANDOC
select * from SACH
select * from PHIEUMUON

drop table BANDOC
create table BANDOC
(
	maBD char(10) primary key not null,
	hoteBD Nvarchar(30) not null,
	lop char(6) not null,
	quequan Nvarchar(20) not null,
	sdt char(15) not null,
)

insert into BANDOC 
values ('HN007',N'Phương Văn Sơn','AT16B',N'Hà Nội','0962489598')
values ('TN001',N'Lê Hoài An','AT16B',N'Thái Nguyên','0923456098'),
		('TB266',N'Bùi Quang Hoà','AT16C',N'Thái Bình','09232137548'),
		('QN015',N'Nguyễn Tấn Dũng','AT15A',N'Quảng Ngãi','0948659494'),
		('BN123',N'Nguyễn Văn Luật','AT16G',N'Bắc Ninh','0912456798'),
		('HN123',N'Nguyễn Anh Tuấn','AT16B',N'Hà Nội','0984453258'),
		('TH246',N'Nguyễn Tiến Đạt','AT15B',N'Thanh Hoá','0985656798'),
		('QN646',N'Trịnh Thế Trường','AT16B',N'Quảng Ninh','0198466238'),
		('TN002',N'Lâm Huệ Lan','AT16A',N'Thái Nguyên','0974166844'),
		('TH554',N'Trần Thị Vân','AT13B',N'Thanh Hoá','0125849636'),
		('NA684',N'Nguyễn Thị Trang','AT15G',N'Nghệ An','0124849632')



drop table SACH
create table SACH
(
	maS char(10) primary key not null,
	tenS nvarchar(30) not null,
	Theloai nvarchar(20) not null,
	Tacgia nvarchar(20) not null,
	NamXB int not null,
	NhaXB nvarchar(15) not null
)

insert into SACH 
values ('KH26',N'Cơ sơ lý thuyết truyền tin',N'Khoa học',N'Trần Thanh Nhàn',2018,N'Giáo Dục'),
		('BC20',N'Báo thanh niên',N'Báo chí',N'Nguyễn Anh Tú',2021,N'Tuổi trẻ')
values ('KH24',N'Hệ quản trị CSDL',N'Khoa học',N'Kim Tiền',2015,N'Giáo Dục'),
		('KH23',N'Nhập môn mật mã học',N'Khoa học',N'Nguyễn Văn Quyết',2017,N'Giáo Dục'),
		('VH13',N'Số đỏ',N'Văn học',N'Vũ Trọng Phụng',2002,N'Hà Nội'),
		('TT12',N'Ánh trăng',N'Tiểu thuyết',N'Nguyễn Xuân Sơn',2014,N'Phụ Nam'),
		('TH15',N'Đại số tuyến tính',N'Toán học',N'Nguyễn Văn An',2018,N'Giáo Dục'),
		('T123',N'Sóng',N'Thơ',N'Xuân Quỳnh',2001,N'Đại Việt'),
		('TC23',N'Bạch tuyết và 7 chú lùn',N'Truyện cổ tích',N'Grimm',1812,N'Nước ngoài'),
		('KH15',N'Tin học đại cương',N'Khoa học',N'Vũ Đình Quảng',2015,N'Giáo Dục')





drop table PHIEUMUON
create table PHIEUMUON
(
	maBD char(10) not null foreign key references BANDOC(maBD),
	maS char(10) not null foreign key references SACH(maS),
	Ngaymuon date not null,
	Ngayhentra date not null,
	Trasach bit default '0',
	constraint PHIEUMUON_KEY primary key (maBD,maS),
	constraint PK check (Ngaymuon<Ngayhentra)
)

insert into PHIEUMUON
values ('QN015','TH15','2018/02/01', '2018/04/01',1)
values  ('NA684','TH15','2021/04/15', '2021/05/25',0)
values ('HN007','KH24','2021/06/10', '2021/08/10',1),
		('HN007','TH15','2021/08/30', '2021/09/30',0)

values ('BN123','KH24','2021/07/01', '2021/10/01',0),
		('BN123','KH23','2020/12/15', '2021/02/20',0),
		('BN123','TT12','2020/11/20', '2021/12/20',1)

values ('HN123','TH15','2021/07/15', '2021/07/25',1),
		('HN123','KH23','2021/07/15', '2021/07/30',0),
		('TN001','T123','2021/03/24', '2021/04/10',1),
		('TN001','TC23','2021/04/06', '2021/04/26',0),
		('TN002','VH13','2021/07/20', '2021/07/30',1),
		('NA684','TT12','2021/05/10', '2021/06/01',0),
		('TB266','KH24','2021/07/24', '2021/08/14',1),
		('HN123','KH24','2021/08/18', '2021/09/18',1),
		('QN015','VH13','2021/02/01', '2021/04/01',0),
		('TN002','TH15','2021/03/15', '2021/05/15',0),
		('QN646','KH15','2020/12/20', '2021/01/30',1),
		('TH246','KH24','2020/09/10', '2021/12/20',1),
		('TH246','TH15','2021/09/15', '2021/10/15',0),
		('NA684','KH24','2020/09/09', '2021/11/09',1),
		('NA684','T123','2021/04/15', '2021/05/25',0)


alter table PHIEUMUON 
add constraint PHIEUMUON_NGAYTRA check(Ngayhentra <= dateadd(day,5,Ngaymuon)) -- Sách chỉ được mượn tối đa 5 ngày


--C1 : Xem bạn có mã bạn đọc là HN123 đã mượn những quyển sách nào ( in mã sách và tên sách)
select pm.maBD,s.tenS
from PHIEUMUON as pm, SACH as s
where (pm.maBD = 'HN123') and pm.maS = s.maS

--C2: Có bao nhiêu cuốn thiểu thuyết đã được mượn vào tháng 9/2018 
select count(pm.maS) as SL
from PHIEUMUON pm, SACH s
where pm.maS = s.maS and month(pm.Ngaymuon) = 9 and year(pm.Ngaymuon) = 2018 and s.Theloai like N'Tiểu thuyết' 

--C3: Hiện thị về việc mượn sách của những độc giả quê ở Hà nội
select *
from BANDOC bd, PHIEUMUON pm
where pm.maBD = bd.maBD and bd.quequan = N'Hà Nội'

--C4: Hiển thị mã bạn đọc và tên của các bạn cùng mượn sách có mã là T123
select bd.maBD, hoteBD
from BANDOC bd, PHIEUMUON pm
where bd.maBD = pm.maBD and pm.maS = 'T123'

--C5: Hiển thị danh sách bạn đọc quê ở Bắc Ninh và chưa trả sách 
select distinct bd.hoteBD
from BANDOC bd, PHIEUMUON pm
where bd.maBD = pm.maBD and bd.quequan = N'Bắc Ninh' and  pm.Trasach = '0'

--C6: Hiển thị bạn đọc quê ở Hà nội mượn nhiều sách nhất 
select top(1) bd.hoteBD, count(maS) as Soluong
from BANDOC bd, PHIEUMUON pm
where bd.maBD = pm.maBD and bd.quequan = N'Hà Nội'
group by bd.hoteBD
order by Soluong desc

--C7: Tính số lượng sách của mỗi thể loại có trong thư viện
select Theloai, count(maS) as Soluong
from SACH
group by Theloai

--C8: Hiển thị các cuốn sách được in ở nhà xuất bản giáo dục trước năm 2010
select tenS, NamXB
from SACH
where namXB < 2010

--C9: Hiển thị các bạn có mã bạn đọc nhưng chưa mượn sách bao giờ
select bd.maBD, bd.hoteBD
from (BANDOC bd full join PHIEUMUON pm on bd.maBD = pm.maBD)
where pm.maBD is null

select maBD
from BANDOC
except
select maBD
from PHIEUMUON


--C10: Hiển thị các bạn mượn nhiều hơn hoặc bằng 2 quyển sách
select bd.hoteBD, count(maS) as Soluong
from BANDOC bd, PHIEUMUON pm
where bd.maBD = pm.maBD
group by bd.hoteBD
having count(maS) >=2


--C11: Hiển thị các bạn mượn nhiều hơn hoặc bằng 3 quyển sách thuộc thể loại “Sách khoa học” vào tháng 10/2018
select bd.hoteBD, count(pm.maS) as Soluong
from BANDOC bd, PHIEUMUON pm, SACH s
where bd.maBD = pm.maBD and s.maS = pm.maS and s.Theloai = N'Khoa học' and Ngaymuon like '2021-07%'
group by bd.hoteBD
having count(pm.maS) >= 1

--C12: Hiển thị tổng số sách đã được mượn ở Thư viện
select count(maS) as Soluong
from PHIEUMUON
where Trasach = 0

--C13: Hiện thị mã và tên bạn đọc mượn sách nhiều hơn bạn có mã số là BN123
select bd.maBD, bd.hoteBD, count(maS) as Soluong
from BANDOC bd, PHIEUMUON pm
where bd.maBD = pm.maBD 
group by bd.maBD, bd.hoteBD
having count(maS) > 
(
select count(maS)
from PHIEUMUON 
where maBD = 'BN123'
)

--C14: Hiển thị mã và tên cuốn sách được mượn nhiều nhất,ít nhất ở Thư viện năm 2018		Chua xong


select top(1) pm.maS, s.tenS, count(pm.maS) as Soluong
from PHIEUMUON pm, SACH s
where pm.maS = s.maS and year(pm.Ngaymuon) = 2018
group by pm.maS, s.tenS
order by Soluong desc
--order by Soluong asc

--C15: Cho danh sách các bạn đọc mượn sách quá hạn tính đến ngày hiện tại
select hoteBD
from BANDOC bd, PHIEUMUON pm
where bd.maBD = pm.maBD and pm.Trasach = 0 and pm.Ngayhentra > GETDATE()
group by hoteBD