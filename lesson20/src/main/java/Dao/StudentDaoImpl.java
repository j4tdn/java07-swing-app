/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.Student;
import model.been.Grade;

/**
 *
 * @author Admin
 */
public class StudentDaoImpl implements StudentDao{
    private final StudentDao studentDao;
    public StudentDaoImpl(){
        studentDao = new StudentDaoImpl(); 
        
    }
    
    private List<Student> mockData(){
//        List<Grade> grades = Arrays.asList(
//               new Grade(1, "Lớp 11T1");
//               new Grade(2, "Lớp 11T1");
//               new Grade(3, "Lớp 11T1");
//               new Grade(4, "Lớp 11T1");
//        )
        List<Student> student = new ArrayList<>();
        student.add(new Student("1","Le nhat phi", Boolean.TRUE, "Bóng Đá", 6.2d, 8.2d,null , "","coment"));
        student.add(new Student("2","Le nhat ", Boolean.TRUE, "Bóng Đá", 6.2d, 8.2d,null , "","comment"));
        student.add(new Student("3","Le phi", Boolean.TRUE, "Bóng Đá", 6.2d, 8.2d,null , "","comment"));
        student.add(new Student("4","nhat phi", Boolean.TRUE, "Bóng Đá", 6.2d, 8.2d,null, "","comment"));
        student.add(new Student("5","phi", Boolean.TRUE, "Bóng Đá", 6.2d, 8.2d,null , "",""));
        
        return student;
    }

    @Override
    public List<Student> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
