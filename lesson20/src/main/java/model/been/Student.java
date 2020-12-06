/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.been;


/**
 *
 * @author Admin
 */
public class Student {
    private String id;
    private String fullname;
    private Boolean greder; // ddeer kiểu dữ liệu objec bôlean vì khi đổ ra thì có thể dễ bị null
    private String hobbies;
    private Double mathl;
    private Double literature;
    private Grade grade;
    private String avatarPath;
    private String comment;

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

    public Boolean getGreder() {
        return greder;
    }

    public void setGreder(Boolean greder) {
        this.greder = greder;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public Double getMathl() {
        return mathl;
    }

    public void setMathl(Double mathl) {
        this.mathl = mathl;
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
        return "student{" + "id=" + id + ", fullname=" + fullname + ", greder=" + greder + ", hobbies=" + hobbies + ", mathl=" + mathl + ", literature=" + literature + ", grade=" + grade + ", avatarPath=" + avatarPath + ", comment=" + comment + '}';
    }

    public Student(String id, String fullname, Boolean greder, String hobbies, Double mathl, Double literature, Grade grade, String avatarPath, String comment) {
        this.id = id;
        this.fullname = fullname;
        this.greder = greder;
        this.hobbies = hobbies;
        this.mathl = mathl;
        this.literature = literature;
        this.grade = grade;
        this.avatarPath = avatarPath;
        this.comment = comment;
    }
    
    
    
}
