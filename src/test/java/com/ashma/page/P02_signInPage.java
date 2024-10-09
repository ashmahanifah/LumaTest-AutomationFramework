package com.ashma.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class P02_signInPage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By SignInLink = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a");
    By emailField = By.id("email");
    By passwordField = By.id("pass");
    By signInButton = By.id("send2"); //to submit credentials
    By errorMessage = By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");

    // Constructor
    public P02_signInPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Page Actions
    public void clickSignInHeader() {
        driver.findElement(SignInLink).click();
    }

    public void verifySignInPage() {
        String expectedUrl = "https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl, "User is not on the Sign In page.");

    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    public void validateErrorAppear(String expectedErrorMessage) {
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        String actualErrorMessage = errorElement.getText();
        assertTrue(actualErrorMessage.contains(expectedErrorMessage));
    }

    public void verifyHomePage() {
        String expectedUrl = "https://magento.softwaretestingboard.com/";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl, "User is not on the Home page.");

    }


}
