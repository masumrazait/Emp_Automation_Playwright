package com.automation.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Task Page class for Task Management
 */
public class TaskPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(TaskPage.class);

    // Locators
    private static final String PAGE_TITLE = "text=Task Management";
    private static final String CREATE_NEW_TASK = "text=Create New Task";
    private static final String TASK_LIST = "text=Task List";
    private static final String SECTION_CREATE_TASK = "text=Create New Task";

    // Form fields
    private static final String INPUT_TITLE = "input[name='title'], input[placeholder*='Title']";
    private static final String INPUT_DESCRIPTION = "textarea[name='description'], textarea[placeholder*='Description']";
    private static final String INPUT_PRIORITY = "select[name='priority'], select[name='taskPriority']";
    private static final String INPUT_ASSIGNEE = "input[name='assignee'], input[placeholder*='Assignee']";
    private static final String INPUT_DUE_DATE = "input[name='dueDate'], input[type='date']";
    private static final String INPUT_STATUS = "select[name='status'], select[name='taskStatus']";
    private static final String BUTTON_SUBMIT = "button[type='submit'], button:has-text('Submit'), button:has-text('Create')";
    private static final String BUTTON_CANCEL = "button:has-text('Cancel'), button:has-text('Close')";

    public TaskPage(com.microsoft.playwright.Page page) {
        super(page);
    }

    /**
     * Verify task page is loaded
     */
    public boolean isTaskPageLoaded() {
        logger.info("Verifying task page is loaded");
        return isVisible(PAGE_TITLE) || isVisible(CREATE_NEW_TASK);
    }

    /**
     * Click on Create New Task
     */
    public void clickCreateNewTask() {
        logger.info("Clicking on Create New Task");
        click(CREATE_NEW_TASK);
    }

    /**
     * Click on Task List
     */
    public void clickTaskList() {
        logger.info("Clicking on Task List");
        click(TASK_LIST);
    }

    /**
     * Fill task form
     */
    public void fillTaskForm(String title, String description, String priority,
                             String assignee, String dueDate, String status) {
        logger.info("Filling task form");
        
        if (isVisible(INPUT_TITLE)) {
            type(INPUT_TITLE, title);
        }
        if (isVisible(INPUT_DESCRIPTION)) {
            type(INPUT_DESCRIPTION, description);
        }
        if (isVisible(INPUT_PRIORITY)) {
            page.selectOption(INPUT_PRIORITY, priority);
        }
        if (isVisible(INPUT_ASSIGNEE)) {
            type(INPUT_ASSIGNEE, assignee);
        }
        if (isVisible(INPUT_DUE_DATE)) {
            type(INPUT_DUE_DATE, dueDate);
        }
        if (isVisible(INPUT_STATUS)) {
            page.selectOption(INPUT_STATUS, status);
        }
    }

    /**
     * Submit task form
     */
    public void submitTaskForm() {
        logger.info("Submitting task form");
        click(BUTTON_SUBMIT);
    }

    /**
     * Cancel task form
     */
    public void cancelTaskForm() {
        logger.info("Canceling task form");
        click(BUTTON_CANCEL);
    }

    /**
     * Check if create task section is visible
     */
    public boolean isCreateTaskSectionVisible() {
        return isVisible(SECTION_CREATE_TASK);
    }
}
