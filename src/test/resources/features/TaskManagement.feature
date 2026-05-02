Feature: Task Management
  As a manager
  I want to create and manage tasks for employees
  So that I can track work assignments and progress

  Scenario: Verify task management page is accessible
    Given I navigate to the application URL
    When I navigate to Tasks section
    Then the task management page should be loaded
    And Create New Task option should be visible
    And Task List option should be visible

  Scenario: Create new task with valid data
    Given I navigate to the application URL
    When I navigate to Tasks section
    And I click on Create New Task
    And I fill task form with valid data
      | title | description | priority | assignee | dueDate | status |
      | Complete Project Documentation | Create comprehensive documentation for the new project | High | john.doe@example.com | 2024-02-15 | In Progress |
    And I submit the task form
    Then the task should be created successfully

  Scenario: Create task with high priority
    Given I navigate to the application URL
    When I navigate to Tasks section
    And I click on Create New Task
    And I fill task form with high priority
      | title | description | priority | assignee | dueDate |
      | Urgent Bug Fix | Fix critical bug in production | High | jane.doe@example.com | 2024-01-30 |
    And I submit the task form
    Then the high priority task should be created

  Scenario: Cancel task form
    Given I navigate to the application URL
    When I navigate to Tasks section
    And I click on Create New Task
    And I fill task form with valid data
      | title | description | priority |
      | Test Task | This is a test task | Medium |
    And I cancel the task form
    Then the form should be closed without saving

  Scenario: View task list
    Given I navigate to the application URL
    When I navigate to Tasks section
    And I click on Task List
    Then the task list should be displayed
