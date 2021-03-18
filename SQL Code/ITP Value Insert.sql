insert into class
values ('C01','11A');

insert into exam
values ('E001',2018,11,1,'2018-03-25','2018-04-05');
--date:yyyy-mm-dd

insert into parent
values ('P0001','Mohamed Naib','Weligama','mohamed@outlook.com','teacher','1966-12-12','M','0778962541','0413650085');

insert into subject
values ('SB01','Mathematics');

insert into member
values ('M0001','2012-07-08','Staff'),('M0002','2006-02-26','Student');

insert into hostel
values ('H001','2015-07-08'),('H002','2016-03-15');

insert into userAccount
values ('ismail123','tTMfDh4D6NWdmyXCLMxaVw==','S'),('kaleel789','9tKH6XMerH5dBZ8qQAlvVQ==','T');
--kaleel963
--Ismail854
--Admin123

insert into userAccount
values ('Admin','BlCEL4KicRGlCj29ZG1K2Q==','A');
--S:student
--T:academicStaff
--N:nonAcademicStaff
--L:Librarian
--A:admin

insert into student
values ('10001','Mohamed Naib','Ahamed Ismail','M.N.A. Ismail','2001-08-25','M','','0412250036','','2007-01-02','C01','P0001','ismail123','M0002','H001');
--M:Male
--F:Female

insert into staff
values ('S001','Ahamed Kaleel','Weligama','1985-04-02','0789685423','2003-05-06',1500,45000,'A','kaleel789','M0001','H002');
--T:academicStaff
--N:nonAcademicStaff

insert into staff_subject
values ('S001','SB01');

insert into class_staff_subject
values ('C01','S001','SB01');

insert into staffSalary
values ('SR0001','S001',2018,02,2,43000);

insert into staffAttendance
values ('SA00001','S001','2018-04-12',1,'10',2018),('SA00002','S001','2018-04-13',0,'05',2017);
--1:yes
--0:no

insert into book
values ('B001','Harry Potter','236-2365-259-25','William','Astan Publisher',5);

insert into rental
values ('B001','M0001','2016-04-10','2016-04-26','2016-04-24',2,20,'submitted');

insert into hostelPayment
values ('HP0001','H001',2015,8,5000,'P','2015-09-05');
--P:paid
--N:notPaid

insert into studentAttendance
values('A00001','10001','2015-11-23',1);
--1:attend
--0:notAttend

insert into noticeBoard
values('N001',1,0,'2018-10-10','11.00 AM','Main Hall','Staff Meeting');

insert into payment
values('PM0001','10001','E',150,'2018-04-30');
--E:examFee
--A:anualFee

insert into result
values('10001','E001','SB01',68);

insert into examHall
values('E001','11A',5);

insert into examHallArrang
values('E001','11A','S001');


-----------------------------------------Extra-------------------------------------------------------

insert into class
values ('C02','11B'),('C03','11C'),('C04','11D'),('C05','10A'),('C06','10B'),('C07','10C'),('C08','12Commerce'),('C09','13Bio'),('C10','13BTech');


insert into subject values 
							('SB02','Science'),
							('SB03','Islam'),
							('SB04','English Language'),
							('SB05','History'),
							('SB06','Tamil Language'),
							('SB07','Health'),
							('SB08','Sinhala'),
							('SB09','Tamil Literature'),
							('SB10','Geography'),
							('SB11','Citizenship'),
							('SB12','Art'),
							('SB20','Comb.Mathematics'),
							('SB25','Biology'),
							('SB30','Physics'),
							('SB31','Chemistry'),
							('SB40','General English'),
							('SB41','General Knowledge'),
							('SB51','Tamil'),
							('SB53','Political'),
							('SB61','Bio-Technology'),
							('SB62','Agriculture'),
							('SB63','Science for Tech'),
							('SB71','Eng-Technology'),
							('SB72','ICT'),
							('SB81','Accounting'),
							('SB82','Business Studies'),
							('SB83','Economics');

