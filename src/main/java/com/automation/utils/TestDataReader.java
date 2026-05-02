package com.automation.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Test Data Reader utility class to read test data from property files
 */
public class TestDataReader {
    private static final Logger logger = LogManager.getLogger(TestDataReader.class);
    private static Properties properties;
    private static final String TESTDATA_FILE = "src/test/resources/testdata/testdata.properties";

    static {
        loadProperties();
    }

    /**
     * Load properties from test data file
     */
    private static void loadProperties() {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream(TESTDATA_FILE)) {
            properties.load(fis);
            logger.info("Test data file loaded successfully");
        } catch (IOException e) {
            logger.error("Failed to load test data file: " + e.getMessage());
            throw new RuntimeException("Test data file not found or cannot be read", e);
        }
    }

    /**
     * Get test data value by key
     */
    public static String getTestData(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            logger.warn("Test data key not found: " + key);
        }
        return value;
    }

    /**
     * Get test data value by key with default value
     */
    public static String getTestData(String key, String defaultValue) {
        String value = properties.getProperty(key);
        return value != null ? value : defaultValue;
    }

    /**
     * Reload test data
     */
    public static void reloadTestData() {
        loadProperties();
    }
}
