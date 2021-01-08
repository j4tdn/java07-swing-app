/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import beans.Question;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import utils.ConfigurationProvider;

/**
 *
 * @author DangHoang
 */
public class ProcessingQuestionsAndAnswers {

    private final List<Question> questions;
    private final ConfigurationProvider config;
    private Properties pro;

    public ProcessingQuestionsAndAnswers() {
        questions = new ArrayList<>();
        config = new ConfigurationProvider();
    }

    public List<Question> getAllQuestionsInTheTopic(String topic) {
        pro = config.getProperties(topic);
        Set set = pro.entrySet();
        Iterator itr = set.iterator();
        int id = 0;
        while (itr.hasNext()) {
            Map.Entry entry = (Map.Entry) itr.next();
            Question question = new Question(id++, (String) entry.getValue(), (String) entry.getKey());
            questions.add(question);
        }
        return questions;
    }
}
