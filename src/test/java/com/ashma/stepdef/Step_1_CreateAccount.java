package com.ashma.stepdef;

import com.ashma.BaseTest;
import com.ashma.page.P01_createAccountPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Step_1_CreateAccount extends BaseTest {

    P01_createAccountPage createAccountPage;


    // Constructor
    public Step_1_CreateAccount() {
        createAccountPage = new P01_createAccountPage(driver);
    }

    // Background steps
    @Given("user is on the homepage")
    public void user_is_on_the_homepage() {
        createAccountPage.goToHomepage();
    }

    @When("user clicks the Create button")
    public void userClicksTheCreateButton() {
        createAccountPage.clickCreateButton();
    }

    @Then("user is navigated to the create account page")
    public void user_is_navigated_to_the_create_account_page() {
        createAccountPage.verifyCreateAccountPage();
    }

    // Step definitions for creating an account with valid data
    @Given("user is on the create account page")
    public void user_is_on_the_create_account_page() {
        createAccountPage.verifyCreateAccountPage();
    }

    @And("user inputs {string} with {string}")
    public void user_inputs_with(String fieldName, String value) {
        createAccountPage.inputField(fieldName, value); // Input the specified value into the field
    }

    @When("user clicks the {string} button")
    public void user_clicks_the_button(String buttonName) {
        createAccountPage.submitCreateAccount();
    }

    @Then("user is redirected to the {string} page")
    public void userIsRedirectedToThePage(String expectedPage) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.urlMatches("https://magento.softwaretestingboard.com/customer/account/"));

    }

    // Step definitions for creating an account with missing mandatory fields
    @And("user leaves {string} empty")
    public void user_leaves_empty(String fieldName) {
    }

    @Then("user is shown an error message {string}")
    public void user_is_shown_an_error_message(String errorMessage) {
        createAccountPage.verifyErrorMessage(errorMessage);
    }

}
