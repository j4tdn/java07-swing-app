/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import model.been.Student;
import model.been.Grade;

/**
 *
 * @author Admin
 */
public class StudentDaoImpl implements StudentDao {

    private final StudentDao studentDao;

    public StudentDaoImpl() {
        studentDao = new StudentDaoImpl();
    }

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
        List<Student> student = new ArrayList<>();
        student.add(new Student("1", "Le nhat phi", Boolean.TRUE, "Bóng Đá", 6.2d, 8.2d, grades.get(0), "", "coment"));
        student.add(new Student("2", "Le nhat ", Boolean.TRUE, "Bóng Đá", 6.2d, 8.2d, grades.get(1), "", "comment"));
        student.add(new Student("3", "Le phi", Boolean.TRUE, "Bóng Đá", 6.2d, 8.2d, grades.get(2), "", "comment"));
        student.add(new Student("4", "nhat phi", Boolean.TRUE, "Bóng Đá", 6.2d, 8.2d, grades.get(3), "", "comment"));
        student.add(new Student("5", "phi", Boolean.TRUE, "Bóng Đá", 6.2d, 8.2d, grades.get(1), "", "comment"));
        return student;
    }

//    @Override
//    public Optional<Student> get(String id) {
//        //SQL
//        List<Student> students = mockData();
//        return students.stream()
//                .filter(student -> students
////                .getId().equals(id)).findFirst().orElse(null);
//    }

    @Override
    public List<Student> get(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
