/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import bean.Question;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author OS
 */
public class QuestionDaoImpl implements QuestionDao{

    @Override
    public List<Question> getAll() {
        List<Question> questions = new ArrayList<>();
        
        Question question1 = new Question("q1", "Who is dog?", "Long");
        Question question2 = new Question("q2","Who is pro player?", "Binh");
        Question question3 = new Question("q3","Who is best Java?", "Bin");
        Question question4 = new Question("q4","Who is best Lucian?", "Binh");
        
        questions.addAll(Arrays.asList(question1, question2, question3, question4));
        
        return questions;
    }
    
    public Question getQuestionById(String questionId) {
        return getAll().stream().filter(question -> question.getQuestionId().equals(questionId)).findAny().orElse(null);
    }
    
}
