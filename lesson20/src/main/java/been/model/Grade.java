/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package been.model;

import java.util.Objects;

/**
 *
 * @author Admin
 */
public class Grade {
    private Integer id;
    private String name;

    public Grade() {
    }

    public Grade(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
       if(this == obj){
           return true;
       }
       if(!(obj instanceof Grade)){
           return false;
       }
       Grade that = (Grade)obj;
       return Objects.equals(getId(), that.getId());
    }

    @Override
    public String toString() {
        return name;
    }
    
}