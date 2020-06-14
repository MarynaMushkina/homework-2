package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class SearchResultPage {
    public SearchResultPage (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(this.driver, this);
    };

    private WebDriver driver;
    private WebDriverWait wait;

    By searchLocator = By.xpath("//input[@name='q']");
    @FindBy(xpath = "//input[@name='q']")
    private WebElement search;

    By searchHeaderLocator = By.xpath("//h1[@class='udlite-heading-xxl']");
    @FindBy(xpath = "//h1[@class='udlite-heading-xxl'] ")
    private WebElement searchHeader;

    By firstItemTitleLocator = By.xpath("//div[@class='course-list--container--3zXPS']/div[1]//div[contains(@class,'course-card--course-title--2f7tE')]");
    @FindBy(xpath = "//div[@class='course-list--container--3zXPS']/div[1]//div[contains(@class,'course-card--course-title--2f7tE')]")
    private WebElement firstItemTitle;

    public String getSearchValue() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchLocator));
        return search.getAttribute("value");
    }

    public String getSearchHeaderText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchHeaderLocator));
        return searchHeader.getText();
    }

    public String getFirstItemTitleText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstItemTitleLocator));
        return firstItemTitle.getText();
    }

    public String getUrlParamRefValue() throws MalformedURLException {
        URL aUrl =  new URL(driver.getCurrentUrl());
        String[] query = aUrl.getQuery().split("&");
        if( query.length > 1) {
            return query[1].split("=")[1];
        } else {
            return query[0].split("=")[1];
        }
    }
}
