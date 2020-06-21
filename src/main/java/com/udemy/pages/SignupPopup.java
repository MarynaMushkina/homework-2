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
    @FindBy(id = "id_fullname")
    private WebElement nameField;

    By emailFieldLocator = By.xpath("//input[@data-purpose='email']");
    @FindBy(xpath = "//input[@data-purpose='email']")
    private WebElement emailField;

    By passwordFieldLocator = By.id("password");
    @FindBy(id = "password")
    private WebElement passwordField;

    By signUpButtonLocator = By.id("submit-id-submit");
    @FindBy(id = "submit-id-submit")
    private WebElement signUpButton;

    public SignupPopup open() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signupPopupLocator));
        signupPopup.click();
        return this;
    }

    public SignupPopup setName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameFieldLocator));
        nameField.clear();
        nameField.sendKeys(name);
        return this;
    }

    public SignupPopup setEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldLocator));
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }

    public SignupPopup setPassword(String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFieldLocator));
        passwordField.clear();
        passwordField.sendKeys(pass);
        return this;
    }

    public SignupPopup clickSignUpButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpButtonLocator));
        wait.until(ExpectedConditions.elementToBeClickable(signUpButtonLocator));
        signUpButton.click();
        return this;
    }
}
