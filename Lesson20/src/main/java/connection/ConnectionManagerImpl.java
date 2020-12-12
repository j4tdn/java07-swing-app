/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author ADMIN
 */
public class ConnectionManagerImpl implements ConnectionManager {

    private final ConfigurationProvider provider;

    public ConnectionManagerImpl() {
        provider = new ConfigurationProviderImpl();
    }

    @Override
    public Connection getConnection() {
        Properties props = provider.getProperties();

        Connection connection = null;
        try {
            Class.forName(props.getProperty("driverClassName"));
            connection = DriverManager.getConnection(props.getProperty("URL"), props.getProperty("USERNAME"), props.getProperty("PASSWORD"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
