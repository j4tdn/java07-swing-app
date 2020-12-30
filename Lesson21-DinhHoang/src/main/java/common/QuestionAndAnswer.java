/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author DangHoang
 */
public enum QuestionAndAnswer {

    SLEEP("What is superpower make SO better ?"),
    HEALTH("What is the best thing in your life ?"),
    SALARY("Why did SO leave their last job ?"),
    STAMP("What can travel around the world while staying in a corner ?"),
    CANDEL("I'm tall when I'm young and I'm short when I'm old. What am I ?");

    private final String value;

    QuestionAndAnswer(String value) {
        this.value = value;
    }

    public String getQuestion() {
        return value;
    }
}
