/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DangHoang
 */
public class ConfigurationProviderImpl implements ConfigurationProvider {

    @Override
    public Properties getProperties() {
        Properties pro = new Properties();
        InputStream in = null;

        File file = new File("config.properties");
        try {
            in = new FileInputStream(file);
            pro.load(in);
        } catch (IOException ex) {
            Logger.getLogger(ConfigurationProviderImpl.class.getName()).log(Level.SEVERE, null, ex);
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