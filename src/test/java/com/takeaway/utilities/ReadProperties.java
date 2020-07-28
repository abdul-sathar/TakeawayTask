package com.takeaway.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.takeaway.constants.PropertyKeys;

public class ReadProperties {
	
    private static final String PROPERTY_FILE_NAME = "config.properties";
    private static final Logger logger = LogManager.getLogger(ReadProperties.class);
    private static final Properties properties = loadProperties();

    /**
     * This method loads Properties object
     */
    private static Properties loadProperties() {
        try 
        {
            InputStream inputStream = ReadProperties.class.getClassLoader().getResourceAsStream(PROPERTY_FILE_NAME);
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
        	logger.warn("Sorry, unable to find config.properties", e);
            throw new RuntimeException("Sorry, unable to find config.properties" + e);
        }
    }

    /**
     * This method return the property value from the properties file based on property key
     *
     * @param  param PropertyKeys
     * @return String
     */
    public static String getValue(PropertyKeys key) {
    	return properties.getProperty(key.getKey());       
    }

}

