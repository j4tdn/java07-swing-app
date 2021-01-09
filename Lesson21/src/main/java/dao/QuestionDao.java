/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import bean.Question;


/**
 *
 * @author OS
 */
public interface QuestionDao {
    List<Question> getAll();
    Question getQuestionById(String questionId);
}
