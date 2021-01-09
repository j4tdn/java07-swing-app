/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author khanh
 */
public enum Topic {
    FAMILY("family"),
    HEALTH("health"),
    LIFE("life"),
    SCIENCE("science");
    
    private String name;
    private Topic(String name) {
       this.name=name;
    }
    public String getName(){
        return name;
    }
}
