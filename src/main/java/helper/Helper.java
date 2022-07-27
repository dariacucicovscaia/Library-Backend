package helper;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

public class Helper {

    private static final Logger logger = LogManager.getLogger(Helper.class);
    private final Properties properties;

    public Helper(String fileName) {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream(fileName));
        } catch (IOException e) {
            logger.error("IOException occurred while loading properties file " + e.getMessage());
        }
    }

    public Properties getProperties() {
        return properties;
    }

    public String readProperty(String keyName) {
        return properties.getProperty(keyName, "There is no key in properties file");
    }
}
