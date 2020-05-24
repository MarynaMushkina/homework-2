package com.udemy;

import com.udemy.pages.HomePage;
import com.udemy.pages.SearchResultPage;
import com.udemy.pages.SignupPopup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;

public class TestBase {

    WebDriver driver;
    WebDriverWait wait;
    HomePage homePage;
    SignupPopup signupPopup;
    SearchResultPage searchResultPage;


    @BeforeMethod(description = "Open browser")
    public void openBrowser() {
        File chromeDriver = new File("src/main/resources/chromedriver.exe");
        ChromeDriverService chromeService = new ChromeDriverService.Builder()
                .usingDriverExecutable(chromeDriver)
                .usingAnyFreePort()
                .build();

        driver = new ChromeDriver(chromeService);
        wait = new WebDriverWait(driver, 25);
        homePage = new HomePage(driver, wait);
        signupPopup = new SignupPopup(driver, wait);
        searchResultPage = new SearchResultPage(driver, wait);
    }

    @AfterMethod(description = "Close browser")
    public void closerBrowser () {
        driver.quit();
    }
}
