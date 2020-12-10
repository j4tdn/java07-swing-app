/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.bean.Student;

/**
 *
 * @author USER
 */
public interface StudentService {
    List<Student> getAll();
    
    Student getStudent(int id);
    
    boolean save(Student student);
}
