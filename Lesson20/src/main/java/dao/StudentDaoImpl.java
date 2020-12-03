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
 * @author USER
 */
public class StudentDaoImpl implements StudentDao{

    @Override
    public List<Student> getAll() {
        // mock data
        return mockData();
    }
    
    private List<Student> mockData() {
        List<Grade> grades = Arrays.asList(
                new Grade(1, "11T1"),
                new Grade(2, "11T2"),
                new Grade(3, "11T3")
        );
        List<Student> students = new ArrayList<>();
        students.add(new Student("102", "Lê Na", Boolean.TRUE, "Bóng rổ, Bóng cười", 1d, 8.0d, grades.get(0), "", "comment"));
        students.add(new Student("203", "Nguyễn A", Boolean.FALSE, "Bóng rổ, Bóng cười", 2d, 8.0d, grades.get(1), "", "comment"));
        students.add(new Student("104", "Thị D", Boolean.TRUE, "Bóng rổ, Bóng cười", 13d, 8.0d, grades.get(2), "", "comment"));
        students.add(new Student("207", "Văn E", Boolean.TRUE, "Bóng rổ, Bóng cười", 24d, 8.0d, grades.get(1), "", "comment"));
        
        return students;
    }
    
}
