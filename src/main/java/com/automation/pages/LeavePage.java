package com.automation.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Leave Page class for Leave Management
 */
public class LeavePage extends BasePage {
    private static final Logger logger = LogManager.getLogger(LeavePage.class);

    // Locators
    private static final String PAGE_TITLE = "text=Leave Management";
    private static final String SUBMIT_LEAVE_REQUEST = "text=Submit Leave Request";
    private static final String LEAVE_REQUESTS = "text=Leave Requests";
    private static final String SECTION_SUBMIT_LEAVE = "text=Submit Leave Request";

    // Form fields
    private static final String INPUT_LEAVE_TYPE = "select[name='leaveType'], select[name='type']";
    private static final String INPUT_REASON = "textarea[name='reason'], textarea[placeholder*='reason']";
    private static final String INPUT_START_DATE = "input[name='startDate'], input[type='date']";
    private static final String INPUT_END_DATE = "input[name='endDate'], input[type='date']";
    private static final String INPUT_DAYS = "input[name='days'], input[type='number']";
    private static final String BUTTON_SUBMIT = "button[type='submit'], button:has-text('Submit'), button:has-text('Apply')";
    private static final String BUTTON_CANCEL = "button:has-text('Cancel'), button:has-text('Close')";

    public LeavePage(com.microsoft.playwright.Page page) {
        super(page);
    }

    /**
     * Verify leave page is loaded
     */
    public boolean isLeavePageLoaded() {
        logger.info("Verifying leave page is loaded");
        return isVisible(PAGE_TITLE) || isVisible(SUBMIT_LEAVE_REQUEST);
    }

    /**
     * Click on Submit Leave Request
     */
    public void clickSubmitLeaveRequest() {
        logger.info("Clicking on Submit Leave Request");
        click(SUBMIT_LEAVE_REQUEST);
    }

    /**
     * Click on Leave Requests
     */
    public void clickLeaveRequests() {
        logger.info("Clicking on Leave Requests");
        click(LEAVE_REQUESTS);
    }

    /**
     * Fill leave request form
     */
    public void fillLeaveRequestForm(String leaveType, String reason, String startDate,
                                      String endDate, String days) {
        logger.info("Filling leave request form");
        
        if (isVisible(INPUT_LEAVE_TYPE)) {
            page.selectOption(INPUT_LEAVE_TYPE, leaveType);
        }
        if (isVisible(INPUT_REASON)) {
            type(INPUT_REASON, reason);
        }
        if (isVisible(INPUT_START_DATE)) {
            type(INPUT_START_DATE, startDate);
        }
        if (isVisible(INPUT_END_DATE)) {
            type(INPUT_END_DATE, endDate);
        }
        if (isVisible(INPUT_DAYS)) {
            type(INPUT_DAYS, days);
        }
    }

    /**
     * Submit leave request form
     */
    public void submitLeaveRequestForm() {
        logger.info("Submitting leave request form");
        click(BUTTON_SUBMIT);
    }

    /**
     * Cancel leave request form
     */
    public void cancelLeaveRequestForm() {
        logger.info("Canceling leave request form");
        click(BUTTON_CANCEL);
    }

    /**
     * Check if submit leave section is visible
     */
    public boolean isSubmitLeaveSectionVisible() {
        return isVisible(SECTION_SUBMIT_LEAVE);
    }
}
