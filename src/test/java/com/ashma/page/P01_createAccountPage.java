package com.ashma.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class P01_createAccountPage {
    WebDriver driver;

    // Locators
    By createButton = By.xpath("//ul[@class='header links']//a[text()='Create an Account']");
    By createAccountPageHeader = By.cssSelector("span.base");
    By firstNameField = By.id("firstname");
    By lastNameField = By.id("lastname");
    By emailField = By.id("email_address");
    By passwordField = By.id("password");
    By confirmPasswordField = By.id("password-confirmation");
    By createAccountButton = By.xpath("//button[@title='Create an Account']");
    By errorMessage = //By.id("firstname-error");
    By.xpath("//div[@id='firstname-error' and @class='mage-error']");

    // Constructor
    public P01_createAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    // Navigate to homepage
    public void goToHomepage() {
        driver.get("https://magento.softwaretestingboard.com");
    }

    // Click the "Create an Account" button
    public void clickCreateButton() {
        driver.findElement(createButton).click();
    }

    // Verify that the user is navigated to the Create Account page
    public void verifyCreateAccountPage() {
        String expectedUrl = "https://magento.softwaretestingboard.com/customer/account/create/";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl, "User is not on the Create Account page.");
        assertTrue(driver.findElement(createAccountPageHeader).isDisplayed(), "Create Account page header is not displayed.");
    }

    // Fill the mandatory fields
    public void inputField(String fieldName, String value) {
        switch (fieldName) {
            case "First Name":
                driver.findElement(firstNameField).sendKeys(value);
                break;
            case "Last Name":
                driver.findElement(lastNameField).sendKeys(value);
                break;
            case "Email":
                driver.findElement(emailField).sendKeys(value);
                break;
            case "Password":
                driver.findElement(passwordField).sendKeys(value);
                break;
            case "Confirm Password":
                driver.findElement(confirmPasswordField).sendKeys(value);
                break;
        }
    }

    // Click the Create Account button
    public void submitCreateAccount() {
        driver.findElement(createAccountButton).click();
    }

    // Shown error message if there is missing value when create acc
    public void verifyErrorMessage(String expectedErrorMessage) {
        String actualMessage = driver.findElement(errorMessage).getText();
        assertEquals(expectedErrorMessage, actualMessage, "Error message is incorrect.");
    }
}
