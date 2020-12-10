/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.beans;

/**
 *
 * @author Asus
 */
public class StudentRaw {
    private String id;
    private String name;
    private String grade;
    private Boolean gender;
    private String bobbies;
    private Float math;
    private Float literature;
    private String comment;
    private String imagePath;

    public StudentRaw() {
    }

    public StudentRaw(String id, String name, String grade, Boolean gender, String bobbies, Float math, Float literature, String comment, String imagePath) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.gender = gender;
        this.bobbies = bobbies;
        this.math = math;
        this.literature = literature;
        this.comment = comment;
        this.imagePath = imagePath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getBobbies() {
        return bobbies;
    }

    public void setBobbies(String bobbies) {
        this.bobbies = bobbies;
    }

    public Float getMath() {
        return math;
    }

    public void setMath(Float math) {
        this.math = math;
    }

    public Float getLiterature() {
        return literature;
    }

    public void setLiterature(Float literature) {
        this.literature = literature;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    
}
