/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.StudentDao;
import dao.StudentDaoImpl;
import java.util.List;
import model.beans.Student;

/**
 *
 * @author DangHoang
 */
public class StudentServiceImpl implements StudentService {

    private final StudentDao dao;

    public StudentServiceImpl() {
        dao = new StudentDaoImpl();
    }

    @Override
    public List<Student> getAll() {
        return dao.getAll();
    }
}