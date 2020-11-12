/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.awt.Color;

/**
 *
 * @author LONG
 */
public enum Colour {
    YELLOW(Color.YELLOW),
    GREEN(Color.GREEN),
    RED(Color.RED),
    BLUE(Color.BLUE),
    BLACK(Color.BLACK),
    GRAY(Color.GRAY);
    
    private Color color;
    
    private Colour(Color color) {
        this.color = color;
    }
    
    public Color getColor() {
        return color;
    }
}
