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
public enum CardType {
    
    HomePage,Employee,Student;
    
    public static  CardType from(String name){
        switch(name){
            case "Employee":
                return Employee;
            case "HomePage":
                return HomePage;
            case "Student":
                return Student;
        }
        return HomePage;
    }
    
}
