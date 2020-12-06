use qlsv;

 -- thêm -- 
INSERT INTO student (idStudent, fullName, hobbies,mathl, literature,avatarPath,comments,idGrade,greder) VALUES('1', 'phi', 'Đá Bóng','5','5','null','giỏi','1',1) ;
INSERT INTO student (idStudent, fullName, hobbies,mathl, literature,avatarPath,comments,idGrade,greder) VALUES('2', 'lê', 'Bóng Chuyền','6','5','null','giỏi','1',0) ;
INSERT INTO student (idStudent, fullName, hobbies,mathl, literature,avatarPath,comments,idGrade,greder) VALUES('3', 'nhật', 'Bóng Chuyền','9','5','null','giỏi','2',0) ;
INSERT INTO student (idStudent, fullName, hobbies,mathl, literature,avatarPath,comments,idGrade,greder) VALUES('4', 'hoàng', 'Cầu Lông','2','5','null','khá','2',1) ;
INSERT INTO student (idStudent, fullName, hobbies,mathl, literature,avatarPath,comments,idGrade,greder) VALUES('5', 'huyền', 'Bóng Chuyền','6','5','null','giỏi','3',1) ;
INSERT INTO student (idStudent, fullName, hobbies,mathl, literature,avatarPath,comments,idGrade,greder) VALUES('6', 'hải', 'Đá Bóng','1','5','null','trung bình','4',0) ;
INSERT INTO student (idStudent, fullName, hobbies,mathl, literature,avatarPath,comments,idGrade,greder) VALUES('7', 'hùng', 'Cầu Lông','8','5','null','giỏi','5',1) ;

    -- cập nhật --
UPDATE student Set fullName = 'Hồng' where fullname ='hải';
	-- xoá --
DELETE FROM student where idStudent='1';

    -- Get student --
SELECT * from student ;
	
    -- Get Grader --
SELECT * from grader;