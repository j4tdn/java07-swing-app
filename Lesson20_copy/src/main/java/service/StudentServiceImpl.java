/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.StudentDao;
import dao.StudentDaoImpl;
import java.util.List;
import model.bean.Student;
import model.bean.Grade;

/**
 *
 * @author ADMIN
 */
public class StudentServiceImpl implements StudentService{
    private final StudentDao studentDao; // thuoc tinh final thi phai khoi tao doi tuong
    
    public StudentServiceImpl(){
        studentDao=new StudentDaoImpl();
    }
    @Override
    public List<Student> getAll() {
        return studentDao.getAll();
    }

    @Override
    public Student get(String id) { 
        return studentDao.get(id);
    }
    
    @Override
    public boolean updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public int addStudent(Student student) {
        return studentDao.addStudent(student);
    }
}
