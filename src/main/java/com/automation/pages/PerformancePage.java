package com.automation.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Performance Page class for Performance Management
 */
public class PerformancePage extends BasePage {
    private static final Logger logger = LogManager.getLogger(PerformancePage.class);

    // Locators
    private static final String PAGE_TITLE = "text=Performance & Reviews";
    private static final String PERFORMANCE_OVERVIEW = "text=Performance Overview";
    private static final String CREATE_PERFORMANCE_REVIEW = "text=Create Performance Review";
    private static final String PERFORMANCE_REVIEWS = "text=Performance Reviews";
    private static final String SECTION_CREATE_REVIEW = "text=Create Performance Review";
    private static final String PERFORMANCE_RATINGS = "text=Performance Ratings";

    // Form fields
    private static final String INPUT_EMPLOYEE = "select[name='employee'], input[name='employee']";
    private static final String INPUT_RATING = "input[name='rating'], select[name='rating']";
    private static final String INPUT_COMMENTS = "textarea[name='comments'], textarea[placeholder*='comments']";
    private static final String INPUT_REVIEW_DATE = "input[name='reviewDate'], input[type='date']";
    private static final String BUTTON_SUBMIT = "button[type='submit'], button:has-text('Submit'), button:has-text('Create')";
    private static final String BUTTON_CANCEL = "button:has-text('Cancel'), button:has-text('Close')";

    public PerformancePage(com.microsoft.playwright.Page page) {
        super(page);
    }

    /**
     * Verify performance page is loaded
     */
    public boolean isPerformancePageLoaded() {
        logger.info("Verifying performance page is loaded");
        return isVisible(PAGE_TITLE) || isVisible(PERFORMANCE_OVERVIEW);
    }

    /**
     * Click on Create Performance Review
     */
    public void clickCreatePerformanceReview() {
        logger.info("Clicking on Create Performance Review");
        click(CREATE_PERFORMANCE_REVIEW);
    }

    /**
     * Click on Performance Reviews
     */
    public void clickPerformanceReviews() {
        logger.info("Clicking on Performance Reviews");
        click(PERFORMANCE_REVIEWS);
    }

    /**
     * Fill performance review form
     */
    public void fillPerformanceReviewForm(String employee, String rating, String comments, String reviewDate) {
        logger.info("Filling performance review form");
        
        if (isVisible(INPUT_EMPLOYEE)) {
            if (isVisible(INPUT_EMPLOYEE + "[type='select']")) {
                page.selectOption(INPUT_EMPLOYEE, employee);
            } else {
                type(INPUT_EMPLOYEE, employee);
            }
        }
        if (isVisible(INPUT_RATING)) {
            type(INPUT_RATING, rating);
        }
        if (isVisible(INPUT_COMMENTS)) {
            type(INPUT_COMMENTS, comments);
        }
        if (isVisible(INPUT_REVIEW_DATE)) {
            type(INPUT_REVIEW_DATE, reviewDate);
        }
    }

    /**
     * Submit performance review form
     */
    public void submitPerformanceReviewForm() {
        logger.info("Submitting performance review form");
        click(BUTTON_SUBMIT);
    }

    /**
     * Cancel performance review form
     */
    public void cancelPerformanceReviewForm() {
        logger.info("Canceling performance review form");
        click(BUTTON_CANCEL);
    }

    /**
     * Check if create review section is visible
     */
    public boolean isCreateReviewSectionVisible() {
        return isVisible(SECTION_CREATE_REVIEW);
    }

    /**
     * Check if performance ratings section is visible
     */
    public boolean isPerformanceRatingsVisible() {
        return isVisible(PERFORMANCE_RATINGS);
    }
}
