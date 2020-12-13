/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.bean.Grade;
import model.bean.Student;

/**
 *
 * @author khanh
 */
public interface StudentDao {
    List<Student> getAll();
    List<Grade> getAllGrade();
    Integer addStudent(Student student);
    Student get(String id);
    boolean updateStudent(Student student);
    boolean deleteStudent(Student student);
}
