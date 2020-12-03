/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Asus
 */
public class Student {
    private String id;
    private String fullname;
    private Boolean gender;
    private String hobbies;
    private Double match;
    private Double literature;
    private Grade grade;
    private String avatarPatch;
    private String comment;

    public Student() {
    }

    public Student(String id, String fullname, Boolean gender, String hobbies, Double match, Double literature, Grade grade, String avatarPatch, String comment) {
        this.id = id;
        this.fullname = fullname;
        this.gender = gender;
        this.hobbies = hobbies;
        this.match = match;
        this.literature = literature;
        this.grade = grade;
        this.avatarPatch = avatarPatch;
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public Boolean getGender() {
        return gender;
    }

    public String getHobbies() {
        return hobbies;
    }

    public Double getMatch() {
        return match;
    }

    public Double getLiterature() {
        return literature;
    }

    public Grade getGrade() {
        return grade;
    }

    public String getAvatarPatch() {
        return avatarPatch;
    }

    public String getComment() {
        return comment;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public void setMatch(Double match) {
        this.match = match;
    }

    public void setLiterature(Double literature) {
        this.literature = literature;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public void setAvatarPatch(String avatarPatch) {
        this.avatarPatch = avatarPatch;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    
}
