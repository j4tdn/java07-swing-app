/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Component;

/**
 *
 * @author Asus
 */
public class CompUtils {

    public CompUtils() {
    }
    public static int getPreWidth(Component comp){
        return comp.getPreferredSize().width;
        
    }
    public static int getDWidth(Component comp){
        return comp.getSize().width;
        
    }
   
    public static int getPreHeight(Component comp){
        return comp.getPreferredSize().height;
        
    }
    
}
