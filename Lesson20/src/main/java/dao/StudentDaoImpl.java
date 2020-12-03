/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.bean.Grade;
import model.bean.Student;

/**
 *
 * @author khanh
 */
public class StudentDaoImpl implements StudentDao{

    @Override
    public List<Student> getAll() {
        return mockData();
    }
    
    private List<Student> mockData(){
        List<Grade> grades = Arrays.asList(new Grade(1, "Lớp 11"),new Grade(2, "Lớp 12"));
        List<Student> students = new ArrayList<>();
        students.add(new Student("102", "Hồ Khanh", Boolean.TRUE, "Game", 8.2d, 6.7d, grades.get(0), "", "Comment"));
        students.add(new Student("103", "Hoàng", Boolean.TRUE, "Game", 8.2d, 6.7d, grades.get(0), "", "Comment"));
        return students;
    }
    
}
