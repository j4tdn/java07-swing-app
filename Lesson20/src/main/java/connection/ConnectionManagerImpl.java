/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DangHoang
 */
public class ConnectionManagerImpl implements ConnectionManager {

    private final ConfigurationProvider provider;
    private final Properties pro;

    public ConnectionManagerImpl() {
        provider = new ConfigurationProviderImpl();
        pro = provider.getProperties();
    }

    @Override
    public Connection getConnection() {
        Connection con = null;

        try {
            Class.forName(pro.getProperty("driverClassName"));
            con = DriverManager.getConnection(pro.getProperty("URL"), pro.getProperty("USER"), pro.getProperty("PASSWORD"));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectionManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;
    }
}