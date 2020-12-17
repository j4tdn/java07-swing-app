/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.bean.Student;
import model.bean.Grade;

/**
 *
 * @author ADMIN
 */
public interface StudentDao {
    List<Student> getAll();
    Student get(String id);
    boolean updateStudent(String id, String fullname, int gender, String hobbies, Double math, Double literature, Grade grade, String avatarPath, String comment);
}

