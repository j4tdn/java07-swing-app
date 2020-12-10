/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.beans;

import java.util.Objects;

/**
 *
 * @author DangHoang
 */
public class Grade {

    private String id;
    private String name;

    public Grade() {
    }

    public Grade(String id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Grade)) {
            return false;
        }
        Grade that = (Grade) obj;
        return Objects.equals(that.getId(), getId());
    }

    @Override
    public String toString() {
        return name;
    }
}
