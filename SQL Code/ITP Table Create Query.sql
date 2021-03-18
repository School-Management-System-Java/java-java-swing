 --Database name
create database
ITP_Project


--create table queries
create table class(
	classID varchar(5),
	name varchar(20) unique,
	constraint PK_class primary key(classID)
)

create table exam(
	examID varchar(5),
	year int,
	grade int,
	term int,
	startDate date,
	endDate date,
	constraint PK_exam primary key(examID)
)

create table parent(
	parentID varchar(10),
	name varchar(50) not null,
	address varchar(50),
	email varchar(50) unique,
	occupation varchar(20),
	dob date,
	gender char(1) not null,
	phoneNo1 varchar(10),
	phoneNo2 varchar(10),
	constraint PK_parent primary key(parentID)
)

create table subject(
	subjectID varchar(5),
	name varchar(50) unique not null,
	constraint PK_subject primary key(subjectID)
)

create table member(
	memberID varchar(10),
	registeredDate varchar(25),
	typez varchar(25),
	constraint PK_member primary key(memberID)
)

create table hostel(
	hostelMemID varchar(5),
	registeredDate date,
	constraint PK_hostel primary key(hostelMemID)
)

create table userAccount(
	username varchar(20),
	password varchar(50) not null,
	type char(1) not null,
	constraint PK_userAccount primary key(username)
)

create table student(
	studentID varchar(10),
	fName varchar(50),
	lName varchar(50) not null,
	nameWithInitial varchar(30),
	dob date not null,
	gender char(1) not null,
	mobileNo varchar(10),
	homePhone varchar(10),
	email varchar(30) unique,
	joinedDate date,
	classID varchar(5),
	parentID varchar(10) default null,
	username varchar(20) default null,
	libMemID varchar(10) default null,
	hostelID varchar(5) default null,
	constraint PK_student primary key(studentID),
	constraint FK_studentClassID foreign key(classID) references class(classID) on delete set default on update cascade,
	constraint FK_studentParentID foreign key(parentID) references parent(parentID) on delete set default on update cascade,
	constraint FK_studentUsername foreign key(username) references userAccount(username) on delete set default on update cascade,
	constraint FK_studentLibMemID foreign key(libMemID) references member(memberID) on delete set default on update cascade,
	constraint FK_studentHostelID foreign key(hostelID) references hostel(hostelMemID) on delete set default on update cascade
)

create table staff(
	staffID varchar(10),
	name varchar(50) not null,
	address varchar(50),
	dob date,
	mobileNo varchar(10) not null,
	joinedDate date,
	perDayRate int,
	fullSalary int,
	Type char(1) not null,
	username varchar(20),
	libMemID varchar(10) default null,
	hostelID varchar(5) default null,
	constraint PK_staff primary key(staffID),
	constraint FK_staffUsername foreign key(username) references userAccount(username) on delete set default on update cascade,
	constraint FK_staffLibMemID foreign key(libMemID) references member(memberID) on delete set default on update cascade,
	constraint FK_staffHostelID foreign key(hostelID) references hostel(hostelMemID) on delete set default on update cascade
)

create table staff_subject(
	staffID varchar(10),
	subjectID varchar(5),
	constraint PK_staff_subject primary key (staffID,subjectID),
	constraint FK_staff_subjectStaffID foreign key(staffID) references staff(staffID) on delete cascade,
	constraint FK_staff_subjectSubjectID foreign key(subjectID) references subject(subjectID) on delete cascade
)

create table class_staff_subject(
	classID varchar(5),
	staffID varchar(10),
	subjectID varchar(5),
	constraint PK_class_staff_subject primary key(classID,staffID,subjectID),
	constraint FK_class_staff_subject foreign key(staffID,subjectID) references staff_subject(staffID,subjectID) on delete cascade,
	constraint FK_class_staff_subjectClassID foreign key(classID) references class(classID) on delete cascade
)

