/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OS
 */
public class SqlUtils {
    private SqlUtils() {
        
    }
    
    public static <T extends AutoCloseable> void close(T ... closeElement) {
        Arrays.stream(closeElement).forEach(element -> {
            if (element != null) {
                try {
                    element.close();
                } catch (Exception ex) {
                    Logger.getLogger(SqlUtils.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    } 
}