insert into staff(staffID,name,address,dob,mobileNo,joinedDate,perDayRate,fullSalary,Type)
values ('S001','Kavindu Taraka','Galle','1960-10-12','0775632145','2004-05-30',1500,45000,'A'),
		('S002','Harshani Vithanage','Matara','1958-05-03','0714554522','2001-03-21',1200,36000,'N'),
		('S003','Nishiki Yapa','Akuressa','1962-05-18','0724500965','1995-04-15',1500,45000,'A'),
		('S004','Dinusha Pinaduwa','Weligama','1964-06-16','0789632541','2014-05-30',1200,36000,'A'),
		('S005','Akila Nuwan','Matara','1980-09-22','0713256984','2004-05-30',1800,54000,'A'),
		('S006','Sahan Sandaruwan','Malimbada','1985-08-25','0766542354','2004-06-18',1600,48000,'A'),
		('S007','Ovindu Bandara','Tangalla','1970-06-30','0789632145','2012-02-20',1000,30000,'N'),
		('S008','Ramesh Raj','Weligama','1990-04-14','0726541398','2012-03-30',1300,39000,'A'),
		('S009','Azra Aroos','Matara','1988-02-05','0775632145','2002-10-20',1500,45000,'A'),
		('S010','Arjuna Vithanage','Matara','1958-05-03','0714554522','2001-03-21',1200,36000,'N'),
		('S011','Thushari Ranathunga','Akuressa','1962-05-18','0724500965','1995-04-15',1500,45000,'A'),
		('S012','Dinusha Jayawardane','Weligama','1964-06-16','0789632541','2014-05-30',1200,36000,'A'),
		('S013','malinga Fernando','Matara','1980-09-22','0713256984','2004-05-30',1800,54000,'A'),
		('S014','Saman Jayaweera','Malimbada','1985-08-25','0766542354','2004-06-18',1600,48000,'A'),
		('S015','Rasika Sampath','Tangalla','1970-06-30','0789632145','2012-02-20',1000,30000,'N'),
		('S016','Safwan Mohamed','Weligama','1990-04-14','0726541398','2012-03-30',1300,39000,'A'),
		('S017','Roshan Jayasundara','Matara','1988-02-05','0775632145','2002-10-20',1500,45000,'A'),
		('S018','Malini Rubasinghe','Matara','1988-02-05','0775632145','2002-10-20',1500,45000,'A'),
		('S019','Jayanganie Jayaweera','Matara','1958-05-03','0714554522','2001-03-21',1200,36000,'N'),
		('S020','Lahiru Hettigoda','Akuressa','1962-05-18','0724500965','1995-04-15',1500,45000,'A'),
		('S021','Menaka Abeywardhana','Weligama','1964-06-16','0789632541','2014-05-30',1200,36000,'A'),
		('S022','Hanika Kaushalya','Matara','1980-09-22','0713256984','2004-05-30',1800,54000,'A'),
		('S023','Tharushi Gamage','Malimbada','1985-08-25','0766542354','2004-06-18',1600,48000,'A'),
		('S024','Akila Ariyathilaka','Tangalla','1970-06-30','0789632145','2012-02-20',1000,30000,'N'),
		('S025','Buddhika Anuradka','Weligama','1990-04-14','0726541398','2012-03-30',1300,39000,'A'),
		('S026','Mohamed Hiflar','Matara','1988-02-05','0775632145','2002-10-20',1500,45000,'A');

insert into staff_subject values('S013','SB20'),
('S014','SB25'),
('S015','SB30'),
('S016','SB30'),
('S017','SB30'),
('S018','SB31'),
('S019','SB31'),
('S020','SB40'),
('S018','SB41'),
('S019','SB71'),
('S025','SB71'),
('S012','SB72'),
('S001','SB72'),
('S016','SB63'),
('S006','SB01'),
('S014','SB61'),
('S019','SB62'),
('S020','SB62'),
('S003','SB81'),
('S005','SB81'),
('S007','SB82'),
('S017','SB82'),
('S019','SB83'),
('S023','SB51'),
('S020','SB53'),
('S011','SB53'),
('S023','SB02'),
('S009','SB03'),
('S020','SB04'),
('S001','SB04'),
('S026','SB05'),
('S022','SB05'),
('S016','SB06'),
('S002','SB07'),
('S001','SB07'),
('S013','SB08'),
('S024','SB08'),
('S006','SB09'),
('S011','SB08'),
('S024','SB06'),
('S026','SB03'),
('S022','SB10'),
('S022','SB11'),
('S011','SB12'),
('S026','SB09');

