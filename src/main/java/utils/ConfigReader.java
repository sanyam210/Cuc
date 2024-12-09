package utils;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ConfigReader {
	
	private Properties properties;
	FileInputStream file;
	
	private ConfigReader() {
	properties = new Properties();
	try {
		file = new FileInputStream("src/main/resources/config.properties");
		properties.load(file);
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	}
	
	
	private static ConfigReader reader;
	public static ConfigReader getInstance() {
		if(reader==null) {
			reader= new ConfigReader();
		}
		return reader;
	}
	
	public String getProperty(String key) {
		return properties.getProperty(key);
	} 
	
	
	
	
	
}
