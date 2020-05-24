package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Date;

public class HomePage {
    By userAvatarLocator = By.xpath("//div[@data-purpose='user-avatar']");
    String target_url = "https://udemy.com/";

    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    };

    public HomePage open() {
        driver.get(target_url);
        return this;
    };

    public HomePage setCookie () {
        Cookie cookie = new Cookie.Builder("dj_session_id", "cpp1byibx5syh1045dovun6s4d8zzrxs")
                .domain("www.udemy.com")
                .expiresOn(new Date(2020, 06, 16))
                .isHttpOnly(true)
                .isSecure(false)
                .path("/")
                .build();

        driver.manage().addCookie(cookie);
        return this;
    }

    public String getUserAvatarLabel () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userAvatarLocator));
        WebElement userAvatar = driver.findElement(userAvatarLocator);
        return userAvatar.getAttribute("aria-label");
    };
}
