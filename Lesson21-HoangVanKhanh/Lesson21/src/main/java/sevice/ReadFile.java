/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevice;

import beans.Question;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import javax.swing.text.html.HTMLDocument;
import utils.ConfigureProvider;

/**
 *
 * @author Asus
 */
public class ReadFile {
    private List<Question> questions;
    private final ConfigureProvider config;
    private Properties prope;

    public ReadFile() {
        config = new ConfigureProvider();
        questions = new ArrayList<>();
        
    }
    public List<Question> getAllQuestions(String topic){
        
        prope = config.getProperties(topic);
        
        Set set = prope.entrySet();
        Iterator iter =set.iterator();
        int id =0;
        while (iter.hasNext()) {
            Map.Entry entry =(Map.Entry) iter.next();
            Question question = new Question(id++, (String)entry.getValue(), (String)entry.getKey());
            questions.add(question);
            
            
        }
        System.out.println(questions.size());
        return questions;
    }
    
    
}
