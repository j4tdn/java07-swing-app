/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.bean.Student;

/**
 *
 * @author USER
 */
public interface StudentDao {
    List<Student> getAll();
    
    boolean save(Student student);
    
    Student getStudent(int id);
    
    boolean update(Student student);
    
    boolean delete(int id);
}
