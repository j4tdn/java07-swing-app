/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.beans.Grade;
import model.beans.Student;

/**
 *
 * @author DangHoang
 */
public interface StudentService {

    List<Student> getAll();
    
    List<Grade> getGrade();

    boolean addStudent(Student student);

    boolean updateStudent(Student student);

//    Student getStudent(String id);
}