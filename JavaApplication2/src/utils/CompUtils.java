/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Component;

/**
 *
 * @author khanh
 */
public class CompUtils {

    private CompUtils() {
    }
    
    
    public  static int getPreWidth(Component component){
        return component.getPreferredSize().width;
        
    }
    
     public  static int getPreHeight(Component component){
        return component.getPreferredSize().height;
        
    }
     
     public static int getDWidth(Component component){
        return component.getSize().width;
     }
    
}

