/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import java.awt.Color;

/**
 *
 * @author Admin
 */
public enum Colour {
    YELLOW(Color.YELLOW),
    RED(Color.RED),
    Black(Color.BLACK);
    
    private final Color color;
    
    private Colour(Color color){
        this.color = color;
    }
    
    public Color getColor(){
        return color;
    }
    
}
