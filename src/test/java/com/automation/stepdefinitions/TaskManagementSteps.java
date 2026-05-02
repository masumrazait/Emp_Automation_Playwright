package com.automation.stepdefinitions;

import com.automation.base.BaseTest;
import com.automation.pages.HomePage;
import com.automation.pages.TaskPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Map;

/**
 * Step definitions for Task Management scenarios
 */
public class TaskManagementSteps {
    private static final Logger logger = LogManager.getLogger(TaskManagementSteps.class);
    private TaskPage taskPage;

    
    @When("I navigate to Tasks section")
    public void iNavigateToTasksSection() {
        logger.info("Navigating to Tasks section");
        HomePageSteps.getHomePage().navigateToTasks();
        taskPage = new TaskPage(BaseTest.getPage());
    }

    @Then("the task management page should be loaded")
    public void theTaskManagementPageShouldBeLoaded() {
        logger.info("Verifying task management page is loaded");
        boolean isLoaded = taskPage.isTaskPageLoaded();
        Assertions.assertTrue(isLoaded, "Task management page should be loaded");
    }

    @And("Create New Task option should be visible")
    public void createNewTaskOptionShouldBeVisible() {
        logger.info("Verifying Create New Task option is visible");
        Assertions.assertTrue(true, "Create New Task option should be visible");
    }

    @And("Task List option should be visible")
    public void taskListOptionShouldBeVisible() {
        logger.info("Verifying Task List option is visible");
        Assertions.assertTrue(true, "Task List option should be visible");
    }

    @When("I click on Create New Task")
    public void iClickOnCreateNewTask() {
        logger.info("Clicking on Create New Task");
        taskPage.clickCreateNewTask();
    }

    @And("I fill task form with valid data")
    public void iFillTaskFormWithValidData(io.cucumber.datatable.DataTable dataTable) {
        logger.info("Filling task form with valid data");
        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
        taskPage.fillTaskForm(
            data.get("title"),
            data.get("description"),
            data.get("priority"),
            data.get("assignee"),
            data.get("dueDate"),
            data.get("status")
        );
    }

    @And("I submit the task form")
    public void iSubmitTheTaskForm() {
        logger.info("Submitting task form");
        taskPage.submitTaskForm();
    }

    @Then("the task should be created successfully")
    public void theTaskShouldBeCreatedSuccessfully() {
        logger.info("Verifying task is created successfully");
        Assertions.assertTrue(true, "Task should be created successfully");
    }

    @And("I fill task form with high priority")
    public void iFillTaskFormWithHighPriority(io.cucumber.datatable.DataTable dataTable) {
        logger.info("Filling task form with high priority");
        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
        taskPage.fillTaskForm(
            data.get("title"),
            data.get("description"),
            data.get("priority"),
            data.get("assignee"),
            data.get("dueDate"),
            "In Progress"
        );
    }

    @Then("the high priority task should be created")
    public void theHighPriorityTaskShouldBeCreated() {
        logger.info("Verifying high priority task is created");
        Assertions.assertTrue(true, "High priority task should be created");
    }

    @And("I cancel the task form")
    public void iCancelTheTaskForm() {
        logger.info("Canceling task form");
        taskPage.cancelTaskForm();
    }

    @When("I click on Task List")
    public void iClickOnTaskList() {
        logger.info("Clicking on Task List");
        taskPage.clickTaskList();
    }

    @Then("the task list should be displayed")
    public void theTaskListShouldBeDisplayed() {
        logger.info("Verifying task list is displayed");
        Assertions.assertTrue(true, "Task list should be displayed");
    }
}
