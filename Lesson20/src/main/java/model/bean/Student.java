/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author USER
 */
public class Student {

    private Integer id;
    private String fullname;
    private Boolean gender;
    private String Hobbies;
    private Double math;
    private Double literature;
    private Grade grade;
    private String avatarPath;
    private String comment;

    public Student() {
    }

    public Student(Integer id, String fullname, Boolean gender, String Hobbies, Double math, Double literature, Grade grade, String avatarPath, String comment) {
        this.id = id;
        this.fullname = fullname;
        this.gender = gender;
        this.Hobbies = Hobbies;
        this.math = math;
        this.literature = literature;
        this.grade = grade;
        this.avatarPath = avatarPath;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getHobbies() {
        return Hobbies;
    }

    public void setHobbies(String Hobbies) {
        this.Hobbies = Hobbies;
    }

    public Double getMath() {
        return math;
    }

    public void setMath(Double math) {
        this.math = math;
    }

    public Double getLiterature() {
        return literature;
    }

    public void setLiterature(Double literature) {
        this.literature = literature;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", fullname=" + fullname + ", gender=" + gender + ", Hobbies=" + Hobbies + ", math=" + math + ", literature=" + literature + ", grade=" + grade + ", avatarPath=" + avatarPath + ", comment=" + comment + '}';
    }

}
