package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPopup {
    private WebDriver driver;
    private WebDriverWait wait;
    By signupPopupLocator = By.xpath("//button[@data-purpose='header-signup']");
    By nameFieldLocator = By.id("id_fullname");
    By emailFieldLocator = By.xpath("//input[@data-purpose='email']");
    By passwordFieldLocator = By.id("password");
    By signUpButtonLocatorLocator = By.xpath("//input[@id='submit-id-submit']");

    public SignupPopup (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    };

    public SignupPopup open() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signupPopupLocator));
        WebElement signupPopup = driver.findElement(signupPopupLocator);
        signupPopup.click();

        return this;
    }
    public SignupPopup setName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameFieldLocator));
        WebElement nameField = driver.findElement(nameFieldLocator);
        nameField.clear();
        nameField.sendKeys("Maryna");
        return this;

    }

    public SignupPopup setEmail() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldLocator));
        WebElement emailField = driver.findElement(emailFieldLocator);
        emailField.clear();
        emailField.sendKeys("maryna.mushkina+"+System.currentTimeMillis()+"@gmail.com");
        return this;

    }

    public SignupPopup setPassword() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFieldLocator));
        WebElement passwordField = driver.findElement(passwordFieldLocator);
        passwordField.clear();
        passwordField.sendKeys(":h>L(3,b9D3Dz");
        return this;

    }

    public SignupPopup clickSignUpButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpButtonLocatorLocator));
        WebElement signUpButton = driver.findElement(signUpButtonLocatorLocator);
        wait.until(ExpectedConditions.elementToBeClickable(signUpButtonLocatorLocator));
        signUpButton.click();
        return this;

    }

}
