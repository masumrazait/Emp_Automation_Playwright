package com.automation.pages;

import com.automation.base.BaseTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Base Page class with common methods for all pages
 */
public class BasePage {
    protected static final Logger logger = LogManager.getLogger(BasePage.class);
    protected Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    /**
     * Click on element
     */
    protected void click(String locator) {
        logger.info("Clicking on element: " + locator);
        page.click(locator);
    }

    /**
     * Click on element with text
     */
    protected void clickByText(String text) {
        logger.info("Clicking on element with text: " + text);
        page.getByText(text).click();
    }

    /**
     * Type text into element
     */
    protected void type(String locator, String text) {
        logger.info("Typing text '" + text + "' into element: " + locator);
        page.fill(locator, text);
    }

    /**
     * Get text from element
     */
    protected String getText(String locator) {
        String text = page.textContent(locator);
        logger.info("Retrieved text from element " + locator + ": " + text);
        return text;
    }

    /**
     * Check if element is visible
     */
    protected boolean isVisible(String locator) {
        boolean visible = page.isVisible(locator);
        logger.info("Element " + locator + " visibility: " + visible);
        return visible;
    }

    /**
     * Check if element is enabled
     */
    protected boolean isEnabled(String locator) {
        boolean enabled = page.isEnabled(locator);
        logger.info("Element " + locator + " enabled: " + enabled);
        return enabled;
    }

    /**
     * Wait for element to be visible
     */
    protected void waitForElement(String locator) {
        logger.info("Waiting for element: " + locator);
        page.waitForSelector(locator);
    }

    /**
     * Wait for element to be visible with timeout
     */
    protected void waitForElement(String locator, double timeout) {
        logger.info("Waiting for element with timeout: " + locator);
        page.waitForSelector(locator, new Page.WaitForSelectorOptions().setTimeout(timeout));
    }

    /**
     * Get page title
     */
    protected String getPageTitle() {
        return page.title();
    }

    /**
     * Navigate to URL
     */
    protected void navigate(String url) {
        logger.info("Navigating to: " + url);
        page.navigate(url);
    }

    /**
     * Get current URL
     */
    protected String getCurrentUrl() {
        return page.url();
    }

    /**
     * Take screenshot
     */
    protected void takeScreenshot(String fileName) {
        String screenshotPath = "./screenshots/" + fileName + ".png";
        page.screenshot(new Page.ScreenshotOptions().setPath(java.nio.file.Paths.get(screenshotPath)));
        logger.info("Screenshot saved: " + screenshotPath);
    }

    /**
     * Scroll to element
     */
    protected void scrollToElement(String locator) {
        page.locator(locator).scrollIntoViewIfNeeded();
    }

    /**
     * Hover over element
     */
    protected void hover(String locator) {
        page.hover(locator);
    }
}
