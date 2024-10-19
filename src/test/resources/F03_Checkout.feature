@checkout
Feature: checkout

  Background:
    Given user is on the homepage
    And user clicks the SignIn button
    And user input email with "set14@set.com"
    And user input password with "P@ssw0rd"
    And user clicks Sign-In button
    Then user is navigated to the homepage

@search-and-CO-valid-Product
  Scenario: checkout-yes
    Given signed-in user is on homepage
    And user click search button
    And user input keyword with "backpack"
    And user click the product
    And user click add to cart button
    And user click cart icon in header
    And user click proceed to checkout button
    And user input company with "PLN"
    And user input address with "PIK"
    And user selects country with "Indonesia"
    And user input city with "Jakarta"
    And user input state with "Jakut"
    And user input postal code with "13510"
    And user input phone with "081380800535"
    And user select one of the shipping method
    And user click next button
    And user Click place order button
    And user is navigated to the success checkout page
    Then user able to see success validation message

  @search-invalid-data-edge-case
    Scenario: search not found
      Given signed-in user is on homepage
      And user click search button
      And user input keyword with "X"
      Then user able to see error "Minimum Search query length is 3"

