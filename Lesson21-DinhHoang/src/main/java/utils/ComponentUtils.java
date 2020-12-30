/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Component;

/**
 *
 * @author DangHoang
 */
public class ComponentUtils {
    private ComponentUtils(){
    }
    
    public static int getPreWidth(Component com){
        return com.getPreferredSize().width;
    }
    
    public static int getPreHeight(Component com){
        return com.getPreferredSize().height;
    }
}
