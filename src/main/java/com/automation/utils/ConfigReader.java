package com.automation.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Configuration Reader utility class to read properties from config files
 */
public class ConfigReader {
    private static final Logger logger = LogManager.getLogger(ConfigReader.class);
    private static Properties properties;
    private static final String CONFIG_FILE = "src/main/resources/config/config.properties";

    static {
        loadProperties();
    }

    /**
     * Load properties from config file
     */
    private static void loadProperties() {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream(CONFIG_FILE)) {
            properties.load(fis);
            logger.info("Configuration file loaded successfully");
        } catch (IOException e) {
            logger.error("Failed to load configuration file: " + e.getMessage());
            throw new RuntimeException("Configuration file not found or cannot be read", e);
        }
    }

    /**
     * Get property value by key
     */
    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            logger.warn("Property key not found: " + key);
        }
        return value;
    }

    /**
     * Get property value by key with default value
     */
    public static String getProperty(String key, String defaultValue) {
        String value = properties.getProperty(key);
        return value != null ? value : defaultValue;
    }

    /**
     * Get integer property value
     */
    public static int getIntProperty(String key) {
        String value = properties.getProperty(key);
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            logger.error("Invalid integer value for key: " + key);
            throw new RuntimeException("Invalid integer value for key: " + key, e);
        }
    }

    /**
     * Get boolean property value
     */
    public static boolean getBooleanProperty(String key) {
        String value = properties.getProperty(key);
        return Boolean.parseBoolean(value);
    }

    /**
     * Reload properties
     */
    public static void reloadProperties() {
        loadProperties();
    }
}
