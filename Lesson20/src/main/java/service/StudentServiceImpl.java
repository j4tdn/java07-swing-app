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
 * @author OS
 */
public class StudentServiceImpl implements StudentService{
    
    private final StudentDao studentDao;
    
    public StudentServiceImpl() {
        studentDao = new StudentDaoImpl();
    }

    @Override
    public List<Student> getAll() {
        return studentDao.getAll();
    }

    @Override
    public int insert(String fullname, Boolean gender, String hobbies, Double math, Double literature, Grade grade, String avartarPath, String comment) {
        return studentDao.insert(fullname, gender, hobbies, math, literature, grade, avartarPath, comment);
    }

    @Override
    public int update(int id, String fullname, Boolean gender, String hobbies, Double math, Double literature, Grade grade, String avartarPath, String comment) {
        return studentDao.insert(fullname, gender, hobbies, math, literature, grade, avartarPath, comment);
    }

    @Override
    public Student get(int id) {
        return studentDao.get(id);
    }

    @Override
    public boolean save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public boolean update(Student student) {
        return studentDao.update(student);
    }
    
}
