CREATE DATABASE java07_student DEFAULT CHAR SET utf8;
use java07_student;

    
create table Student
(ID int primary key not null,
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
GradeName varchar(10) not null,
primary key(ID,GradeName)
);

drop table Grade;drop table Student;
insert into Grade values(1,"Lớp 12T1"),
(2,"Lớp 12T2"),
(3,"Lớp 12T3"),
(4,"Lớp 12T4");

insert into Student(ID ,Fullname,Gender,Hobbies,Math ,Literature ,GradeID ,AvatarPath ,`Comment`) 
values(1, "Le S", 1, "bóng đá", 1.2, 5.5,1, "", "Comments"),
(2, "Le A",1,"bóng đá ,bóng chuyền", 5, 1.5, 2, "", "Comments"),
(3, "Le B",0,"bóng đá ,bóng chuyền", 1.5, 2.3,4, "", "Comments"),
(4, "le V",1,"bóng đá ,bóng chuyền", 2.3, 3.5, 2, "", "Comments")
;
select *from grade;
select *from student;
update Grade set GradeName="Lớp 12T4" where id=4;