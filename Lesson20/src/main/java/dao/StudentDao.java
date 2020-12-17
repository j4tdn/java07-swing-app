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
 * @author OS
 */
public interface StudentDao {
    List<Student> getAll();
    int insert(String fullname, Boolean gender, String hobbies, Double math, Double literature, Grade grade, String avartarPath, String comment);
    boolean update(Student student);
    Student get(int id);
    boolean save(Student student);
}
