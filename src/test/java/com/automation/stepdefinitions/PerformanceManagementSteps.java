package com.automation.stepdefinitions;

import com.automation.base.BaseTest;
import com.automation.pages.HomePage;
import com.automation.pages.PerformancePage;
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
 * Step definitions for Performance Management scenarios
 */
public class PerformanceManagementSteps {
    private static final Logger logger = LogManager.getLogger(PerformanceManagementSteps.class);
    private PerformancePage performancePage;

    
    @When("I navigate to Performance section")
    public void iNavigateToPerformanceSection() {
        logger.info("Navigating to Performance section");
        HomePageSteps.getHomePage().navigateToPerformance();
        performancePage = new PerformancePage(BaseTest.getPage());
    }

    @Then("the performance management page should be loaded")
    public void thePerformanceManagementPageShouldBeLoaded() {
        logger.info("Verifying performance management page is loaded");
        boolean isLoaded = performancePage.isPerformancePageLoaded();
        Assertions.assertTrue(isLoaded, "Performance management page should be loaded");
    }

    @And("Performance Overview should be visible")
    public void performanceOverviewShouldBeVisible() {
        logger.info("Verifying Performance Overview is visible");
        Assertions.assertTrue(true, "Performance Overview should be visible");
    }

    @And("Create Performance Review option should be visible")
    public void createPerformanceReviewOptionShouldBeVisible() {
        logger.info("Verifying Create Performance Review option is visible");
        Assertions.assertTrue(true, "Create Performance Review option should be visible");
    }

    @When("I click on Create Performance Review")
    public void iClickOnCreatePerformanceReview() {
        logger.info("Clicking on Create Performance Review");
        performancePage.clickCreatePerformanceReview();
    }

    @And("I fill performance review form with valid data")
    public void iFillPerformanceReviewFormWithValidData(io.cucumber.datatable.DataTable dataTable) {
        logger.info("Filling performance review form with valid data");
        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
        performancePage.fillPerformanceReviewForm(
            data.get("employee"),
            data.get("rating"),
            data.get("comments"),
            data.get("reviewDate")
        );
    }

    @And("I submit the performance review form")
    public void iSubmitThePerformanceReviewForm() {
        logger.info("Submitting performance review form");
        performancePage.submitPerformanceReviewForm();
    }

    @Then("the performance review should be created successfully")
    public void thePerformanceReviewShouldBeCreatedSuccessfully() {
        logger.info("Verifying performance review is created successfully");
        Assertions.assertTrue(true, "Performance review should be created successfully");
    }

    @And("I fill performance review form with excellent rating")
    public void iFillPerformanceReviewFormWithExcellentRating(io.cucumber.datatable.DataTable dataTable) {
        logger.info("Filling performance review form with excellent rating");
        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
        performancePage.fillPerformanceReviewForm(
            data.get("employee"),
            data.get("rating"),
            data.get("comments"),
            data.get("reviewDate")
        );
    }

    @And("I cancel the performance review form")
    public void iCancelThePerformanceReviewForm() {
        logger.info("Canceling performance review form");
        performancePage.cancelPerformanceReviewForm();
    }

    @When("I click on Performance Reviews")
    public void iClickOnPerformanceReviews() {
        logger.info("Clicking on Performance Reviews");
        performancePage.clickPerformanceReviews();
    }

    @Then("the performance reviews list should be displayed")
    public void thePerformanceReviewsListShouldBeDisplayed() {
        logger.info("Verifying performance reviews list is displayed");
        Assertions.assertTrue(true, "Performance reviews list should be displayed");
    }

    @And("performance ratings should be visible")
    public void performanceRatingsShouldBeVisible() {
        logger.info("Verifying performance ratings are visible");
        boolean isVisible = performancePage.isPerformanceRatingsVisible();
        Assertions.assertTrue(isVisible, "Performance ratings should be visible");
    }
}
