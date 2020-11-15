/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.awt.Color;

/**
 *
 * @author Asus
 */
public enum Colour {
    YELLOW(Color.yellow),
    GREEN(Color.GREEN),
    GRAY(Color.gray),
    BLUE(Color.BLUE),
    RED(Color.red),
    ORANGE(Color.orange),
    WHITE(Color.white);
    
    private final Color color;

    private Colour(Color color) {
        this.color = color;
    }
    public Color getColour(){
        return color;
        
    }
    
}
