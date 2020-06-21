package com.udemy.pages;

import org.openqa.selenium.*;
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

    final String businessLinkLocatorXpath = "//a[contains(@href, 'business') and contains(@class, 'js-header-button')]";
    final String businessLinkLocatorOldXpath = "//a[@id='header.try-ufb']";
    By businessLinkLocator = By.xpath(businessLinkLocatorXpath + " | " + businessLinkLocatorOldXpath);
    @FindAll({
            @FindBy(xpath = businessLinkLocatorXpath),
            @FindBy(xpath = businessLinkLocatorOldXpath)
    })
    private WebElement businessLink;

    By ctaSubHeaderLocator = By.xpath("//div[contains(@class,'cta-subheader')]//span");
    @FindBy(xpath = "//div[contains(@class,'cta-subheader')]//span")
    private WebElement ctaSubHeader;

    final String teachLinkLocatorXpath = "//a[contains(@href, 'teaching') and contains(@class, 'js-header-button')]";
    final String teachLinkLocatorOldXpath = "//a[@id='header.instructor']";
    By teachLinkLocator = By.xpath(teachLinkLocatorXpath + " | " + teachLinkLocatorOldXpath);
    @FindAll({
            @FindBy(xpath = teachLinkLocatorXpath),
            @FindBy(xpath = teachLinkLocatorOldXpath)
    })
    private WebElement teachLink;

    By teachingTextLocator = By.xpath("//div[@class='small-content']//h1");
    @FindBy(xpath = "//div[@class='small-content']//h1")
    private WebElement teachingText;

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
    final String userAvatarLocatorOldXpath = "//div[@class='c_header__right']//div[@data-purpose='user-avatar']";
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
    private List<WebElement> menuCategories;

    final String categoriesMenuDropDownLocatorXpath = "//div[@data-purpose=\"header\"]/nav";
    final String categoriesMenuDropDownLocatorOldXpath = "//div[@class=\"dropdown--open-on-hover dropdown--topics dropdown--open-on-hover dropdown\"]";
    By categoriesMenuDropDownLocator = By.xpath(categoriesMenuDropDownLocatorXpath + " | " + categoriesMenuDropDownLocatorOldXpath);
    @FindAll({
            @FindBy(xpath = categoriesMenuDropDownLocatorXpath),
            @FindBy(xpath = categoriesMenuDropDownLocatorOldXpath)
    })
    private WebElement categoriesMenuDropDown;

    public HomePage open() {
        driver.get(BASE_URL);
        return this;
    };

    public HomePage switchToSecondTab() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        return this;
    }

    public Boolean checkCurrentUrlHasText(String text){
        return driver.getCurrentUrl().contains(text);
    }

    public HomePage clickBusinessLink () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(businessLinkLocator));
        this.businessLink.click();

        return this;
    }

    public String getCtaSubHeaderText() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ctaSubHeaderLocator));

        return ctaSubHeader.getText();
    }

    public HomePage clickTeachLink () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(teachLinkLocator));
        this.teachLink.click();

        return this;
    }

    public String getTeachingText() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(teachingTextLocator));

        return teachingText.getText();
    }

    public HomePage setCookie (Cookie cookie) {
        driver.manage().addCookie(cookie);
        return this;
    }

    public String getUserAvatarName () {
        try {
            new WebDriverWait(driver, 7).until(ExpectedConditions.visibilityOfElementLocated(userAvatarLocator));
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

    public HomePage setSearchWord(String word) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFieldHomeLocator));
        searchFieldHome.clear();
        searchFieldHome.sendKeys(word);
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
        actions.moveToElement(this.categoriesMenuDropDown).perform();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(menuCategoriesLocator));
        for(WebElement element:this.menuCategories) {
            MenuList.add(element.getText());
        }

        return MenuList;
    }
}
