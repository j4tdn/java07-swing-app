/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.beans;

/**
 *
 * @author DangHoang
 */
public class Student {

    private String id;
    private String name;
    private Grade grade;
    private Boolean gender;
    private String bobbies;
    private Float math;
    private Float literature;
    private String comment;
    private String imagePath;

    public Student() {
    }

    public Student(StudentRaw studentRaw, Grade grade) {
        this.id = studentRaw.getId();
        this.name = studentRaw.getName();
        this.grade = grade;
        this.gender = studentRaw.getGender();
        this.bobbies = studentRaw.getBobbies();
        this.math = studentRaw.getMath();
        this.literature = studentRaw.getLiterature();
        this.comment = studentRaw.getComment();
        this.imagePath = studentRaw.getImagePath();
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

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
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