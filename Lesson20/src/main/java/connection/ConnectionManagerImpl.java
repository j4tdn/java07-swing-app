/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author OS
 */
public class ConnectionManagerImpl implements ConnectionManager{
    
    private static final String DRIVER_CLASSNAME = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/school";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "phanbinh123";

    @Override
    public Connection getConnection() {
        Connection connection = null;
	try {
            Class.forName(DRIVER_CLASSNAME);
            connection = DriverManager.getConnection(
		URL,
		USERNAME,
		PASSWORD);
	} catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
	}
		
	return connection;
    }
    
}
