/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.beans.Grade;
import model.beans.Student;
import model.beans.StudentRaw;

/**
 *
 * @author DangHoang
 */
public interface StudentDao {
    
    List<StudentRaw> getAll();
    
    List<Grade> getGrade();

    boolean addStudent(Student student);

    boolean updateStudent(Student student);

//    StudentRaw getStudent(String id);
}