package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class HomePage {
    By userAvatarLocator = By.xpath("//div[@data-purpose='user-avatar']");
    By searchFildHome = By.xpath(" //input[@id=\"search-field-home\"]");
    By searchHomeButtonLocator = By.xpath("//button[@aria-label=\"Поиск\" and @ type=\"submit\"]");
    By MenuCategoriesLocator = By.xpath("//ul[@aria-label=\"Категории\"]/li/a/span[@class='fx']");
    By CategoriesMenuDropDownLocator = By.xpath("//div[@class=\"dropdown--open-on-hover dropdown--topics dropdown--open-on-hover dropdown\"]");

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

    public HomePage setSearchWord() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFildHome));
        WebElement nameField = driver.findElement(searchFildHome);
        nameField.clear();
        nameField.sendKeys("Angular");
        return this;
    }

    public HomePage clickSearchHomeButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchHomeButtonLocator));
        WebElement searchHomeButton = driver.findElement(searchHomeButtonLocator);
        wait.until(ExpectedConditions.elementToBeClickable(searchHomeButtonLocator));
        searchHomeButton.click();
        return this;
    }
    public List<String> getMenuCategoriesList() {
        List<String> MenuList = new ArrayList<>();

        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(CategoriesMenuDropDownLocator));
        WebElement CategoriesMenuDropDown = driver.findElement(CategoriesMenuDropDownLocator);
        actions.moveToElement(CategoriesMenuDropDown).perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(MenuCategoriesLocator));
        List<WebElement> MenuCategories = driver.findElements(MenuCategoriesLocator);

        for(WebElement element:MenuCategories) {
            MenuList.add(element.getText());
        }

        return MenuList;
    }
}
