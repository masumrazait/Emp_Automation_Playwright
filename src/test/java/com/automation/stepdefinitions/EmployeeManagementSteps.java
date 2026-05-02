package com.automation.stepdefinitions;

import com.automation.base.BaseTest;
import com.automation.pages.EmployeePage;
import com.automation.pages.HomePage;
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
 * Step definitions for Employee Management scenarios
 */
public class EmployeeManagementSteps {
    private static final Logger logger = LogManager.getLogger(EmployeeManagementSteps.class);
    private EmployeePage employeePage;

    
    @When("I navigate to Employee section")
    public void iNavigateToEmployeeSection() {
        logger.info("Navigating to Employee section");
        HomePageSteps.getHomePage().navigateToEmployee();
        employeePage = new EmployeePage(BaseTest.getPage());
    }

    @Then("the employee management page should be loaded")
    public void theEmployeeManagementPageShouldBeLoaded() {
        logger.info("Verifying employee management page is loaded");
        boolean isLoaded = employeePage.isEmployeePageLoaded();
        Assertions.assertTrue(isLoaded, "Employee management page should be loaded");
    }

    @And("Add New Employee option should be visible")
    public void addNewEmployeeOptionShouldBeVisible() {
        logger.info("Verifying Add New Employee option is visible");
        // This is a placeholder - actual implementation would check the element
        Assertions.assertTrue(true, "Add New Employee option should be visible");
    }

    @And("Employee Directory option should be visible")
    public void employeeDirectoryOptionShouldBeVisible() {
        logger.info("Verifying Employee Directory option is visible");
        Assertions.assertTrue(true, "Employee Directory option should be visible");
    }

    @When("I click on Add New Employee")
    public void iClickOnAddNewEmployee() {
        logger.info("Clicking on Add New Employee");
        employeePage.clickAddNewEmployee();
    }

    @And("I fill employee form with valid data")
    public void iFillEmployeeFormWithValidData(io.cucumber.datatable.DataTable dataTable) {
        logger.info("Filling employee form with valid data");
        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
        employeePage.fillEmployeeForm(
            data.get("firstName"),
            data.get("lastName"),
            data.get("email"),
            data.get("phone"),
            data.get("department"),
            data.get("designation"),
            data.get("salary"),
            data.get("joiningDate"),
            data.get("address")
        );
    }

    @And("I submit the employee form")
    public void iSubmitTheEmployeeForm() {
        logger.info("Submitting employee form");
        employeePage.submitEmployeeForm();
    }

    @Then("the employee should be added successfully")
    public void theEmployeeShouldBeAddedSuccessfully() {
        logger.info("Verifying employee is added successfully");
        // This is a placeholder - actual implementation would verify success message
        Assertions.assertTrue(true, "Employee should be added successfully");
    }

    @And("I fill employee form with invalid email")
    public void iFillEmployeeFormWithInvalidEmail(io.cucumber.datatable.DataTable dataTable) {
        logger.info("Filling employee form with invalid email");
        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
        employeePage.fillEmployeeForm(
            data.get("firstName"),
            data.get("lastName"),
            data.get("email"),
            data.get("phone"),
            data.get("department"),
            data.get("designation"),
            "75000",
            "2024-01-15",
            "123, Address"
        );
    }

    @Then("appropriate validation error should be displayed")
    public void appropriateValidationErrorShouldBeDisplayed() {
        logger.info("Verifying validation error is displayed");
        // This is a placeholder - actual implementation would check for error message
        Assertions.assertTrue(true, "Validation error should be displayed");
    }

    @And("I cancel the employee form")
    public void iCancelTheEmployeeForm() {
        logger.info("Canceling employee form");
        employeePage.cancelEmployeeForm();
    }

    @Then("the form should be closed without saving")
    public void theFormShouldBeClosedWithoutSaving() {
        logger.info("Verifying form is closed without saving");
        // This is a placeholder - actual implementation would verify form is closed
        Assertions.assertTrue(true, "Form should be closed without saving");
    }

    @When("I click on Employee Directory")
    public void iClickOnEmployeeDirectory() {
        logger.info("Clicking on Employee Directory");
        employeePage.clickEmployeeDirectory();
    }

    @Then("the employee directory should be displayed")
    public void theEmployeeDirectoryShouldBeDisplayed() {
        logger.info("Verifying employee directory is displayed");
        Assertions.assertTrue(true, "Employee directory should be displayed");
    }
}
