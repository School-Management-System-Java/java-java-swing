------------------------------------------------------------------------------
create procedure udpInsertUserAccount(@username varchar(20),@password varchar(20),@type char(1),@id varchar(10))
as
begin
	insert into userAccount
	values(@username,@password,@type);

	if(@type='S')
	begin
		update student
		set username=@username
		where student.studentID=@id
	end
	if(@type='T' or @type='L')
	begin
		update staff
		set username=@username
		where staff.staffID=@id
	end
end


----------------------------------------------------------------------
create procedure udpInsertStudent(@fName varchar(50),@lName varchar(50),@name varchar(30),@dob date,@gender char(1),@mobileNo varchar(10),@homePhone varchar(10),@email varchar(30),@joinedDate date)
as
begin
	declare @lastId varchar(10)
	declare @toAssignId varchar(10)
	select @lastId=studentID from student where studentID=(select MAX(studentID) from student)
	if(@lastId is null)
		set @toAssignId='10001'
	else
	begin
		declare @nextId int
		select @nextId=CAST(@lastId as int)
		set @nextId=@nextId+1
		select @toAssignId=CAST(@nextId as varchar)
	end

	
	insert into student(studentID,fName,lName,nameWithInitial,dob,gender,mobileNo,homePhone,email,joinedDate)
	values (@toAssignId,@fName,@lName,@name,@dob,@gender,@mobileNo,@homePhone,@email,@joinedDate);
end

--------------------------------------------------------------------------------------
create procedure udpUpdateStudent(@studentID varchar(10),@fName varchar(50),@lName varchar(50),@name varchar(30),@dob date,@gender char(1),@mobileNo varchar(10),@homePhone varchar(10),@email varchar(30),@joinedDate date)
as
begin
	update student
	set fName=@fName, lName=@lName, nameWithInitial=@name, dob=@dob, gender=@gender, mobileNo=@mobileNo, homePhone=@homePhone, email=@email, joinedDate=@joinedDate
	where studentID=@studentID
end

----------------------------------------------------------------------------------------
create procedure udpUpdateUserAccount(@username varchar(20),@password varchar(20))
as
begin
	update userAccount
	set password=@password
	where username=@username
end

------------------------------------------------------------------------------------------
create procedure udpDeleteUserAccount(@username varchar(20))
as
begin
	delete from userAccount
	where username=@username;
end

-------------------------------------------------------------------------
create procedure udpaddClass(@classID varchar(5),@name varchar(20))
as
begin 
	insert into class
	values(@classID,@name);
end

----------------------------------------------------------------------------
create procedure udpaddclassstaffsubject(@classID varchar(5),@staffID varchar(10),@subjectID varchar(5))
as
begin 
	insert into class_staff_subject
	values(@classID,@staffID,@subjectID);
end

----------------------------------------------------------------------------
--Parent details 
CREATE PROCEDURE UDParentDetail(@ParentID VARCHAR (10) ,@Name VARCHAR(50),@Address VARCHAR(50) 
		,@Email VARCHAR(50),@Occupation VARCHAR(20),@DateOfBirth DATE,@Gender CHAR(1),@phoneNo1 varchar(10)
		,@phoneNo2 varchar(10),@studentID varchar(10))
AS 
BEGIN
		INSERT INTO parent 
		VALUES (@ParentID,@Name,@Address,@Email,@Occupation,@DateOfBirth,@Gender,@phoneNo1,@phoneNo2)
		Update student
		set ParentID=@ParentID
		where studentID=@studentID
END


----------------------------------------------------------------Notice Board details
CREATE PROCEDURE UDNoticeDetail(@noticeID VARCHAR (10) ,@staff bit,@student bit 
		,@PublishedDate date,@time VARCHAR(20),@venue VARCHAR(50),@topic varchar(50))
AS 
BEGIN
		INSERT INTO noticeBoard 
		VALUES (@noticeID,@staff,@student,@PublishedDate,@time,@venue,@topic)
END
