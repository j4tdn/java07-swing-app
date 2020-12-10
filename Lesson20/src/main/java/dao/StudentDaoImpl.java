/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import model.bean.Grade;
import model.bean.Student;

/**
 *
 * @author qphan
 */
public class StudentDaoImpl implements StudentDao{

    @Override
    public List<Student> getAll() {
        // mock data
        return mockData();
    }
    
    private List<Student> mockData() {
        List<Grade> grades = Arrays.asList(
                new Grade(1, "Lớp 11T1"),
                new Grade(2, "Lớp 12T2"),
                new Grade(3, "Lớp 13T3"),
                new Grade(4, "Lớp 14T4")
        );
        List<Student> students = new ArrayList<>();
        students.add(new Student("102", "Le Na", Boolean.TRUE, "Bóng đá, Bóng chuyền", 1d, 7.8d, grades.get(0), "", "Comment"));
        students.add(new Student("203", "Thanh Tam", Boolean.FALSE, "Bóng đá, Bóng chuyền", 2d, 7.8d, grades.get(1), "", "Comment"));
        students.add(new Student("104", "Nguyen Hoang", Boolean.TRUE, "Bóng đá, Bóng chuyền", 13d, 9.8d, grades.get(0), "", "Comment"));
        students.add(new Student("207", "Dang Van", Boolean.TRUE, "Bóng đá, Bóng chuyền", 24d, 8.4d, grades.get(2), "", "Comment"));
        
        return students;
    }

    @Override
    public Student get(String id) {
        List<Student> students = mockData();
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst().orElse(null);
    }
    
    
    
}
