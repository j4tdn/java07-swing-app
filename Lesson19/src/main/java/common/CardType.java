/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author DangHoang
 */
public enum CardType {
    Homepage, Employee;

    public static CardType from(String name) {
        switch (name) {
            case "Homepage":
                return Homepage;
            case "Employee":
                return Employee;
        }
        return Homepage;
    }
}
