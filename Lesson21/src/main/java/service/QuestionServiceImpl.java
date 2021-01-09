/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Question;
import dao.QuestionDao;
import dao.QuestionDaoImpl;
import java.util.List;

/**
 *
 * @author OS
 */
public class QuestionServiceImpl implements QuestionService{
    
    private final QuestionDao dao;
    
    public QuestionServiceImpl() {
        dao = new QuestionDaoImpl();
    }

    @Override
    public List<Question> getAll() {
        return dao.getAll();
    }

    @Override
    public Question getQuestionById(String questionId) {
        return dao.getQuestionById(questionId);
    }
    
}
