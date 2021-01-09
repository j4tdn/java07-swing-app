package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationProviderImpl implements ConfigurationProvider {

	@Override
	public Properties getProperties(String topic) {
		Properties properties = new Properties();

		InputStream input = null;
		try {
			File file = new File(topic+".properties");
			input = new FileInputStream(file);
			properties.load(input);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (input != null) {
					input.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return properties;
	}
        

}
