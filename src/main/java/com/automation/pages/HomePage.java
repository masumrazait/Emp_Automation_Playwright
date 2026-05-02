package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Home Page class for Employee Management System
 */
public class HomePage extends BasePage {
    private static final Logger logger = LogManager.getLogger(HomePage.class);

    // Locators
    private static final String NAVIGATION_HOME = "text=Home";
    private static final String NAVIGATION_TIMING = "text=Timing";
    private static final String NAVIGATION_EMP = "text=Emp";
    private static final String NAVIGATION_LEAVE = "text=Leave";
    private static final String NAVIGATION_TASKS = "text=Tasks";
    private static final String NAVIGATION_TEAM = "text=Team";
    private static final String NAVIGATION_REPORTS = "text=Reports";
    private static final String NAVIGATION_PERFORMANCE = "text=Performance";
    private static final String NAVIGATION_CONTACT = "text=Contact";
    private static final String NAVIGATION_SETTINGS = "text=Settings";

    private static final String SECTION_ANALYTICS = "text=Analytics and Overview";
    private static final String STAT_TOTAL_EMPLOYEES = "text=Total Employees";
    private static final String STAT_ACTIVE_TODAY = "text=Active Today";
    private static final String STAT_PENDING_LEAVES = "text=Pending Leaves";
    private static final String STAT_TOTAL_TASKS = "text=Total Tasks";
    private static final String SECTION_WEEKLY_ACTIVITY = "text=Weekly Activity";
    private static final String SECTION_DEPARTMENT_DISTRIBUTION = "text=Department Distribution";
    private static final String SECTION_RECENT_ACTIVITY = "text=Recent Activity";

    public HomePage(com.microsoft.playwright.Page page) {
        super(page);
    }

    /**
     * Verify home page is loaded
     */
    public boolean isHomePageLoaded() {
        logger.info("Verifying home page is loaded");
        return isVisible(SECTION_ANALYTICS);
    }

    /**
     * Get page title
     */
    public String getPageTitle() {
        return super.getPageTitle();
    }

    /**
     * Navigate to Timing page
     */
    public void navigateToTiming() {
        logger.info("Navigating to Timing page");
        click(NAVIGATION_TIMING);
    }

    /**
     * Navigate to Employee page
     */
    public void navigateToEmployee() {
        logger.info("Navigating to Employee page");
        click(NAVIGATION_EMP);
    }

    /**
     * Navigate to Leave page
     */
    public void navigateToLeave() {
        logger.info("Navigating to Leave page");
        click(NAVIGATION_LEAVE);
    }

    /**
     * Navigate to Tasks page
     */
    public void navigateToTasks() {
        logger.info("Navigating to Tasks page");
        click(NAVIGATION_TASKS);
    }

    /**
     * Navigate to Team page
     */
    public void navigateToTeam() {
        logger.info("Navigating to Team page");
        click(NAVIGATION_TEAM);
    }

    /**
     * Navigate to Reports page
     */
    public void navigateToReports() {
        logger.info("Navigating to Reports page");
        click(NAVIGATION_REPORTS);
    }

    /**
     * Navigate to Performance page
     */
    public void navigateToPerformance() {
        logger.info("Navigating to Performance page");
        click(NAVIGATION_PERFORMANCE);
    }

    /**
     * Navigate to Contact page
     */
    public void navigateToContact() {
        logger.info("Navigating to Contact page");
        click(NAVIGATION_CONTACT);
    }

    /**
     * Navigate to Settings page
     */
    public void navigateToSettings() {
        logger.info("Navigating to Settings page");
        click(NAVIGATION_SETTINGS);
    }

    /**
     * Navigate to Home page
     */
    public void navigateToHome() {
        logger.info("Navigating to Home page");
        click(NAVIGATION_HOME);
    }

    /**
     * Check if statistics section is visible
     */
    public boolean isStatisticsSectionVisible() {
        return isVisible(STAT_TOTAL_EMPLOYEES) &&
               isVisible(STAT_ACTIVE_TODAY) &&
               isVisible(STAT_PENDING_LEAVES) &&
               isVisible(STAT_TOTAL_TASKS);
    }

    /**
     * Check if analytics sections are visible
     */
    public boolean areAnalyticsSectionsVisible() {
        return isVisible(SECTION_WEEKLY_ACTIVITY) &&
               isVisible(SECTION_DEPARTMENT_DISTRIBUTION) &&
               isVisible(SECTION_RECENT_ACTIVITY);
    }
}
