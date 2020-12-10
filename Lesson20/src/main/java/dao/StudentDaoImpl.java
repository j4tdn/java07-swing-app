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
 * @author ADMIN
 */
public class StudentDaoImpl implements StudentDao {

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
        students.add(new Student("102", "Le Na", Boolean.TRUE, "Bóng đá, Bóng chuyền", 8.2d, 7.8d, grades.get(0), "", "Comment"));
        students.add(new Student("103", "Le Thanh", Boolean.FALSE, "Bóng chuyền", 8.2d, 8.8d, grades.get(1), "", "Comment"));
        students.add(new Student("104", "Le Lien", Boolean.TRUE, "Bóng đá, Bóng chuyền", 8.6d, 7.8d, grades.get(2), "", "Comment"));
        students.add(new Student("105", "Le Hung", Boolean.FALSE, "Bóng đá", 8.2d, 9.8d, grades.get(0), "", "Comment"));
        return students;
    }

    @Override
    public Student get(String id) {
        List<Student> students = mockData();
        return students.stream().filter(student -> id.equals(student.getId())) // filter tra ve stream
                .findFirst() // find first tra ve optional(co hoac khong)
                .orElse(null);
    }
}
