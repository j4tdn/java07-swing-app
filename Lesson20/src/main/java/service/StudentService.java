/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.beans.Student;
import model.beans.Grade;

/**
 *
 * @author Asus
 */
public interface StudentService {
    List<Student> getAll();
    
     List<Grade> getGrade();

    boolean addStudent(Student student);

    boolean updateStudent(Student student);
    
}
