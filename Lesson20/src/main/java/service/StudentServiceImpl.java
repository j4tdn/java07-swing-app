/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.StudentDao;
import dao.StudentDaoImpl;
import java.util.List;
import model.bean.Grade;
import model.bean.Student;

/**
 *
 * @author ADMIN
 */
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;

    public StudentServiceImpl() {
        studentDao = new StudentDaoImpl();
    }

    @Override
    public List<Student> getAll() {

        return studentDao.getAll();
    }

    @Override
    public void addStudent(String id,String fullname,Boolean gender,String hobbies, Double math,Double literature,Grade gradeID,String avatarPath,String comments){   studentDao.addStudent(id,fullname,gender,hobbies,math,literature,gradeID,avatarPath,comments);
    }

    @Override
    public List<Grade> getListGrade() {
        return studentDao.getListGrade();
    }

    @Override
    public Student get(String id) {
         return studentDao.get(id);
    }

}
