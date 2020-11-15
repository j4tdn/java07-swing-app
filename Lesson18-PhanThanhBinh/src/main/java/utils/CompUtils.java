  
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Component;

/**
 *
 * @author OS
 */
public class CompUtils {
    
    private CompUtils() {
        
    }
    
    public static int getPreWidth(Component comp) {
        return comp.getPreferredSize().width;
    }
    
    public static int getPreHeight(Component comp) {
        return comp.getPreferredSize().height;
    }
    
    public static int getDWidth(Component comp) {
        return comp.getWidth();
    }
    
    public static int getDHeight(Component comp) {
        return comp.getHeight();
    }
}