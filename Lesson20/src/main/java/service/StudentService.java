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
 * @author OS
 */
public interface StudentService {
    List<Student> getAll();
    int insert(String fullname, Boolean gender, String hobbies, Double math, Double literature, Grade grade, String avartarPath, String comment);
    int update(int id, String fullname, Boolean gender, String hobbies, Double math, Double literature, Grade grade, String avartarPath, String comment);
    Student get(int id);
}
