package com.udemy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.udemy.pages.HomePage;
import com.udemy.pages.SearchResultPage;
import com.udemy.pages.SignupPopup;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

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

        ChromeOptions chromeOptions = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("intl.accept_languages", "en-US");
        chromeOptions.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(chromeService, chromeOptions);
        wait = new WebDriverWait(driver, 30);
        homePage = new HomePage(driver, wait);
        signupPopup = new SignupPopup(driver, wait);
        searchResultPage = new SearchResultPage(driver, wait);
        driver.manage().window().maximize();
    }

    @AfterMethod(description = "Close browser")
    public void closerBrowser () {
        driver.quit();
    }
}
