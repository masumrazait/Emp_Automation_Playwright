Feature: Performance Management
  As a manager
  I want to create and manage performance reviews
  So that I can evaluate employee performance

  Scenario: Verify performance management page is accessible
    Given I navigate to the application URL
    When I navigate to Performance section
    Then the performance management page should be loaded
    And Performance Overview should be visible
    And Create Performance Review option should be visible

  Scenario: Create performance review with valid data
    Given I navigate to the application URL
    When I navigate to Performance section
    And I click on Create Performance Review
    And I fill performance review form with valid data
      | employee | rating | comments | reviewDate |
      | john.doe@example.com | 4 | Good performance throughout the quarter | 2024-01-30 |
    And I submit the performance review form
    Then the performance review should be created successfully

  Scenario: Create performance review with excellent rating
    Given I navigate to the application URL
    When I navigate to Performance section
    And I click on Create Performance Review
    And I fill performance review form with excellent rating
      | employee | rating | comments | reviewDate |
      | jane.doe@example.com | 5 | Exceptional performance, exceeded all expectations | 2024-01-30 |
    And I submit the performance review form
    Then the performance review should be created successfully

  Scenario: Cancel performance review form
    Given I navigate to the application URL
    When I navigate to Performance section
    And I click on Create Performance Review
    And I fill performance review form with valid data
      | employee | rating | comments |
      | test@example.com | 3 | Test review |
    And I cancel the performance review form
    Then the form should be closed without saving

  Scenario: View performance reviews
    Given I navigate to the application URL
    When I navigate to Performance section
    And I click on Performance Reviews
    Then the performance reviews list should be displayed
    And performance ratings should be visible
