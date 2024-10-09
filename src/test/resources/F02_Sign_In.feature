@sign-in
Feature: Sign-In
  Background:
    Given user is on the homepage
    When user clicks the SignIn button
    Then user is navigated to the SignIn page

  @valid-sign-in
  Scenario: Sign In with valid data
    Given user is on SignIn page
    And user input email with "qwerty12345@qwerty.com"
    And user input password with "3vW33VmQXe8fsSH"
    When user clicks Sign-In button
    Then user is navigated to the homepage

  @invalid-sign-in
  Scenario: Sign In with invalid data
    Given user is on SignIn page
    And user input email with "qwerty12345@qwerty.com"
    And user input password with "invalid"
    When user clicks Sign-In button
    Then user able to see error message "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later."
