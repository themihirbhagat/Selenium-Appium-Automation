package com.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	
    private Properties properties;
    
    public ConfigReader(String environment) {
        loadProperties(environment);
    }

    private void loadProperties(String environment) {
        String filePath = String.format("src/main/resources/%s.properties", environment);

        try (FileInputStream fis = new FileInputStream(filePath)) {
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Error loading properties file: " + filePath, e);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
    
    public static Properties loadConstantProperties() {
        Properties constantProperties = new Properties();

        try (InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("constant.properties")) {

            if (inputStream != null) {
                constantProperties.load(inputStream);
            } else {
                throw new IOException("constant.properties file not found");
            }

        } catch (IOException e) {
            throw new RuntimeException("Error loading constant properties file", e);
        }

        return constantProperties;
    }
    
    public static Properties accessPropertiesFile(String propertyFilePath) {
        Properties properties = new Properties();

        try (FileInputStream fis = new FileInputStream(propertyFilePath)) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Error accessing properties file: " + propertyFilePath, e);
        }

        return properties;
    }

    public static String getPropertyValue(String propertyFilePath, String propertyKey) {
        Properties properties = accessPropertiesFile(propertyFilePath);
        return properties.getProperty(propertyKey);
    }

}
