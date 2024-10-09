package com.ashma.stepdef;
import com.ashma.page.P01_createAccountPage;
import com.ashma.page.P03_SearchPage;
import com.ashma.BaseTest;
import io.cucumber.java.en.*;

public class Step_3_CO extends BaseTest {

    P01_createAccountPage createAccountPage;
    P03_SearchPage searchPage;

    // Constructor
    public Step_3_CO() {
        // Initialize the search page object here
        createAccountPage = new P01_createAccountPage(driver);
        searchPage = new P03_SearchPage(driver); // Ensure `driver` is available from BaseTest
    }

    @Given("signed-in user is on homepage")
    public void signedInUserIsOnHomepage() {
        createAccountPage.goToHomepage();
    }

    @And("user click search button")
    public void userClickSearchButton() {
        searchPage.clickSearchBox();
    }

    @And("user input keyword with {string}")
    public void userInputWith(String keyword) {
        searchPage.inputSearchKeyword(keyword);
    }

    @And("user click the product")
    public void userClickTheProduct() {
        searchPage.clickProduct();

    }

    @And("user click add to cart button")
    public void userClickAddToCartButton() {
        searchPage.clickAddToCartButton();
    }

    @And("user click cart icon in header")
    public void userClickCartIconInHeader() {
        searchPage.clickCartIcon();
    }

    @And("user click proceed to checkout button")
    public void userClickProceedToCheckoutButton() {
        searchPage.clickProceedToCheckoutButton();
    }

    @And("user input company with {string}")
    public void userInputCompanyWith(String company) {
        searchPage.verifyShippingPage();
        searchPage.inputCompany(company);
    }

    @And("user input address with {string}")
    public void userInputAddressWith(String address) {
        searchPage.inputAddress(address);
    }

    @And("user selects country with {string}")
    public void userSelectsCountryWith(String country) {
        searchPage.selectCountry(country);
    }

    @And("user input city with {string}")
    public void userInputCityWith(String city) {
        searchPage.inputCity(city);
    }

    @And("user input state with {string}")
    public void userInputStateWith(String state) {
        searchPage.inputState(state);
    }

    @And("user input postal code with {string}")
    public void userInputPostalCodeWith(String postalCode) {
        searchPage.inputPostalCode(postalCode);
    }

    @And("user input phone with {string}")
    public void userInputPhoneWith(String phoneNumber) {
        searchPage.inputPhone(phoneNumber);
    }

    @And("user select one of the shipping method")
    public void userSelectOneOfTheShippingMethod() {
        searchPage.setShippingRadioButton();
    }

    @And("user click next button")
    public void userClickNextButton() {
        searchPage.clickNextButton();
    }

    @And("user Click place order button")
    public void userClickPlaceOrderButton() throws InterruptedException {
        searchPage.clickPlaceOrderButton();
    }


    @Then("user able to see error {string}")
    public void userAbleToSeeError(String error) {
        searchPage.validateErrorNoResultAppear(error);
    }

    @And("user is navigated to the success checkout page")
    public void userIsNavigatedToTheSuccessCheckoutPage() {
        searchPage.validateSuccessCheckout();
    }

    @Then("user able to see success validation message")
    public void userAbleToSeeSuccessValidationMessage() {
        searchPage.displayValidationMessageSuccess();
    }
}
