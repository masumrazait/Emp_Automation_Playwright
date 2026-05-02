package com.automation.base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.automation.utils.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Base test class for Playwright initialization
 */
public class BaseTest {
    private static final Logger logger = LogManager.getLogger(BaseTest.class);
    protected static ThreadLocal<Playwright> playwright = new ThreadLocal<>();
    protected static ThreadLocal<Browser> browser = new ThreadLocal<>();
    protected static ThreadLocal<BrowserContext> context = new ThreadLocal<>();
    protected static ThreadLocal<Page> page = new ThreadLocal<>();

    /**
     * Initialize Playwright and Browser
     */
    public static void initializeDriver() {
        logger.info("Initializing Playwright driver");
        playwright.set(Playwright.create());

        String browserType = ConfigReader.getProperty("browser.type", "chromium");
        boolean headless = ConfigReader.getBooleanProperty("browser.headless");

        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions()
                .setHeadless(headless)
                .setArgs(java.util.Arrays.asList("--start-maximized"));

        switch (browserType.toLowerCase()) {
            case "firefox":
                browser.set(playwright.get().firefox().launch(launchOptions));
                break;
            case "webkit":
                browser.set(playwright.get().webkit().launch(launchOptions));
                break;
            case "chromium":
            default:
                browser.set(playwright.get().chromium().launch(launchOptions));
                break;
        }

        context.set(browser.get().newContext(new Browser.NewContextOptions()
                .setViewportSize(null)
        ));

        page.set(context.get().newPage());
        page.get().setDefaultTimeout(ConfigReader.getIntProperty("browser.timeout"));
        logger.info("Browser initialized successfully: " + browserType);
    }

    /**
     * Get Page instance
     */
    public static Page getPage() {
        return page.get();
    }

    /**
     * Navigate to URL
     */
    public static void navigateToUrl(String url) {
        logger.info("Navigating to URL: " + url);
        page.get().navigate(url);
    }

    /**
     * Close browser and cleanup
     */
    public static void quitDriver() {
        logger.info("Closing browser and cleaning up");
        try {
            if (page.get() != null) {
                page.get().close();
            }
            if (context.get() != null) {
                context.get().close();
            }
            if (browser.get() != null) {
                browser.get().close();
            }
            if (playwright.get() != null) {
                playwright.get().close();
            }
        } catch (Exception e) {
            logger.error("Error while closing driver: " + e.getMessage());
        } finally {
            page.remove();
            context.remove();
            browser.remove();
            playwright.remove();
        }
    }

    /**
     * Take screenshot
     */
    public static byte[] takeScreenshot() {
        return page.get().screenshot();
    }

    /**
     * Take screenshot and save to file
     */
    public static void takeScreenshot(String filePath) {
        page.get().screenshot(new Page.ScreenshotOptions().setPath(java.nio.file.Paths.get(filePath)));
        logger.info("Screenshot saved to: " + filePath);
    }
}
