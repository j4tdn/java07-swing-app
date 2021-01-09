package config;

import java.util.Properties;

public interface ConfigurationProvider {
	Properties getProperties(String topic);
}
