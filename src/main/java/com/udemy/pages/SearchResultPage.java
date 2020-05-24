package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;


public class SearchResultPage {
    private WebDriver driver;
    private WebDriverWait wait;

    By searchLocator = By.xpath("//input[@name='q']");
    By searchHeaderContainer = By.xpath("//h1[@class='udlite-heading-xxl'] ");
    By firstItemTitleLocator = By.xpath("//div[@class='course-list--container--3zXPS']/div[1]//div[contains(@class,'course-card--course-title--2f7tE')]");

    public SearchResultPage (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    };

    public String getSearchValue() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchLocator));
        WebElement search = driver.findElement(searchLocator);
        return search.getAttribute("value");
    }

    public String getSearchHeaderText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchHeaderContainer));
        WebElement searchHeader = driver.findElement(searchHeaderContainer);
        return searchHeader.getText();
    }

    public String getFirstItemTitleText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstItemTitleLocator));
        WebElement firstItemTitle = driver.findElement(firstItemTitleLocator);
        return firstItemTitle.getText();
    }

    public String getUrlParamRefValue() throws MalformedURLException {
        URL aUrl =  new URL(driver.getCurrentUrl());
        return aUrl.getQuery().split("&")[0].split("=")[1];
    }
}
