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
 * @author OS
 */
public class StudentDaoImpl implements StudentDao{

    @Override
    public List<Student> getAll() {
        return mockData();
    }
    
    private List<Student> mockData() {
        List<Grade> grades = Arrays.asList(
                new Grade(1, "17T1"),
                new Grade(2, "17T2"),
                new Grade(3, "17T3"),
                new Grade(4, "17T4"));
        List<Student> students = new ArrayList<>();
        students.add(new Student("102", "Le Na", Boolean.TRUE, "Bóng đá, bóng chuyền", 8.2d, 8.2d, grades.get(0), "", "học ngu"));
        students.add(new Student("103", "Xuân Nguyệt", Boolean.FALSE, "Bóng đá, bóng chuyền", 8.2d, 8.2d, grades.get(1), "", "học ngu"));
        students.add(new Student("104", "Phan A", Boolean.TRUE, "Bóng đá, bóng chuyền", 8.2d, 8.2d, grades.get(2), "", "học ngu"));
        return students;
    }
    
}
