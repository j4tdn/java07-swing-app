/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ADMIN
 */
public class ConnectionManagerImpl implements ConnectionManager {

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/java07_student";
            connection = DriverManager.getConnection(url, "root", "billeeloan21980108");
        } catch (Exception e) {
            System.err.println("sai");
        };
        return connection;

    }

}
