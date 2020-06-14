package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.udemy.testdata.UserData.baseUser;

public class SignupPopup {

    public SignupPopup (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(this.driver, this);
    };

    private WebDriver driver;
    private WebDriverWait wait;

    final String signupPopupLocatorXpath = "//a[span[contains(text(), 'Sign up')]]";
    final String signupPopupLocatorOldXpath = "//button[@data-purpose='header-signup']";
    By signupPopupLocator = By.xpath(signupPopupLocatorXpath + " | " + signupPopupLocatorOldXpath);
    @FindAll({
            @FindBy(xpath = signupPopupLocatorXpath),
            @FindBy(xpath = signupPopupLocatorOldXpath)
    })
    private WebElement signupPopup;

    By nameFieldLocator = By.id("id_fullname");
    By emailFieldLocator = By.xpath("//input[@data-purpose='email']");
    By passwordFieldLocator = By.id("password");
    By signUpButtonLocatorLocator = By.id("submit-id-submit");

    public SignupPopup open() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signupPopupLocator));
        signupPopup.click();

        return this;
    }
    public SignupPopup setName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameFieldLocator));
        WebElement nameField = driver.findElement(nameFieldLocator);
        nameField.clear();
        nameField.sendKeys(baseUser.getName());
        return this;

    }

    public SignupPopup setEmail() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldLocator));
        WebElement emailField = driver.findElement(emailFieldLocator);
        emailField.clear();
        emailField.sendKeys(baseUser.getEmail());
        return this;

    }

    public SignupPopup setPassword() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFieldLocator));
        WebElement passwordField = driver.findElement(passwordFieldLocator);
        passwordField.clear();
        passwordField.sendKeys(baseUser.getPassword());
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