create table staffSalary(
	staffSalID varchar(12),
	staffID varchar(10),
	year int,
	month int,
	leaveDays int,
	finalSalary int,
	constraint PK_staffSalary primary key(staffSalID),
	constraint FK_salaryStaffID foreign key(staffID) references staff(staffID) on delete set default on update cascade
)

create table staffAttendance(
	staffAttendID varchar(8),
	staffID varchar(10),
	date varchar(20),
	halfDay bit,
	monthz varchar(50),
	year int,
	constraint PK_staffAttendance primary key(staffAttendID),
	constraint FK_attendanceStaffID foreign key(staffID) references staff(staffID) on delete set default on update cascade
)

create table book(
	bookID varchar(10),
	name varchar(50) not null,
	ISBN varchar(20) not null,
	autherName varchar(50),
	publisherName varchar(50),
	noOfCopies int,
	constraint PK_book primary key(bookID)
)

create table rental(
	bookID varchar(10),
	memberID varchar(10),
	borrowedDate varchar(50),
	returnDate varchar(50),
	dueDate varchar(50),
	lateDays int,
	fine int,
	statuz varchar(25),
	constraint FK_bookID foreign key(bookID) references book(bookID) on delete set default on update cascade,
	constraint FK_memberID foreign key(memberID) references member(memberID) on delete set default on update cascade
)

create table hostelPayment(
	hostelPayID varchar(10),
	hostelMemID varchar(5),
	year int,
	month int,
	amount int,
	status char(1) not null,
	paidDate date,
	constraint PK_hostelPayment primary key(hostelPayID),
	constraint FK_hostelMemID foreign key(hostelMemID) references hostel(hostelMemID) on delete set default on update cascade
)

create table studentAttendance(
	 studentAttendID varchar(8),
	 studentID varchar(10),
	 date date,
	 status bit,
	 constraint PK_studentAttendance primary key(studentAttendID),
	 constraint FK_attendanceStudentID foreign key(studentID) references student(studentID) on delete set default on update cascade
)

create table noticeBoard(
	noticeID varchar(10),
	staff bit,
	student bit,
	publishedDate date,
	time varchar(20),
	venue varchar(50),
	topic varchar(50),
	constraint PK_noticeBoard primary key(noticeID)
)

create table payment(
	paymentID varchar(6),
	studentID varchar(10),
	type char(1) not null,
	amount int,
	paidDate date,
	constraint PK_payment primary key(paymentID),
	constraint FK_paymentStudentID foreign key(studentID) references student(studentID) on delete set default on update cascade
)

create table result(
	studentID varchar(10),
	examID varchar(5),
	subjectID varchar(5),
	marks int,
	constraint PK_result primary key(studentID, examID, subjectID),
	constraint FK_resultStudentID foreign key(studentID) references student(studentID) on delete cascade,
	constraint FK_resultExamID foreign key(examID) references exam(examID) on delete cascade,
	constraint FK_resultSubjectID foreign key(subjectID) references subject(subjectID) on delete cascade
)

create table examHall(
	examID varchar(5),
	sectionID varchar(5),
	hallNo int,
	constraint PK_examHall primary key(examID,sectionID),
	constraint FK_hallExamID foreign key(examID) references exam(examID) on delete cascade
)

create table examHallArrang(
	examID varchar(5),
	sectionID varchar(5),
	staffID varchar(10)
	constraint PK_examHallArrang primary key(examID,sectionID,staffID),
	constraint FK_hallArrangExamID foreign key(examID,sectionID) references examHall(examID,sectionID) on delete cascade,
	constraint FK_hallArrangStaffID foreign key(staffID) references staff(staffID) on delete cascade
)

--drop tables
--drop table hostelPayment;
--drop table class_staff_subject
--drop table examHallArrang
--drop table examHall
--drop table noticeBoard
--drop table payment
--drop table rental
--drop table result
--drop table staff_subject,staffAttendance,staffSalary,studentAttendance,subject;
--drop table book;
--drop table student;
--drop table class
--drop table exam
--drop table staff;
--drop table parent
--drop table userAccount;
--drop table hostel
--drop table member