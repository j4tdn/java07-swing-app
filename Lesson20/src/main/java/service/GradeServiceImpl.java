/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.GradeDao;
import dao.GradeDaoImpl;
import java.util.List;
import model.bean.Grade;

/**
 *
 * @author USER
 */
public class GradeServiceImpl implements GradeService{
    
    private final GradeDao gradeDao;

    public GradeServiceImpl() {
        gradeDao = new GradeDaoImpl();
    }

    @Override
    public List<Grade> getAll() {
        return gradeDao.getAll();
    }
    
}
