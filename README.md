## Objective
To develop an automated test framework that evaluates the quality and functionality of the LUMA e-commerce website, ensuring that key features such as product search, checkout, and create user account meet quality standards.

## Tools & Framework
1. Cucumber - is used for behavior-driven development (BDD). It supports the reusability of steps, across multiple scenarios. It also generates comprehensive test reports.
2. Java - is used to implement the test automation framework. 
3. Gradle - is used as the build automation tool for managing dependencies, compiling code, and running tests. 
4. Selenium - is used as the core automation tool used to interact with the browser and simulate user actions.
5. Intellij Idea - is used as IDE.

## Steps to Prepare and Build the Test Framework
1. **Set up a Gradle Project.**
Start by creating a Gradle project and configuring the necessary dependencies, such as Cucumber, Selenium, and JUnit. 

2. **Implement the Page Object Model (POM).**
Adopting POM pattern means each webpage of the LUMA website is represented as a separate Java class. These classes contain locators (finders) and methods to interact with elements on the page.

3. **Write Test Cases in Gherkin Syntax.**
Use Gherkin syntax to define the test cases. Each test case should describe the expected behavior of the website’s features.

4. **Execute Tests with Cucumber.**
Leverage the Cucumber library to link the Gherkin test cases with corresponding Java code and execute them. 

## Important config from the Test Framework
**1. . build.gradle**
  This is the build configuration file for the Gradle project. It specifies dependencies, such as:
  Cucumber for BDD support
  Selenium for web automation
  JUnit (or TestNG) for test execution It also defines tasks for running tests and generates reports. Key sections of this file typically include:
  dependencies: Lists libraries like Cucumber, Selenium, and JUnit.
  repositories: Defines where Gradle should look for dependencies (e.g., Maven Central).
  plugins: For applying Java, Cucumber, or reporting tasks.

**2. POM (Page Object Model) Folder (page directory)**
  This folder contains Java classes representing each page of the website being tested. For example:
  
  - P01_createAccountPage: Contains locators and methods to interact with the "Create Account" page elements.
  - P02_signInPage: Handles interactions with the "Sign In" page.
  - P03_SearchPage: Deals with the search and checkout product functionality.

**3. stepdef Folder (Step Definitions)**
  This contains the step definition files that link the Gherkin steps in .feature files (Folder resources) to the actual code that performs those steps. For example:
  
  - Step_1_CreateAccount: Contains the step definitions for the steps in the __F01_CreateAccount.feature__ file.
  - Step_2_SignIn: Maps to steps for the __F02_Sign_In.feature.__
  - Step_3_CO: Refers to checkout steps, for the __F03_Checkout.feature.__
  These files include the actual Selenium code that interacts with the web pages, clicking buttons, entering text, etc.

**4. Resources Folder (Feature Files)**
  This folder contains the sample .feature files written in Gherkin syntax. 
  - F01_CreateAccount.feature: Describes test scenarios for creating an account on the website. There are positive & negative cases to test.
  - F02_Sign_In.feature: Details the scenario for signing in, covering positive & negative test scenarios.
  - F03_Checkout.feature: Contains scenarios for checkout process, including positive test & negative test case that also serve as edge test case.

**5. CucumberHooks.**
  This file contains hooks, which are special methods in Cucumber that execute before and after each scenario or step.

**6. BaseTest.**
  This is a base class for all tests. It might include WebDriver initialization & Browser configuration.

**7. CucumberTest.**
  This file acts as the main runner for the test Framework. It will include the Cucumber options, such as:
  - Feature file paths,
  - Glue paths: Defining where the step definition files are located,
  - Plugin configurations: To generate reports in HTML or JSON format.

**8. Folder Reports.**
  This folder is where the Cucumber reports are generated. Reports like hasil.html and hasil.json are produced after test execution. They include:
  - Test results (pass/fail)
  - Scenario details
  - Execution time
  - Error logs (if any)


## How to Run
There are several ways to run the test in IntelliJ IDE. Below are some methods to run the test.

1. Open CucumberTest.java and click the Run icon.
2. Open any .feature file and click the Run icon next to the feature or scenario name.
3. Execute ./gradlew test in the terminal.
