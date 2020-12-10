/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.StudentDao;
import dao.StudentDaoImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import model.beans.Grade;
import model.beans.Student;
import model.beans.StudentRaw;

/**
 *
 * @author DangHoang
 */
public class StudentServiceImpl implements StudentService {

    private final StudentDao dao;
    private List<Grade> grade;

    public StudentServiceImpl() {
        dao = new StudentDaoImpl();
    }

    @Override
    public List<Student> getAll() {
        List<StudentRaw> studentsRaw = dao.getAll();
        grade = getGrade();
        List<Student> students = new ArrayList<>();
        studentsRaw.forEach(s -> {
            students.add(new Student(s, grade.stream().filter(g -> g.getId().equals(s.getGrade()))
                    .collect(Collectors.toList()).get(0)));
        });
        return students;
    }

    @Override
    public List<Grade> getGrade() {
        return dao.getGrade();
    }

    @Override
    public boolean addStudent(Student student) {
        return dao.addStudent(student);
    }

    @Override
    public boolean updateStudent(Student student) {
        return dao.updateStudent(student);
    }

//    @Override
//    public Student getStudent(String id) {
//        StudentRaw studentRaw = dao.getStudent(id);
//        return new Student(studentRaw, grade.stream().filter(g -> g.getId().equals(studentRaw.getGrade()))
//                    .collect(Collectors.toList()).get(0));
//    }
}
