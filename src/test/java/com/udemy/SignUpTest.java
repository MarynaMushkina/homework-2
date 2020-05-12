package com.udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;


public class SignUpTest {

    @Test(description = "SignUp with valid credential")
    public void signUpWithValidCredentials() {
        File chromeDriver = new File("src/main/resources/chromedriver.exe");
        ChromeDriverService chromeService = new ChromeDriverService.Builder()
                .usingDriverExecutable(chromeDriver)
                .usingAnyFreePort()
                .build();

        WebDriver driver = new ChromeDriver(chromeService);

        String name = "Maryna";

        driver.get("https://udemy.com/");
        pause(4000);

        WebElement signupPopup = driver.findElement(
                By.xpath("//button[@data-purpose='header-signup']"));
        signupPopup.click();

        pause(3000);

        WebElement nameField = driver.findElement(By.id("id_fullname"));
        nameField.clear();
        nameField.sendKeys(name);

        WebElement emailField = driver.findElement(By.xpath("//input[@data-purpose='email']"));
        emailField.clear();
        emailField.sendKeys("maryna.mushkina+5@gmail.com");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys(":h>L(3,b9D3Dz");

        pause(1000);
        WebElement signUpButton = driver.findElement(By.xpath("//input[@id='submit-id-submit']"));
        signUpButton.click();

        pause(5000);

        WebElement userAvatar = driver.findElement(By.xpath("//div[@data-purpose='user-avatar']"));

        Assert.assertEquals(userAvatar.getAttribute("aria-label"), name);

        pause(5000);
        driver.quit();
    }

    private void pause(int milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