insert into class_staff_subject
values ('C02','S026','SB09'),('C04','S011','SB12'),('C06','S022','SB11'),('C02','S026','SB03'),('C10','S024','SB06'),
		('C03','S006','SB09'),('C05','S024','SB08'),('C07','S001','SB07'),('C08','S016','SB06');


insert into exam
values ('E002',2018,11,2,'2018-03-25','2018-04-05'),('E003',2018,11,3,'2018-03-25','2018-04-05'),('E004',2018,10,1,'2018-03-25','2018-04-05'),
		('E005',2018,10,2,'2018-03-25','2018-04-05'),('E006',2018,10,3,'2018-03-25','2018-04-05'),('E007',2017,9,1,'2018-03-25','2018-04-05'),
		('E008',2017,9,2,'2018-03-25','2018-04-05'),('E009',2017,9,3,'2018-03-25','2018-04-05'),('E010',2018,8,1,'2018-03-25','2018-04-05');

insert into parent
values ('P0002','Avishka Fernando','Galle','avishka@outlook.com','teacher','1966-12-12','M','0775236418','0918631245'),
		('P0003','Kusal Perera','Matara','kusal@outlook.com','lowyer','1974-08-16','M','0716985325','0816523456'),
		('P0004','Dhanushka Sampath','Akuressa','dhanushka@outlook.com','docter','1972-05-28','M','0787987159','0476251251'),
		('P0005','Ravindu Dilshan','Dickwella','ravindu@outlook.com','manager','1978-02-27','M','0713569852','0115253698'),
		('P0006','Rangani Wasana','Ahangama','wasana@outlook.com','charpernter','1960-05-20','F','0705362514','0413369541'),
		('P0007','Nithmi Samanali','Weligma','samanali@outlook.com','accountent','1980-10-30','F','0767285456','0476532145'),
		('P0008','Ravina Jayakody','Kekanadura','ravindi@outlook.com','software engineer','1975-01-12','F','0753218569','0476214589'),
		('P0009','Sachini Witharana','Matara','sachini@outlook.com','QA Engineer','1980-05-12','F','0723698547','0412222563'),
		('P0010','Nathali Gunasekara','Galle','nathali@outlook.com','Civil engineer','1981-12-30','F','0719632159','0417825639');

insert into member
values ('M0003','2015-08-18','Staff'),('M0004','2017-04-15','Student'),('M0005','2011-07-14','Staff'),
		('M0006','2014-09-28','Student'),('M0007','2018-02-30','Student'),('M0008','2002-10-31','Student'),
		('M0009','2013-10-24','Student'),('M0010','2019-01-12','Student');

insert into hostel
values ('H003','2015-01-29'),('H004','2016-04-25'),('H005','2009-03-18'),('H006','2014-02-12'),
		('H007','2011-02-18'),('H008','2012-10-25'),('H009','2015-04-14'),('H010','2017-12-25');

insert into staffSalary
values ('SR0002','S001',2014,03,5,43000),('SR0003','S007',2014,05,4,30000),('SR0004','S006',2015,08,6,38000),
		('SR0005','S005',2015,10,3,40000),('SR0006','S009',2016,12,1,35000),('SR0007','S001',2016,05,4,43000),
		('SR0008','S009',2017,04,7,30000),('SR0009','S002',2018,09,0,32000),('SR0010','S004',2019,08,1,40000);

insert into staffAttendance
values ('SA00003','S002','2018-04-13',0,'04',2018),('SA0004','S003','2018-04-14',0,'04',2018),
		('SA00005','S003','2018-04-15',0,'04',2018),('SA0006','S002','2018-04-16',0,'04',2018),
		('SA00007','S005','2018-04-17',0,'04',2018),('SA0008','S006','2018-04-17',1,'04',2018),
		('SA00009','S007','2018-04-18',0,'04',2018),('SA0010','S007','2018-04-19',0,'04',2018);

