/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author Admin
 */
public enum cardType {
    HomePage, Employee, Student;
    
    public static cardType from(String name){
        switch(name){
              case "HomePage"
                    :return HomePage;
            case "Employee"
                    :return Employee;
            case "Student"
                    :return Student;
          
        }
        return HomePage;
    }
}
