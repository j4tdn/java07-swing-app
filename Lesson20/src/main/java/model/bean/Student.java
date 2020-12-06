/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;


/**
 *
 * @author OS
 */
public class Student {
    private String id;
    private String fullname;
    private Boolean gender;
    private String hobbies;
    private Double math;
    private Double literature;
    private Grade grade;
    private String avartarPath;
    private String comment;
    
    public Student() {
        
    }

    public Student(String id, String fullname, Boolean gender, String hobbies, Double math, Double literature, Grade grade, String avartarPath, String comment) {
        this.id = id;
        this.fullname = fullname;
        this.gender = gender;
        this.hobbies = hobbies;
        this.math = math;
        this.literature = literature;
        this.grade = grade;
        this.avartarPath = avartarPath;
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
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

    public String getAvartarPath() {
        return avartarPath;
    }

    public void setAvartarPath(String avartarPath) {
        this.avartarPath = avartarPath;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", fullname=" + fullname + ", gender=" + gender + ", hobbies=" + hobbies + ", math=" + math + ", literature=" + literature + ", grade=" + grade + ", avartarPath=" + avartarPath + ", comment=" + comment + '}';
    }

}
