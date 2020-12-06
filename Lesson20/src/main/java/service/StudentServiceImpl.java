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

/**
 *
 * @author USER
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
    public Student getStudent(int id) {
        return studentDao.getStudent(id);
    }

}
