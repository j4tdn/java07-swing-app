/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Dao.StudentDao;
import Dao.StudentDaoImpl;
import java.util.List;
import model.been.Student;

/**
 *
 * @author Admin
 */
public class StudentServiceImpl implements StudentService{
    private final StudentDao studentDao;
    public StudentServiceImpl(){
        studentDao = new StudentDaoImpl(); 
    }
    @Override
    public List<Student> getAll() {
        return studentDao.getAll();
    }

    @Override
    public List<Student> get(String id) {
        return studentDao.get(id);
    }
    
}
