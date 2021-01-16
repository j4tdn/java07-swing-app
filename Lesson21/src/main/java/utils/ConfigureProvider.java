/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Asus
 */
public class ConfigureProvider {
    private Properties prope;
    
    public Properties getProperties(String topic){
        prope = new Properties();
        InputStream in= null;
        String path = topic +".properties";
        File file = new File(path);
        
        try {
            in = new FileInputStream(file);
            prope.load(in);
        } catch (Exception e) {
        }finally{
            try {
                if(in!=null){
                    in.close();
                }
            } catch (Exception e) {
            }
        }
        return prope;
    }
    
}
