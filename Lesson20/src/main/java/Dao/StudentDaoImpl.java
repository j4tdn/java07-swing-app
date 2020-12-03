/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.bean.Grade;
import model.bean.Student;

/**
 *
 * @author Asus
 */
public class StudentDaoImpl implements StudentDao{

    @Override
    public List<Student> getAll() {
        return mockData();
    }
    
    private List<Student> mockData(){
        List<Grade> grades = Arrays.asList(
                new Grade(1, "Lớp 11T1"),
                new Grade(2, "Lớp 11T2"),
                new Grade(3, "Lớp 11T3"),
                new Grade(4, "Lớp 11T4")
        );
        
        List<Student> students = new ArrayList<>();
        students.add(new Student("102","Hoang Van", Boolean.TRUE,"Bóng Đá", 1d, 6.6d, grades.get(0),"", ""));
        students.add(new Student("103","Hoang Van Khanh", Boolean.TRUE,"Bóng Truyền", 2d, 6.6d, grades.get(1),"", ""));
        students.add(new Student("104","Hoang Thi Thuy", Boolean.TRUE,"Bóng Đá", 13d, 6.6d, grades.get(2),"", ""));
        students.add(new Student("105","Khanh Hoang Van", Boolean.TRUE,"Bóng Đá", 36d, 6.6d, grades.get(0),"", ""));
        students.add(new Student("106","Ngo Tat To", Boolean.TRUE,"Bóng Đá", 44d, 6.6d, grades.get(3),"", ""));
        return students;
    }
    
}
