CREATE DATABASE java07_student DEFAULT CHAR SET utf8;
use java07_student;

    
create table Student
(ID varchar(20) primary key not null,
Fullname varchar(20),
Gender boolean,
Hobbies text,
Math double,
Literature double,
GradeID int,
AvatarPath text,
`Comment` text,
constraint FK foreign key (GradeID) references Grade(ID)
);

create table Grade(
ID int not null,
GradeName varchar(20) not null,
primary key(ID,GradeName)
);

drop table Grade;
drop table Student;
insert into Grade values(1,"Lớp 12T1"),
(2,"Lớp 12T2"),
(3,"Lớp 12T3"),
(4,"Lớp 12T4"),
(5,"Lớp 12T5");

insert into Student(ID ,Fullname,Gender,Hobbies,Math ,Literature ,GradeID ,AvatarPath ,`Comment`) 
values(1, "Le Minh", 1, "Bóng đá,Bóng chuyền", 1.2, 5.5,1, "", "Comments"),
(2, "Thanh Thao",1,"Bóng đá,Bóng chuyền", 5, 1.5, 3, "", "Comments"),
(3, "Tran An",0,"Bóng đá,Bóng chuyền", 1.5, 2.3,4, "", "Comments"),
(4, "Gia Linh",1,"Bóng đá,Bóng chuyền,Cầu lông", 2.3, 3.5, 5, "", "Comments")
;
insert into Student(ID ,Fullname,Gender,Hobbies,Math ,Literature ,GradeID ,AvatarPath ,`Comment`) value(9,"sas",false,"",22.0,2.0,2,"/images/48px_like.png","");
delete from student where Fullname="sas";
select *from grade;
select *from student;
update Grade set GradeName="Lớp 12T4" where id=49