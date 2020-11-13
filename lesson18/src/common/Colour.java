/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import javafx.scene.paint.Color;

public enum Colour {
    YELLOW(Color.YELLOW),
    GREEN(Color.GREEN),
    RED(Color.RED),
    BLACK(Color.BLUE),
    GRAY(Color.GRAY),;
    private final Color color;
    
    private Colour(Color color){
        this.color = color;
    }
     private  Color  getColor(){
        return color;
    }
    
}
