/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.bean.Grade;
import model.bean.Student;

/**
 *
 * @author ADMIN
 */
public interface StudentService {

    List<Student> getAll();

    List<Grade> getListGrade();

    Student get(String id);

    int addStudent(Student student);
    boolean updateStudent(Student student);
}
