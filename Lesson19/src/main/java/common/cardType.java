/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author Asus
 */
public enum cardType {
    HomePage,Employee;
    
    
    public static cardType from(String name){
        switch(name){
            
            case "HomePage":
                return HomePage;
            case "Employee":
                return Employee;
            
                   
        }
        return Employee;
    }
    
}