insert into book
values ('B002','The Great Gatsby books','236-2365-259-26','Fitzgerald','Lyca Publisher',6),
		('B003','The Hobbit','236-2365-259-27','John','Lyca Publisher',4),
		('B004','The Histroy of Sri Lanka','236-2365-259-28','Namal','Astan Publisher',15),
		('B005','The Wonder of Asia','236-2365-259-36','Gandi','Lyca Publisher',10),
		('B006','The Europe','236-2365-259-32','Michel','Lyca Publisher',2),
		('B007','Lord of The Ring','236-2365-259-40','Vimal','Lulu Publisher',3),
		('B008','The Sherk','236-2365-259-65','Willam','Lyca Publisher',12),
		('B009','Fast Five','236-2365-259-60','Paul Walker','Astan Publisher',1),
		('B010','Peter','236-2365-259-80','Peter','Lyca Publisher',14);

insert into rental
values ('B002','M0002','2016-04-10','2016-04-26','2016-04-24',2,20,'submitted'),
		('B003','M0003','2016-04-10','2016-04-26','2016-04-24',2,20,'submitted'),
		('B004','M0004','2016-04-10','2016-04-26','2016-04-24',2,20,'submitted'),
		('B005','M0005','2016-04-10','2016-04-26','2016-04-24',2,20,'submitted'),
		('B006','M0006','2016-04-10','2016-04-26','2016-04-24',2,20,'submitted'),
		('B007','M0001','2016-04-10','2016-04-26','2016-04-24',2,20,'submitted'),
		('B008','M0002','2016-04-10','2016-04-26','2016-04-24',2,20,'submitted'),
		('B008','M0009','2016-04-10','2016-04-26','2016-04-24',2,20,'submitted'),
		('B010','M0005','2016-04-10','2016-04-26','2016-04-24',2,20,'submitted');

insert into hostelPayment
values ('HP0002','H002',2015,8,5000,'P','2015-09-05'),('HP0003','H003',2015,8,5000,'P','2015-09-06'),
		('HP0004','H004',2015,8,5000,'P','2015-09-10'),('HP0005','H005',2015,8,5000,'P','2015-09-15'),
		('HP0006','H006',2015,8,5000,'P','2015-09-25'),('HP0007','H007',2015,8,5000,'P','2015-09-20'),
		('HP0008','H008',2015,8,5000,'P','2015-09-21'),('HP0009','H009',2015,8,5000,'P','2015-09-10');

insert into studentAttendance
values('A00002','10001','2015-11-24',1),('A00003','10001','2015-11-25',1),('A00004','10001','2015-11-26',1),
		('A00005','10001','2015-11-27',0),('A00006','10001','2015-11-28',1),('A00007','10001','2015-11-29',1),
		('A00008','10001','2015-11-30',1),('A00009','10001','2015-12-01',1),('A00010','10001','2015-12-02',1);

insert into noticeBoard
values('N002',1,1,'2018-10-11','11.00 AM','Main Hall','Prefect Meeting'),
		('N003',1,0,'2018-10-15','11.00 AM','Main Hall','Prize Day Meeting'),
		('N004',1,1,'2018-10-19','11.00 AM','Main Hall','Monitor Meeting'),
		('N005',1,1,'2018-10-25','11.00 AM','Main Hall','OL Farewell'),
		('N006',1,0,'2018-11-11','11.00 AM','Main Hall','Staff Meeting Meeting'),
		('N007',1,0,'2018-11-14','11.00 AM','Main Hall','Parents Meeting'),
		('N008',1,0,'2018-11-25','11.00 AM','Main Hall','Prefect Meeting'),
		('N009',1,1,'2018-12-01','11.00 AM','Main Hall','Prize Day'),
		('N010',1,1,'2018-12-05','11.00 AM','Main Hall','Sport Meet Discuss');

insert into payment
values('PM0002','10001','E',170,'2018-06-12');
--E:examFee
--A:anualFee

insert into result
values('10002','E001','SB02',70),('10002','E001','SB03',53),('10002','E001','SB04',72),('10002','E001','SB05',48),
		('10002','E002','SB04',80),('10002','E001','SB07',83),('10002','E001','SB06',65),('10002','E001','SB08',89);

insert into examHall
values('E001','10A',4);

insert into examHallArrang
values('E001','10A','S002');