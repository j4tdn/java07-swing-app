package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionManagerImpl implements ConnectionManager {
	
	private final ConfigurationProvider provider;
	
	public  ConnectionManagerImpl() {
		provider = new ConfigurationProviderImpl();
	}

	@Override
	public Connection getConnection() {
		
		Properties properties = provider.getProperties();
		
		Connection connection = null;
		try {
			Class.forName(properties.getProperty("driverClassName"));
			connection = DriverManager.getConnection(properties.getProperty("URL"), properties.getProperty("USER"), properties.getProperty("PASSWORD"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return connection;
	}

}
