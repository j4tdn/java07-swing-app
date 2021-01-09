/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import beans.Question;
import config.ConfigurationProvider;
import config.ConfigurationProviderImpl;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author khanh
 */
public class QuestionServiceImpl implements QuestionService{
    
    private final ConfigurationProvider provider;
    
    public QuestionServiceImpl(){
        provider =new ConfigurationProviderImpl();
    }

    @Override
    public List<Question> getAllQuestionByTopic(String topic) {
        
        Properties properties = provider.getProperties(topic);
        Set<Map.Entry<Object,Object>> set =properties.entrySet();
        
        return set.stream().map(s->new Question((String) s.getValue() ,(String) s.getKey())).collect(Collectors.toList());   
    }

}
