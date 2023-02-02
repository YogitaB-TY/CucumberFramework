package utility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class contains methods to read data from property file
 * @author Yogita
 *
 */
public class PropertyFileReader {
	/**
	 * This method read the properties and return the value based on key
	 * @param key
	 * @return value
	 * @throws Throwable
	 */
	public String getValueProperty(String key) throws Throwable {
		FileInputStream file=new FileInputStream(".\\src\\test\\resources\\AppData.properties");
		Properties properties=new Properties();
		properties.load(file);
		return properties.getProperty(key);
	}

}
