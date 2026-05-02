Feature: Employee Management
  As an HR administrator
  I want to manage employee information
  So that I can maintain accurate employee records

  Scenario: Verify employee management page is accessible
    Given I navigate to the application URL
    When I navigate to Employee section
    Then the employee management page should be loaded
    And Add New Employee option should be visible
    And Employee Directory option should be visible

  Scenario: Add new employee with valid data
    Given I navigate to the application URL
    When I navigate to Employee section
    And I click on Add New Employee
    And I fill employee form with valid data
      | firstName | lastName | email | phone | department | designation | salary | joiningDate | address |
      | John | Doe | john.doe@example.com | +91 98765 43210 | Engineering | Software Engineer | 75000 | 2024-01-15 | 123, Tech Park, Bangalore |
    And I submit the employee form
    Then the employee should be added successfully

  Scenario: Add new employee with invalid email format
    Given I navigate to the application URL
    When I navigate to Employee section
    And I click on Add New Employee
    And I fill employee form with invalid email
      | firstName | lastName | email | phone | department | designation |
      | Jane | Smith | invalid-email | +91 98765 43211 | Marketing | Marketing Manager |
    Then appropriate validation error should be displayed

  Scenario: Cancel employee form
    Given I navigate to the application URL
    When I navigate to Employee section
    And I click on Add New Employee
    And I fill employee form with valid data
      | firstName | lastName | email | phone | department | designation |
      | Test | User | test@example.com | +91 98765 43212 | HR | HR Manager |
    And I cancel the employee form
    Then the form should be closed without saving

  Scenario: View employee directory
    Given I navigate to the application URL
    When I navigate to Employee section
    And I click on Employee Directory
    Then the employee directory should be displayed
