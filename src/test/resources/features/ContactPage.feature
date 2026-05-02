Feature: Contact Us Functionality
  As a user
  I want to contact the support team
  So that I can get assistance with my queries

  Scenario: Verify contact page is accessible
    Given I navigate to the application URL
    When I navigate to Contact section
    Then the contact page should be loaded
    And the office information section should be visible

  Scenario: Verify office information is displayed correctly
    Given I navigate to the application URL
    When I navigate to Contact section
    Then the office address should be displayed
    And the office phone number should be displayed
    And the office email should be displayed

  Scenario: Send contact message with valid data
    Given I navigate to the application URL
    When I navigate to Contact section
    And I fill contact form with valid data
      | name | email | subject | message |
      | Test User | test@example.com | Test Inquiry | This is a test message for automation testing |
    And I send the contact form
    Then the message should be sent successfully

  Scenario: Send contact message with invalid email
    Given I navigate to the application URL
    When I navigate to Contact section
    And I fill contact form with invalid email
      | name | email | subject | message |
      | Test User | invalid-email | Test Subject | Test message |
    Then appropriate validation error should be displayed

  Scenario: Reset contact form
    Given I navigate to the application URL
    When I navigate to Contact section
    And I fill contact form with valid data
      | name | email | subject |
      | Reset Test | reset@example.com | Reset Subject |
    And I reset the contact form
    Then the form fields should be cleared
