Feature: Home Page Functionality
  As a user of the Employee Management System
  I want to access and interact with the home page
  So that I can view analytics and navigate to different sections

  Scenario: Verify home page is loaded successfully
    Given I navigate to the application URL
    Then the home page should be loaded
    And the page title should be "Mannat Tech 2026 - Enterprise Employee Management System"
    And the analytics section should be visible

  Scenario: Verify statistics are displayed on home page
    Given I navigate to the application URL
    Then the statistics section should be visible
    And Total Employees should be displayed
    And Active Today should be displayed
    And Pending Leaves should be displayed
    And Total Tasks should be displayed

  Scenario: Verify analytics sections are visible
    Given I navigate to the application URL
    Then Weekly Activity section should be visible
    And Department Distribution section should be visible
    And Recent Activity section should be visible

  Scenario: Navigate to different sections from home page
    Given I navigate to the application URL
    When I navigate to Timing section
    Then the timing page should be loaded
    When I navigate to Employee section
    Then the employee page should be loaded
    When I navigate to Leave section
    Then the leave page should be loaded
    When I navigate to Tasks section
    Then the tasks page should be loaded
    When I navigate to Team section
    When I navigate to Reports section
    When I navigate to Performance section
    When I navigate to Contact section
    When I navigate to Settings section
