package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static com.udemy.constants.BaseConst.BASE_URL;
import static com.udemy.constants.BaseConst.SEARCH_PHRASE;
import static com.udemy.testdata.UserData.baseUser;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(this.driver, this);

    };

    By mainMenuLocator = By.xpath("//a[@aria-label='My profile']");
    @FindBy(xpath = "//a[@aria-label='My profile']")
    private WebElement mainMenu;

    final String searchFieldHomeLocatorXpath = "//input[@placeholder=\"Search for anything\"]";
    final String searchFieldHomeLocatorOldXpath = "//input[@id=\"search-field-home\"]";
    By searchFieldHomeLocator = By.xpath(searchFieldHomeLocatorXpath + " | " + searchFieldHomeLocatorOldXpath);
    @FindAll({
            @FindBy(xpath = searchFieldHomeLocatorXpath),
            @FindBy(xpath = searchFieldHomeLocatorOldXpath)
    })
    private WebElement searchFieldHome;

    final String searchHomeButtonLocatorXpath = "//form[@action='/courses/search/']//button";
    final String searchHomeButtonLocatorOldXpath = "//button[@aria-label=\"Search\" and @type=\"submit\"]";
    By searchHomeButtonLocator = By.xpath(searchHomeButtonLocatorXpath + " | " + searchHomeButtonLocatorOldXpath);
    @FindAll({
            @FindBy(xpath = searchHomeButtonLocatorXpath),
            @FindBy(xpath = searchHomeButtonLocatorOldXpath)
    })
    private WebElement searchHomeButton;

    final String userAvatarLocatorXpath = "//div[contains(@class, 'user-profile-dropdown--user-details')]//div[@class='udlite-heading-md']";
    final String userAvatarLocatorOldXpath = "//div[@data-purpose='user-avatar']";
    By userAvatarLocator = By.xpath(userAvatarLocatorXpath + " | " + userAvatarLocatorOldXpath);
    @FindAll({
            @FindBy(xpath = userAvatarLocatorXpath),
            @FindBy(xpath = userAvatarLocatorOldXpath)
    })
    private WebElement userAvatar;

    final String menuCategoriesLocatorXpath = "//div[contains(@class, 'js-browse-nav-level-one')]/ul[contains(@class, 'udlite-block-list')]/li/a/span[@class='udlite-block-list-item-content']";
    final String menuCategoriesLocatorOldXpath = "//ul[@aria-label=\"Categories\"]/li/a/span[@class='fx']";
    By menuCategoriesLocator = By.xpath(menuCategoriesLocatorXpath + " | " + menuCategoriesLocatorOldXpath);
    @FindAll({
            @FindBy(xpath = menuCategoriesLocatorXpath),
            @FindBy(xpath = menuCategoriesLocatorOldXpath)
    })
    private List<WebElement> MenuCategories;

    final String categoriesMenuDropDownLocatorXpath = "//div[@data-purpose=\"header\"]/nav";
    final String categoriesMenuDropDownLocatorOldXpath = "//div[@class=\"dropdown--open-on-hover dropdown--topics dropdown--open-on-hover dropdown\"]";
    By categoriesMenuDropDownLocator = By.xpath(categoriesMenuDropDownLocatorXpath + " | " + categoriesMenuDropDownLocatorOldXpath);
    @FindAll({
            @FindBy(xpath = categoriesMenuDropDownLocatorXpath),
            @FindBy(xpath = categoriesMenuDropDownLocatorOldXpath)
    })
    private WebElement CategoriesMenuDropDown;

    public HomePage open() {
        driver.get(BASE_URL);
        return this;
    };

    public HomePage setCookie () {
        driver.manage().addCookie(baseUser.getCookie());
        return this;
    }

    public String getUserAvatarName () {
        try {
            new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(userAvatarLocator));
            if(userAvatar.getAttribute("aria-label") != null) return userAvatar.getAttribute("aria-label");
        }
        catch (TimeoutException e) {
            Actions actions = new Actions(driver);
            wait.until(ExpectedConditions.visibilityOfElementLocated(mainMenuLocator));
            actions.moveToElement(this.mainMenu).perform();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(userAvatarLocator));
        return userAvatar.getText();
    };

    public HomePage setSearchWord() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFieldHomeLocator));
        searchFieldHome.clear();
        searchFieldHome.sendKeys(SEARCH_PHRASE);
        return this;
    }

    public HomePage clickSearchHomeButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchHomeButtonLocator));
        wait.until(ExpectedConditions.elementToBeClickable(searchHomeButtonLocator));
        searchHomeButton.click();
        return this;
    }
    public List<String> getMenuCategoriesList() {
        List<String> MenuList = new ArrayList<>();

        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(categoriesMenuDropDownLocator));
        actions.moveToElement(this.CategoriesMenuDropDown).perform();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(menuCategoriesLocator));
        for(WebElement element:this.MenuCategories) {
            MenuList.add(element.getText());
        }

        return MenuList;
    }
}
