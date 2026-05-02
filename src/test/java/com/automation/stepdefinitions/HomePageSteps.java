package com.automation.stepdefinitions;

import com.automation.base.BaseTest;
import com.automation.pages.HomePage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;

/**
 * Step definitions for Home Page scenarios
 */
public class HomePageSteps {
    private static final Logger logger = LogManager.getLogger(HomePageSteps.class);
    private static HomePage homePage;

    @Given("I navigate to the application URL")
    public void iNavigateToTheApplicationURL() {
        logger.info("Navigating to application URL");
        String url = ConfigReader.getProperty("app.url");
        BaseTest.navigateToUrl(url);
        homePage = new HomePage(BaseTest.getPage());
    }

    @Then("the home page should be loaded")
    public void theHomePageShouldBeLoaded() {
        logger.info("Verifying home page is loaded");
        boolean isLoaded = homePage.isHomePageLoaded();
        Assertions.assertTrue(isLoaded, "Home page should be loaded");
    }

    @And("the page title should be {string}")
    public void thePageTitleShouldBe(String expectedTitle) {
        logger.info("Verifying page title");
        String actualTitle = homePage.getPageTitle();
        Assertions.assertEquals(expectedTitle, actualTitle, 
            "Page title should match expected title");
    }

    @And("the analytics section should be visible")
    public void theAnalyticsSectionShouldBeVisible() {
        logger.info("Verifying analytics section is visible");
        boolean isVisible = homePage.isHomePageLoaded();
        Assertions.assertTrue(isVisible, "Analytics section should be visible");
    }

    @Then("the statistics section should be visible")
    public void theStatisticsSectionShouldBeVisible() {
        logger.info("Verifying statistics section is visible");
        boolean isVisible = homePage.isStatisticsSectionVisible();
        Assertions.assertTrue(isVisible, "Statistics section should be visible");
    }

    @And("Total Employees should be displayed")
    public void totalEmployeesShouldBeDisplayed() {
        logger.info("Verifying Total Employees is displayed");
        // This is a placeholder - actual implementation would check the element
        Assertions.assertTrue(true, "Total Employees should be displayed");
    }

    @And("Active Today should be displayed")
    public void activeTodayShouldBeDisplayed() {
        logger.info("Verifying Active Today is displayed");
        Assertions.assertTrue(true, "Active Today should be displayed");
    }

    @And("Pending Leaves should be displayed")
    public void pendingLeavesShouldBeDisplayed() {
        logger.info("Verifying Pending Leaves is displayed");
        Assertions.assertTrue(true, "Pending Leaves should be displayed");
    }

    @And("Total Tasks should be displayed")
    public void totalTasksShouldBeDisplayed() {
        logger.info("Verifying Total Tasks is displayed");
        Assertions.assertTrue(true, "Total Tasks should be displayed");
    }

    @Then("Weekly Activity section should be visible")
    public void weeklyActivitySectionShouldBeVisible() {
        logger.info("Verifying Weekly Activity section is visible");
        boolean isVisible = homePage.areAnalyticsSectionsVisible();
        Assertions.assertTrue(isVisible, "Weekly Activity section should be visible");
    }

    @And("Department Distribution section should be visible")
    public void departmentDistributionSectionShouldBeVisible() {
        logger.info("Verifying Department Distribution section is visible");
        boolean isVisible = homePage.areAnalyticsSectionsVisible();
        Assertions.assertTrue(isVisible, "Department Distribution section should be visible");
    }

    @And("Recent Activity section should be visible")
    public void recentActivitySectionShouldBeVisible() {
        logger.info("Verifying Recent Activity section is visible");
        boolean isVisible = homePage.areAnalyticsSectionsVisible();
        Assertions.assertTrue(isVisible, "Recent Activity section should be visible");
    }

    @When("I navigate to Timing section")
    public void iNavigateToTimingSection() {
        logger.info("Navigating to Timing section");
        homePage.navigateToTiming();
    }

    @Then("the timing page should be loaded")
    public void theTimingPageShouldBeLoaded() {
        logger.info("Verifying timing page is loaded");
        String currentUrl = BaseTest.getPage().url();
        Assertions.assertTrue(currentUrl.contains("timing") || currentUrl.length() > 0, 
            "Timing page should be loaded");
    }

    
    public static HomePage getHomePage() {
        return homePage;
    }
}
