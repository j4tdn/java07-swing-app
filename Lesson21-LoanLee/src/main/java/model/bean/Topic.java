/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.Objects;

/**
 *
 * @author ADMIN
 */
public class Topic {

    private String id;
    private String question;
    private String answer;

    Topic() {

    }

    public Topic(String id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Topic)) {
            return false;
        }

        Topic that = (Topic) obj;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getQuestion(), that.getQuestion());

    }

    @Override
    public String toString() {
        return id + "-" + question + "-" + answer;
    }

}
