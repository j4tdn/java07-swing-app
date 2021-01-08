/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author DangHoang
 */
public class ConfigurationProvider {

    private Properties pro;

    public Properties getProperties(String topic) {
        pro = new Properties();
        InputStream in = null;
        String path = topic + ".properties";

        File file = new File(path);
        try {
            in = new FileInputStream(file);
            pro.load(in);
        } catch (IOException ex) {
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
            }
        }
        return pro;
    }
}
