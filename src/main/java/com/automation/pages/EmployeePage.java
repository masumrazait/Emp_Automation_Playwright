package com.automation.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Employee Page class for Employee Management
 */
public class EmployeePage extends BasePage {
    private static final Logger logger = LogManager.getLogger(EmployeePage.class);

    // Locators
    private static final String PAGE_TITLE = "text=Employee Management";
    private static final String ADD_NEW_EMPLOYEE = "text=Add New Employee";
    private static final String EMPLOYEE_DIRECTORY = "text=Employee Directory";
    private static final String SECTION_ADD_EMPLOYEE = "text=Add New Employee";

    // Form fields (these will need to be adjusted based on actual page structure)
    private static final String INPUT_FIRST_NAME = "input[name='firstName'], input[placeholder*='First']";
    private static final String INPUT_LAST_NAME = "input[name='lastName'], input[placeholder*='Last']";
    private static final String INPUT_EMAIL = "input[name='email'], input[type='email']";
    private static final String INPUT_PHONE = "input[name='phone'], input[placeholder*='Phone']";
    private static final String INPUT_DEPARTMENT = "select[name='department'], select[name='dept']";
    private static final String INPUT_DESIGNATION = "input[name='designation'], input[placeholder*='Designation']";
    private static final String INPUT_SALARY = "input[name='salary'], input[type='number']";
    private static final String INPUT_JOINING_DATE = "input[name='joiningDate'], input[type='date']";
    private static final String INPUT_ADDRESS = "textarea[name='address'], textarea[placeholder*='Address']";
    private static final String BUTTON_SUBMIT = "button[type='submit'], button:has-text('Submit'), button:has-text('Add')";
    private static final String BUTTON_CANCEL = "button:has-text('Cancel'), button:has-text('Close')";

    public EmployeePage(com.microsoft.playwright.Page page) {
        super(page);
    }

    /**
     * Verify employee page is loaded
     */
    public boolean isEmployeePageLoaded() {
        logger.info("Verifying employee page is loaded");
        return isVisible(PAGE_TITLE) || isVisible(ADD_NEW_EMPLOYEE);
    }

    /**
     * Click on Add New Employee
     */
    public void clickAddNewEmployee() {
        logger.info("Clicking on Add New Employee");
        click(ADD_NEW_EMPLOYEE);
    }

    /**
     * Click on Employee Directory
     */
    public void clickEmployeeDirectory() {
        logger.info("Clicking on Employee Directory");
        click(EMPLOYEE_DIRECTORY);
    }

    /**
     * Fill employee form
     */
    public void fillEmployeeForm(String firstName, String lastName, String email, String phone,
                                  String department, String designation, String salary,
                                  String joiningDate, String address) {
        logger.info("Filling employee form");
        
        if (isVisible(INPUT_FIRST_NAME)) {
            type(INPUT_FIRST_NAME, firstName);
        }
        if (isVisible(INPUT_LAST_NAME)) {
            type(INPUT_LAST_NAME, lastName);
        }
        if (isVisible(INPUT_EMAIL)) {
            type(INPUT_EMAIL, email);
        }
        if (isVisible(INPUT_PHONE)) {
            type(INPUT_PHONE, phone);
        }
        if (isVisible(INPUT_DEPARTMENT)) {
            page.selectOption(INPUT_DEPARTMENT, department);
        }
        if (isVisible(INPUT_DESIGNATION)) {
            type(INPUT_DESIGNATION, designation);
        }
        if (isVisible(INPUT_SALARY)) {
            type(INPUT_SALARY, salary);
        }
        if (isVisible(INPUT_JOINING_DATE)) {
            type(INPUT_JOINING_DATE, joiningDate);
        }
        if (isVisible(INPUT_ADDRESS)) {
            type(INPUT_ADDRESS, address);
        }
    }

    /**
     * Submit employee form
     */
    public void submitEmployeeForm() {
        logger.info("Submitting employee form");
        click(BUTTON_SUBMIT);
    }

    /**
     * Cancel employee form
     */
    public void cancelEmployeeForm() {
        logger.info("Canceling employee form");
        click(BUTTON_CANCEL);
    }

    /**
     * Check if add employee section is visible
     */
    public boolean isAddEmployeeSectionVisible() {
        return isVisible(SECTION_ADD_EMPLOYEE);
    }
}
