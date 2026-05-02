# Employee Management System Automation Framework

## Overview
This is an enterprise-level automation framework built with **Playwright Java**, **Cucumber BDD**, and **Maven**. It provides comprehensive test automation for the Employee Management System application.

## Technology Stack
- **Language**: Java 17
- **Build Tool**: Maven
- **Automation Tool**: Playwright (v1.40.0)
- **BDD Framework**: Cucumber (v7.14.0)
- **Testing Framework**: JUnit 5
- **Logging**: Log4j 2
- **Assertion Library**: AssertJ

## Project Structure
```
Emp_Automation/
├── src/
│   ├── main/
│   │   ├── java/com/automation/
│   │   │   ├── base/
│   │   │   │   └── BaseTest.java
│   │   │   ├── pages/
│   │   │   │   ├── BasePage.java
│   │   │   │   ├── HomePage.java
│   │   │   │   ├── EmployeePage.java
│   │   │   │   ├── LeavePage.java
│   │   │   │   ├── TaskPage.java
│   │   │   │   ├── ContactPage.java
│   │   │   │   └── PerformancePage.java
│   │   │   └── utils/
│   │   │       ├── ConfigReader.java
│   │   │       └── TestDataReader.java
│   │   └── resources/
│   │       ├── config/
│   │       │   └── config.properties
│   │       └── log4j2.xml
│   └── test/
│       ├── java/com/automation/
│       │   ├── hooks/
│       │   │   └── Hooks.java
│       │   ├── runners/
│       │   │   └── TestRunner.java
│       │   └── stepdefinitions/
│       │       ├── HomePageSteps.java
│       │       ├── EmployeeManagementSteps.java
│       │       ├── LeaveManagementSteps.java
│       │       ├── TaskManagementSteps.java
│       │       ├── ContactPageSteps.java
│       │       └── PerformanceManagementSteps.java
│       └── resources/
│           ├── features/
│           │   ├── HomePage.feature
│           │   ├── EmployeeManagement.feature
│           │   ├── LeaveManagement.feature
│           │   ├── TaskManagement.feature
│           │   ├── ContactPage.feature
│           │   └── PerformanceManagement.feature
│           └── testdata/
│               └── testdata.properties
├── pom.xml
└── README.md
```

## Prerequisites
- Java JDK 17 or higher
- Maven 3.6 or higher
- IDE (IntelliJ IDEA recommended)

## Setup Instructions

### 1. Clone the Project
```bash
git clone <repository-url>
cd Emp_Automation
```

### 2. Install Dependencies
```bash
mvn clean install
```

### 3. Install Playwright Browsers
```bash
mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="install"
```

### 4. Configure Application
Edit `src/main/resources/config/config.properties` to configure:
- Application URL
- Browser settings
- Timeout values
- Screenshot settings

### 5. Configure Test Data
Edit `src/test/resources/testdata/testdata.properties` to update test data values.

## Running Tests

### Run All Tests
```bash
mvn test
```

### Run Specific Feature File
```bash
mvn test -Dcucumber.options="src/test/resources/features/HomePage.feature"
```

### Run Specific Scenario
```bash
mvn test -Dcucumber.options="--name='Verify home page is loaded successfully'"
```

### Run in Headless Mode
Set `browser.headless=true` in `config.properties`

### Run with Specific Browser
Set `browser.type=chromium` (or `firefox`, `webkit`) in `config.properties`

## Configuration

### Browser Configuration
- `browser.type`: chromium, firefox, or webkit
- `browser.headless`: true or false
- `browser.timeout`: timeout in milliseconds
- `browser.viewport.width`: viewport width
- `browser.viewport.height`: viewport height

### Application Configuration
- `app.url`: application base URL
- `app.title`: expected page title

### Screenshot Configuration
- `screenshot.on.failure`: true or false
- `screenshot.path`: path to save screenshots

## Test Reports
After test execution, reports are generated in:
- `target/cucumber-reports/cucumber-pretty.html` - HTML report
- `target/cucumber-reports/CucumberTestReport.json` - JSON report
- `target/cucumber-reports/CucumberTestReport.xml` - JUnit XML report

## Screenshots
Screenshots are captured on test failures and saved in:
- `./screenshots/` directory

## Logs
Application logs are saved in:
- `./logs/automation.log`

## Feature Files

### HomePage.feature
- Home page navigation
- Analytics verification
- Statistics display
- Navigation between sections

### EmployeeManagement.feature
- Add new employee
- Employee directory
- Form validation

### LeaveManagement.feature
- Submit leave requests
- View leave requests
- Form validation

### TaskManagement.feature
- Create new tasks
- Task list management
- Priority handling

### ContactPage.feature
- Contact form submission
- Office information display
- Form validation

### PerformanceManagement.feature
- Create performance reviews
- View performance reviews
- Rating management

## Page Object Model
The framework uses the Page Object Model pattern:
- **BasePage**: Common page methods
- **HomePage**: Home page interactions
- **EmployeePage**: Employee management interactions
- **LeavePage**: Leave management interactions
- **TaskPage**: Task management interactions
- **ContactPage**: Contact page interactions
- **PerformancePage**: Performance management interactions

## Best Practices
1. Use property files for test data
2. Follow Page Object Model pattern
3. Use descriptive step definitions
4. Add proper logging
5. Handle exceptions gracefully
6. Use assertions for validation
7. Keep locators in page classes
8. Use data tables for parameterized tests

## Troubleshooting

### Browser Installation Issues
```bash
mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="install"
```

### Port Already in Use
Change the port or kill the process using the port.

### Timeout Issues
Increase timeout values in `config.properties`

### Element Not Found
- Verify locators are correct
- Increase wait time
- Check if element is in iframe

## Contributing
1. Create feature branch
2. Add/update tests
3. Ensure all tests pass
4. Submit pull request

## License
This project is licensed under the MIT License.

## Contact
For questions or issues, please contact the automation team.
