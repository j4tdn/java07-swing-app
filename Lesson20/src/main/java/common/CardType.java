/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author qphan
 */
public enum CardType {
    HomePage, Employee, List;

    public static CardType from(String name) {
        switch (name) {
            case "HomePage":
                return HomePage;

            case "Employee":
                return Employee;
                
            case "List":
                return List;
        }
        return HomePage;
    }
}
