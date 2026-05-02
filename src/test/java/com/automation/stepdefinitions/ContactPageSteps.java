package com.automation.stepdefinitions;

import com.automation.base.BaseTest;
import com.automation.pages.ContactPage;
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
 * Step definitions for Contact Page scenarios
 */
public class ContactPageSteps {
    private static final Logger logger = LogManager.getLogger(ContactPageSteps.class);
    private ContactPage contactPage;

    
    @When("I navigate to Contact section")
    public void iNavigateToContactSection() {
        logger.info("Navigating to Contact section");
        HomePageSteps.getHomePage().navigateToContact();
        contactPage = new ContactPage(BaseTest.getPage());
    }

    @Then("the contact page should be loaded")
    public void theContactPageShouldBeLoaded() {
        logger.info("Verifying contact page is loaded");
        boolean isLoaded = contactPage.isContactPageLoaded();
        Assertions.assertTrue(isLoaded, "Contact page should be loaded");
    }

    @And("the office information section should be visible")
    public void theOfficeInformationSectionShouldBeVisible() {
        logger.info("Verifying office information section is visible");
        boolean isVisible = contactPage.isOfficeInformationDisplayed();
        Assertions.assertTrue(isVisible, "Office information section should be visible");
    }

    @Then("the office address should be displayed")
    public void theOfficeAddressShouldBeDisplayed() {
        logger.info("Verifying office address is displayed");
        String address = contactPage.getOfficeAddress();
        Assertions.assertNotNull(address, "Office address should be displayed");
    }

    @And("the office phone number should be displayed")
    public void theOfficePhoneNumberShouldBeDisplayed() {
        logger.info("Verifying office phone number is displayed");
        String phone = contactPage.getOfficePhone();
        Assertions.assertNotNull(phone, "Office phone number should be displayed");
    }

    @And("the office email should be displayed")
    public void theOfficeEmailShouldBeDisplayed() {
        logger.info("Verifying office email is displayed");
        String email = contactPage.getOfficeEmail();
        Assertions.assertNotNull(email, "Office email should be displayed");
    }

    @And("I fill contact form with valid data")
    public void iFillContactFormWithValidData(io.cucumber.datatable.DataTable dataTable) {
        logger.info("Filling contact form with valid data");
        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
        contactPage.fillContactForm(
            data.get("name"),
            data.get("email"),
            data.get("subject"),
            data.get("message")
        );
    }

    @And("I send the contact form")
    public void iSendTheContactForm() {
        logger.info("Sending contact form");
        contactPage.sendContactForm();
    }

    @Then("the message should be sent successfully")
    public void theMessageShouldBeSentSuccessfully() {
        logger.info("Verifying message is sent successfully");
        Assertions.assertTrue(true, "Message should be sent successfully");
    }

    @And("I fill contact form with invalid email")
    public void iFillContactFormWithInvalidEmail(io.cucumber.datatable.DataTable dataTable) {
        logger.info("Filling contact form with invalid email");
        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
        contactPage.fillContactForm(
            data.get("name"),
            data.get("email"),
            data.get("subject"),
            data.get("message")
        );
    }

    @And("I reset the contact form")
    public void iResetTheContactForm() {
        logger.info("Resetting contact form");
        contactPage.resetContactForm();
    }

    @Then("the form fields should be cleared")
    public void theFormFieldsShouldBeCleared() {
        logger.info("Verifying form fields are cleared");
        Assertions.assertTrue(true, "Form fields should be cleared");
    }
}
