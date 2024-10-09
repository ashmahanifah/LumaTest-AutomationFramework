package com.ashma.stepdef;
import com.ashma.BaseTest;
import com.ashma.page.P02_signInPage;
import io.cucumber.java.en.*;

public class Step_2_SignIn extends BaseTest{

    P02_signInPage signInPage;


    public Step_2_SignIn() {
        signInPage = new P02_signInPage(driver);
    }

    @When("user clicks the SignIn button")
    public void userClicksTheSignInButton() {
        signInPage.clickSignInHeader();
    }

    @Then("user is navigated to the SignIn page")
    public void userIsNavigatedToTheSignInPage() {
        signInPage.verifySignInPage();
    }

    @Given("user is on SignIn page")
    public void userIsOnSignInPage() {
        signInPage.verifySignInPage();
    }


    @And("user input email with {string}")
    public void userInputUsernameWith(String email) {
        signInPage.enterEmail(email);
    }

    @And("user input password with {string}")
    public void userInputPasswordWith(String password) {
        signInPage.enterPassword(password);
    }

    @When("user clicks Sign-In button")
    public void userClicksSignInButton() {
        signInPage.clickSignInButton();
    }

    @Then("user is navigated to the homepage")
    public void userIsNavigatedToTheHomepage() {
        signInPage.verifyHomePage();
    }

    @Then("user able to see error message {string}")
    public void userAbleToSeeErrorMessage(String expectedErrorMessage) {
        signInPage.validateErrorAppear(expectedErrorMessage);
    }

}
