/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Component;

/**
 *
 * @author Admin
 */
public class CompUtils {
    private CompUtils(){
        
    }
        public static int getDWidth(Component comp){
        return (int) comp.getSize().getWidth();
    }
    public static int getPreWidth(Component comp){
        return comp.getPreferredSize().width;
    }
    public static int getPreHeight(Component comp){
        return comp.getPreferredSize().height;
    }
}
