/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.awt.Color;

/**
 *
 * @author OS
 */
public enum Colour {
    YELLOW(Color.YELLOW),
    GREEN(Color.GREEN),
    BLUE(Color.BLUE),
    PINK(Color.PINK),
    RED(Color.RED);
    
    private final Color color;
    
    private Colour(Color color) {
        this.color = color;
    }
    
    public Color getColour() {
        return color;
    }
}
