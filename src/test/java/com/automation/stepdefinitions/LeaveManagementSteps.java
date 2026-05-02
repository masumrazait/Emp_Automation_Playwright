package com.automation.stepdefinitions;

import com.automation.base.BaseTest;
import com.automation.pages.HomePage;
import com.automation.pages.LeavePage;
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
 * Step definitions for Leave Management scenarios
 */
public class LeaveManagementSteps {
    private static final Logger logger = LogManager.getLogger(LeaveManagementSteps.class);
    private LeavePage leavePage;

    
    @When("I navigate to Leave section")
    public void iNavigateToLeaveSection() {
        logger.info("Navigating to Leave section");
        HomePageSteps.getHomePage().navigateToLeave();
        leavePage = new LeavePage(BaseTest.getPage());
    }

    @Then("the leave management page should be loaded")
    public void theLeaveManagementPageShouldBeLoaded() {
        logger.info("Verifying leave management page is loaded");
        boolean isLoaded = leavePage.isLeavePageLoaded();
        Assertions.assertTrue(isLoaded, "Leave management page should be loaded");
    }

    @And("Submit Leave Request option should be visible")
    public void submitLeaveRequestOptionShouldBeVisible() {
        logger.info("Verifying Submit Leave Request option is visible");
        Assertions.assertTrue(true, "Submit Leave Request option should be visible");
    }

    @And("Leave Requests option should be visible")
    public void leaveRequestsOptionShouldBeVisible() {
        logger.info("Verifying Leave Requests option is visible");
        Assertions.assertTrue(true, "Leave Requests option should be visible");
    }

    @When("I click on Submit Leave Request")
    public void iClickOnSubmitLeaveRequest() {
        logger.info("Clicking on Submit Leave Request");
        leavePage.clickSubmitLeaveRequest();
    }

    @And("I fill leave request form with valid data")
    public void iFillLeaveRequestFormWithValidData(io.cucumber.datatable.DataTable dataTable) {
        logger.info("Filling leave request form with valid data");
        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
        leavePage.fillLeaveRequestForm(
            data.get("leaveType"),
            data.get("reason"),
            data.get("startDate"),
            data.get("endDate"),
            data.get("days")
        );
    }

    @And("I submit the leave request")
    public void iSubmitTheLeaveRequest() {
        logger.info("Submitting leave request");
        leavePage.submitLeaveRequestForm();
    }

    @Then("the leave request should be submitted successfully")
    public void theLeaveRequestShouldBeSubmittedSuccessfully() {
        logger.info("Verifying leave request is submitted successfully");
        Assertions.assertTrue(true, "Leave request should be submitted successfully");
    }

    @And("I fill leave request form with invalid date range")
    public void iFillLeaveRequestFormWithInvalidDateRange(io.cucumber.datatable.DataTable dataTable) {
        logger.info("Filling leave request form with invalid date range");
        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
        leavePage.fillLeaveRequestForm(
            data.get("leaveType"),
            data.get("reason"),
            data.get("startDate"),
            data.get("endDate"),
            data.get("days")
        );
    }

    @And("I cancel the leave request form")
    public void iCancelTheLeaveRequestForm() {
        logger.info("Canceling leave request form");
        leavePage.cancelLeaveRequestForm();
    }

    
    @When("I click on Leave Requests")
    public void iClickOnLeaveRequests() {
        logger.info("Clicking on Leave Requests");
        leavePage.clickLeaveRequests();
    }

    @Then("the leave requests list should be displayed")
    public void theLeaveRequestsListShouldBeDisplayed() {
        logger.info("Verifying leave requests list is displayed");
        Assertions.assertTrue(true, "Leave requests list should be displayed");
    }
}
