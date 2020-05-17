package com.udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Date;

public class SignInTest extends TestBase {

    @Test(description = "SignIn with valid credential")
    public void signIn() {
        By userAvatarLocator = By.xpath("//div[@data-purpose='user-avatar']");
        String name = "Maryna";
        String target_url = "https://udemy.com/";

        driver.get(target_url);
        Cookie cookie = new Cookie.Builder("dj_session_id", "cpp1byibx5syh1045dovun6s4d8zzrxs")
                .domain("www.udemy.com")
                .expiresOn(new Date(2020, 06, 16))
                .isHttpOnly(true)
                .isSecure(false)
                .path("/")
                .build();

        driver.manage().addCookie(cookie);
        driver.get(target_url);

        wait.until(ExpectedConditions.visibilityOfElementLocated(userAvatarLocator));
        WebElement userAvatar = driver.findElement(userAvatarLocator);
        Assert.assertEquals(userAvatar.getAttribute("aria-label"), name);
    }
}
