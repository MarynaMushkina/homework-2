package com.udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SignUpTest extends TestBase {

    @Test(description = "SignUp with valid credential")
    public void signUpWithValidCredentials() {
        By signupPopupLocator = By.xpath("//button[@data-purpose='header-signup']");
        By nameFieldLocator = By.id("id_fullname");
        By emailFieldLocator = By.xpath("//input[@data-purpose='email']");
        By passwordFieldLocator = By.id("password");
        By signUpButtonLocatorLocator = By.xpath("//input[@id='submit-id-submit']");
        By userAvatarLocator = By.xpath("//div[@data-purpose='user-avatar']");

        String name = "Maryna";

        driver.get("https://udemy.com/");

        wait.until(ExpectedConditions.visibilityOfElementLocated(signupPopupLocator));
        WebElement signupPopup = driver.findElement(signupPopupLocator);
        signupPopup.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(nameFieldLocator));
        WebElement nameField = driver.findElement(nameFieldLocator);
        nameField.clear();
        nameField.sendKeys(name);

        wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldLocator));
        WebElement emailField = driver.findElement(emailFieldLocator);
        emailField.clear();
        emailField.sendKeys("maryna.mushkina+"+System.currentTimeMillis()+"@gmail.com");

        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFieldLocator));
        WebElement passwordField = driver.findElement(passwordFieldLocator);
        passwordField.clear();
        passwordField.sendKeys(":h>L(3,b9D3Dz");

        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpButtonLocatorLocator));
        WebElement signUpButton = driver.findElement(signUpButtonLocatorLocator);
        wait.until(ExpectedConditions.elementToBeClickable(signUpButtonLocatorLocator));
        signUpButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(userAvatarLocator));
        WebElement userAvatar = driver.findElement(userAvatarLocator);
        Assert.assertEquals(userAvatar.getAttribute("aria-label"), name);
    }
}
