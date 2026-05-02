Feature: Leave Management
  As an employee
  I want to submit and manage leave requests
  So that I can request time off when needed

  Scenario: Verify leave management page is accessible
    Given I navigate to the application URL
    When I navigate to Leave section
    Then the leave management page should be loaded
    And Submit Leave Request option should be visible
    And Leave Requests option should be visible

  Scenario: Submit leave request with valid data
    Given I navigate to the application URL
    When I navigate to Leave section
    And I click on Submit Leave Request
    And I fill leave request form with valid data
      | leaveType | reason | startDate | endDate | days |
      | Annual Leave | Personal vacation | 2024-02-01 | 2024-02-05 | 5 |
    And I submit the leave request
    Then the leave request should be submitted successfully

  Scenario: Submit leave request with invalid date range
    Given I navigate to the application URL
    When I navigate to Leave section
    And I click on Submit Leave Request
    And I fill leave request form with invalid date range
      | leaveType | reason | startDate | endDate | days |
      | Sick Leave | Medical appointment | 2024-02-10 | 2024-02-05 | 5 |
    Then appropriate validation error should be displayed

  Scenario: Cancel leave request form
    Given I navigate to the application URL
    When I navigate to Leave section
    And I click on Submit Leave Request
    And I fill leave request form with valid data
      | leaveType | reason | startDate | endDate |
      | Personal Leave | Family event | 2024-03-01 | 2024-03-03 |
    And I cancel the leave request form
    Then the form should be closed without saving

  Scenario: View leave requests
    Given I navigate to the application URL
    When I navigate to Leave section
    And I click on Leave Requests
    Then the leave requests list should be displayed
