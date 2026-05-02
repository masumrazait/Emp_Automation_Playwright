package com.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

/**
 * ExtentReport Manager class for generating interactive test reports
 */
public class ExtentReportManager {
    private static final Logger logger = LogManager.getLogger(ExtentReportManager.class);
    private static ExtentReports extentReports;
    private static ExtentTest extentTest;
    private static final String REPORT_PATH = ConfigReader.getProperty("report.path", "./reports");
    private static final String REPORT_FILE = REPORT_PATH + "/ExtentReport.html";

    /**
     * Initialize ExtentReports instance
     */
    public static ExtentReports getInstance() {
        if (extentReports == null) {
            createInstance();
        }
        return extentReports;
    }

    /**
     * Create ExtentReports instance with Spark reporter
     */
    private static void createInstance() {
        File reportDir = new File(REPORT_PATH);
        if (!reportDir.exists()) {
            reportDir.mkdirs();
        }

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(REPORT_FILE);
        sparkReporter.config().setDocumentTitle("Employee Management System - Automation Report");
        sparkReporter.config().setReportName("Test Execution Report");
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setTimeStampFormat("dd-MM-yyyy HH:mm:ss");
        sparkReporter.config().setEncoding("utf-8");

        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("Application", ConfigReader.getProperty("app.title", "Employee Management System"));
        extentReports.setSystemInfo("Browser", ConfigReader.getProperty("browser.type", "chromium"));
        extentReports.setSystemInfo("Environment", ConfigReader.getProperty("env", "production"));
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));

        logger.info("ExtentReport initialized at: " + REPORT_FILE);
    }

    /**
     * Create a test in the report
     */
    public static ExtentTest createTest(String testName) {
        extentTest = getInstance().createTest(testName);
        return extentTest;
    }

    /**
     * Create a test with description
     */
    public static ExtentTest createTest(String testName, String description) {
        extentTest = getInstance().createTest(testName, description);
        return extentTest;
    }

    /**
     * Get current test
     */
    public static ExtentTest getTest() {
        return extentTest;
    }

    /**
     * Flush the report - write to file
     */
    public static void flushReport() {
        if (extentReports != null) {
            extentReports.flush();
            logger.info("ExtentReport flushed successfully");
        }
    }

    /**
     * Get report file path
     */
    public static String getReportFilePath() {
        return REPORT_FILE;
    }
}
