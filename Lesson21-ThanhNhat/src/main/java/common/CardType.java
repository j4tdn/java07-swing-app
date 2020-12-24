/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author ADMIN
 */
public enum CardType {
    Star, Rect, Triangle, Circle, Special;
    
    public static CardType from (String name){
        switch(name){
            case "Star":
                return Star;
                
            case "Rect":
                return Rect;
                
            case "Triangle":
                return Triangle;
                
            case "Circle": 
                return Circle;
            
            case "Special":
                return Special;
        }
        return Star;
    }
}
