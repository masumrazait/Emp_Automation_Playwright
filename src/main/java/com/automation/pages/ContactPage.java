package com.automation.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Contact Page class for Contact Us functionality
 */
public class ContactPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(ContactPage.class);

    // Locators
    private static final String PAGE_TITLE = "text=Contact Us";
    private static final String SECTION_OFFICE_INFO = "text=Office Information";
    private static final String SECTION_SEND_MESSAGE = "text=Send Message";
    private static final String ADDRESS = "text=#123, Electronic City";
    private static final String PHONE = "text=+91 80 1234 5678";
    private static final String EMAIL = "text=info@mrtech.com";

    // Contact form fields
    private static final String INPUT_NAME = "input[name='name'], input[placeholder*='Name']";
    private static final String INPUT_EMAIL = "input[name='email'], input[type='email']";
    private static final String INPUT_SUBJECT = "input[name='subject'], input[placeholder*='Subject']";
    private static final String INPUT_MESSAGE = "textarea[name='message'], textarea[placeholder*='Message']";
    private static final String BUTTON_SEND = "button[type='submit'], button:has-text('Send'), button:has-text('Submit')";
    private static final String BUTTON_RESET = "button:has-text('Reset'), button:has-text('Clear')";

    public ContactPage(com.microsoft.playwright.Page page) {
        super(page);
    }

    /**
     * Verify contact page is loaded
     */
    public boolean isContactPageLoaded() {
        logger.info("Verifying contact page is loaded");
        return isVisible(PAGE_TITLE) || isVisible(SECTION_OFFICE_INFO);
    }

    /**
     * Check if office information is displayed
     */
    public boolean isOfficeInformationDisplayed() {
        logger.info("Checking if office information is displayed");
        return isVisible(ADDRESS) && isVisible(PHONE) && isVisible(EMAIL);
    }

    /**
     * Get office address
     */
    public String getOfficeAddress() {
        return getText(ADDRESS);
    }

    /**
     * Get office phone
     */
    public String getOfficePhone() {
        return getText(PHONE);
    }

    /**
     * Get office email
     */
    public String getOfficeEmail() {
        return getText(EMAIL);
    }

    /**
     * Fill contact form
     */
    public void fillContactForm(String name, String email, String subject, String message) {
        logger.info("Filling contact form");
        
        if (isVisible(INPUT_NAME)) {
            type(INPUT_NAME, name);
        }
        if (isVisible(INPUT_EMAIL)) {
            type(INPUT_EMAIL, email);
        }
        if (isVisible(INPUT_SUBJECT)) {
            type(INPUT_SUBJECT, subject);
        }
        if (isVisible(INPUT_MESSAGE)) {
            type(INPUT_MESSAGE, message);
        }
    }

    /**
     * Send contact form
     */
    public void sendContactForm() {
        logger.info("Sending contact form");
        click(BUTTON_SEND);
    }

    /**
     * Reset contact form
     */
    public void resetContactForm() {
        logger.info("Resetting contact form");
        click(BUTTON_RESET);
    }

    /**
     * Check if send message section is visible
     */
    public boolean isSendMessageSectionVisible() {
        return isVisible(SECTION_SEND_MESSAGE);
    }
}
