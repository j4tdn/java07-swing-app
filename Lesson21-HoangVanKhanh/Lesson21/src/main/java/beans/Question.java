/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Asus
 */
public class Question {
    private int id;
    private String questions;
    private String answer;

    public Question() {
    }

    public Question(int id, String questions, String answer) {
        this.id = id;
        this.questions = questions;
        this.answer = answer;
    }
    
    

    public int getId() {
        return id;
    }

    public String getQuestions() {
        return questions;
    }

    public String getAnswer() {
        return answer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    
}
