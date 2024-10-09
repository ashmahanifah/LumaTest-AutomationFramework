@createAccount
Feature: Create Account

  Background:
    Given user is on the homepage
    When user clicks the Create button
    Then user is navigated to the create account page

  @createWithValidData
  Scenario: Create an Account with mandatory fields
    Given user is on the create account page
    And user inputs "First Name" with "Tyler"
    And user inputs "Last Name" with "Agatha"
    And user inputs "Email" with "set10@set.com"
    And user inputs "Password" with "P@ssw0rd"
    And user inputs "Confirm Password" with "P@ssw0rd"
    When user clicks the "Create an Account" button
    Then user is redirected to the "My Account" page

  @createWithInvalidData
  Scenario: Create an Account with missing mandatory fields
    Given user is on the create account page
    And user leaves "First Name" empty
    And user inputs "Last Name" with "Joy"
    And user inputs "Email" with "wgwgwgwg@gmail.com"
    And user inputs "Password" with "P@ssw0rd"
    And user inputs "Confirm Password" with "P@ssw0rd"
    When user clicks the "Create an Account" button
    Then user is shown an error message "This is a required field."
