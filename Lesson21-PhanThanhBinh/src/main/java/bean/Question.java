/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Objects;

/**
 *
 * @author OS
 */
public class Question {

    private String questionId;
    private String question;
    private String answer;
    private String topicId;

    public Question() {

    }

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public Question(String questionId, String question, String answer) {
        this.questionId = questionId;
        this.question = question;
        this.answer = answer;
    }

    public Question(String questionId, String question, String answer, String topicId) {
        this.questionId = questionId;
        this.question = question;
        this.answer = answer;
        this.topicId = topicId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
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

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuestionId());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Question other = (Question) obj;
        return this.questionId.equals(getQuestionId());
    }

}
