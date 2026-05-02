package com.automation.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Test Runner class for Cucumber BDD tests
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.automation.stepdefinitions", "com.automation.hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty.html",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "junit:target/cucumber-reports/CucumberTestReport.xml"
        },
        monochrome = true,
        dryRun = false
)
public class TestRunner {
    // This class runs the Cucumber tests
}
