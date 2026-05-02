package com.automation.hooks;

import com.automation.base.BaseTest;
import com.automation.utils.ConfigReader;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.EmailUtil;
import com.aventstack.extentreports.Status;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Hooks class for setup and teardown of test execution
 */
public class Hooks {
    private static final Logger logger = LogManager.getLogger(Hooks.class);
    private static final String SCREENSHOT_DIR = "./screenshots";
    private static int totalScenarios = 0;
    private static int passedScenarios = 0;
    private static int failedScenarios = 0;
    private static int skippedScenarios = 0;

    @BeforeAll
    public static void beforeAll() {
        logger.info("========================================");
        logger.info("Test Suite Execution Started");
        logger.info("========================================");
        ExtentReportManager.getInstance();
    }

    @AfterAll
    public static void afterAll() {
        ExtentReportManager.flushReport();
        logger.info("ExtentReport generated successfully");

        // Send email notification with report
        EmailUtil.sendTestReportEmail();

        logger.info("========================================");
        logger.info("Test Suite Summary");
        logger.info("Total: " + totalScenarios + " | Passed: " + passedScenarios
                + " | Failed: " + failedScenarios + " | Skipped: " + skippedScenarios);
        logger.info("========================================");
    }

    @Before(order = 0)
    public void setUp() {
        logger.info("========================================");
        logger.info("Test Execution Started");
        logger.info("========================================");

        // Initialize Playwright driver
        BaseTest.initializeDriver();
        logger.info("Browser initialized successfully");

        // Create screenshot directory if it doesn't exist
        createScreenshotDirectory();
    }

    @After(order = 0)
    public void tearDown(Scenario scenario) {
        totalScenarios++;
        logger.info("========================================");
        logger.info("Test Execution Completed");
        logger.info("Scenario Status: " + scenario.getStatus());
        logger.info("========================================");

        // Take screenshot on failure
        if (scenario.isFailed()) {
            failedScenarios++;
            takeScreenshotOnFailure(scenario);
        } else if (scenario.getStatus() == io.cucumber.java.Status.PASSED) {
            passedScenarios++;
        } else if (scenario.getStatus() == io.cucumber.java.Status.SKIPPED) {
            skippedScenarios++;
        }

        // Close browser
        BaseTest.quitDriver();
        logger.info("Browser closed successfully");
    }

    /**
     * Create screenshot directory if it doesn't exist
     */
    private void createScreenshotDirectory() {
        try {
            Path path = Paths.get(SCREENSHOT_DIR);
            if (!Files.exists(path)) {
                Files.createDirectories(path);
                logger.info("Screenshot directory created: " + SCREENSHOT_DIR);
            }
        } catch (IOException e) {
            logger.error("Failed to create screenshot directory: " + e.getMessage());
        }
    }


    /**
     * Take screenshot on test failure
     */
    private void takeScreenshotOnFailure(Scenario scenario) {
        try {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String fileName = scenario.getName().replaceAll(" ", "_") + "_" + timestamp;
            String screenshotPath = SCREENSHOT_DIR + File.separator + fileName + ".png";
            
            BaseTest.takeScreenshot(screenshotPath);
            logger.info("Screenshot taken for failed scenario: " + screenshotPath);
            
            // Embed screenshot in Cucumber report
            byte[] screenshot = BaseTest.takeScreenshot();
            scenario.attach(screenshot, "image/png", fileName);
        } catch (Exception e) {
            logger.error("Failed to take screenshot: " + e.getMessage());
        }
    }

    @Before(order = 1)
    public void beforeScenario(Scenario scenario) {
        logger.info("Starting Scenario: " + scenario.getName());
        logger.info("Scenario ID: " + scenario.getId());

        // Create ExtentReport test entry
        ExtentReportManager.createTest(scenario.getName(), scenario.getId());
        ExtentReportManager.getTest().log(Status.INFO, "Scenario Started: " + scenario.getName());
    }

    @After(order = 1)
    public void afterScenario(Scenario scenario) {
        logger.info("Completed Scenario: " + scenario.getName());
        logger.info("Status: " + scenario.getStatus());

        // Log scenario result to ExtentReport
        if (scenario.isFailed()) {
            ExtentReportManager.getTest().log(Status.FAIL, "Scenario Failed: " + scenario.getName());
        } else if (scenario.getStatus() == io.cucumber.java.Status.PASSED) {
            ExtentReportManager.getTest().log(Status.PASS, "Scenario Passed: " + scenario.getName());
        } else if (scenario.getStatus() == io.cucumber.java.Status.SKIPPED) {
            ExtentReportManager.getTest().log(Status.SKIP, "Scenario Skipped: " + scenario.getName());
        }
    }
}
