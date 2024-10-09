package com.ashma.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class P03_SearchPage {
    WebDriver driver;
    WebDriverWait wait;

    //Locators search until proceed CO
    By SearchBox = By.cssSelector("input#search");
    By productLink = By.xpath("//a[contains(text(),'Driven Backpack')]");
    By addToCartButton = By.id("product-addtocart-button");
    By cartIcon = By.cssSelector("div.minicart-wrapper");
    By proceedToCheckoutButton = By.cssSelector("button#top-cart-btn-checkout");
    //Cart Locator
    By cartCount = By.cssSelector(".counter-number");
    By cartCounterContainer = By.cssSelector(".counter.qty");
    //Form CO Locator till end
    By companyInput = By.cssSelector("input.input-text[name='company']");
    By addressInput = By.cssSelector("input.input-text[name='street[0]']");
    By countrySelect = By.cssSelector("select.select[name='country_id']");
    By cityInput = By.cssSelector("input.input-text[name='city']");
    By stateInput = By.cssSelector("input.input-text[name='region']");
    By postalInput = By.cssSelector("input.input-text[name='postcode']");
    By phoneInput = By.cssSelector("input.input-text[name='telephone']");
    By shippingRadioButton = By.cssSelector("input.radio");
    By nextButton = By.xpath("//span[contains(text(),'Next')]");
    By placeOrderButton = By.xpath("//button[@data-role='opc-continue']");
    By errorNoResultProduct = By.xpath("//div[contains(text(),'Minimum Search query length is 3')]");


    // Constructor
    public P03_SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void verifyHomePage() {
        String expectedUrl = "https://magento.softwaretestingboard.com/";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl, "User is not on the Home page.");
    }

    public void clickSearchBox() {
        driver.findElement(SearchBox).click();
    }

    public void inputSearchKeyword(String keyword) {
        driver.findElement(SearchBox).sendKeys(keyword);
        driver.findElement(SearchBox).sendKeys(Keys.ENTER);
    }

    public void clickProduct() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productURL = driver.findElement(productLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", productURL);
    }

    public void clickAddToCartButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.findElement(addToCartButton).click();
        WebDriverWait waitAgain = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickCartIcon() {
        boolean isCartVisible = driver.findElement(cartCounterContainer).isDisplayed();

        if (!isCartVisible) {
            // If cart counter is hidden (i.e., cart is empty), wait until the cart becomes visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(cartCount));
        } else {
            // If the cart counter is visible, capture the initial count
            String initialCount = driver.findElement(cartCount).getText();

            // Wait for the cart count to update after adding an item to the cart
            wait.until(ExpectedConditions.not(
                    ExpectedConditions.textToBe(cartCount, initialCount)
            ));
        }
        driver.findElement(cartIcon).click();
    }

    public void clickProceedToCheckoutButton() {
        driver.findElement(proceedToCheckoutButton).click();
    }

    // Actions

    public void verifyShippingPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String expectedUrl = "https://magento.softwaretestingboard.com/checkout/#shipping";

        // Wait until the URL changes to the expected URL
        wait.until(ExpectedConditions.urlContains(expectedUrl));
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl, "User is not on the Checkout (Shipping) page.");

    }

    public void inputCompany(String company) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Wait until the company input field is visible
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(companyInput));

        // Send keys to the input field
        inputField.sendKeys(company);

    }

    public void inputAddress(String address) {
        driver.findElement(addressInput).sendKeys(address);
    }

    public void selectCountry(String country) {

        // Find the dropdown using the located element
        WebElement countryDropdown = driver.findElement(countrySelect);

        // Create an instance of the Select class and pass the dropdown WebElement
        Select selectCountry = new Select(countryDropdown);

        // Select the option "Indonesia" by visible text
        selectCountry.selectByVisibleText(country);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void inputCity(String city) {
        driver.findElement(cityInput).sendKeys(city);
    }

    public void inputState(String state) {
        driver.findElement(stateInput).sendKeys(state);
    }

    public void inputPostalCode(String postalCode) {
        driver.findElement(postalInput).sendKeys(postalCode);
    }

    public void inputPhone(String phone) {
        driver.findElement(phoneInput).sendKeys(phone);
    }

    public void setShippingRadioButton() {
        WebElement radioButton = wait.until(ExpectedConditions.visibilityOfElementLocated(shippingRadioButton));
        if (!radioButton.isSelected()) {
            radioButton.click();
        }
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void clickPlaceOrderButton() throws InterruptedException {
        WebElement buttonContinue;
        boolean pageChanged = false;

        for (int i = 0; i < 3; i++) {
            try {
                // Wait until the loading mask is no longer visible
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loading-mask[data-role='loader']")));

                // Wait for the button to be clickable
                buttonContinue = wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
                buttonContinue.click();

                // Wait after click. allowing navigation to happen
                Thread.sleep(2000);

                // Check if the page has changed; expecting used is redirected to another different page

                if (!Objects.equals(driver.getCurrentUrl(), "expected_url_after_click")) {
                    pageChanged = true;
                    break; // Exit loop if the page has changed
                }
            } catch (ElementClickInterceptedException e) {
                // Wait a short period before retrying
                Thread.sleep(500);
            } catch (TimeoutException e) {
                System.out.println("Button not clickable after waiting.");
                break; // Exit loop if button is not clickable after attempts
            }
        }

        if (!pageChanged) {
            System.out.println("Still on the same page after multiple attempts.");
        }


    }


    public void validateSuccessCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement secondPlaceOrderButton = driver.findElement(By.xpath("//button[@title='Place Order']"));

        secondPlaceOrderButton.click();
        WebDriverWait waitAgain = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    public void displayValidationMessageSuccess() {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Wait until the loading mask is not visible
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loading-mask[data-role='loader']")));

            // Locate the 'Place Order' button
            WebElement secondPlaceOrderButton = driver.findElement(By.xpath("//button[@title='Place Order']"));

            // Check if the button is still visible
            if (secondPlaceOrderButton.isDisplayed()) {
                // If visible, click the button
                secondPlaceOrderButton.click();
                System.out.println("Place Order button is visible and clicked.");
            } else {
                // If not visible, skip the action
                System.out.println("Place Order button is not visible. Skipping.");
            }
        } catch (NoSuchElementException e) {

            System.out.println("Place Order button not found. Skipping.");
        } catch (ElementClickInterceptedException e) {

            System.out.println("Place Order button click was intercepted. Skipping.");
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        String expectedUrl = "https://magento.softwaretestingboard.com/checkout/onepage/success/";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl, "User is not on the success page.");

    }


    public void validateErrorNoResultAppear(String expectedErrorMessage) {
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorNoResultProduct));
        String actualErrorMessage = errorElement.getText();
        assertTrue(actualErrorMessage.contains(expectedErrorMessage));
    }


}