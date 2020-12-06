/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import service.*;
import java.util.List;
import model.bean.Grade;
import model.bean.Student;

/**
 *
 * @author ADMIN
 */
public interface StudentDao {

    List<Student> getAll();

    void addStudent(String id, String fullname, Boolean gender, String hobbies, Double math, Double literature, Grade gradeID, String avatarPath, String comments);

    List<Grade> getListGrade();
    Student get(String id);
}
