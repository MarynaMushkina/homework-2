package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.udemy.constants.BaseConst.*;

public class ExternalLinksTest extends TestBase {
    @Test(description = "Test External Links")
    public void externalLinks() {
        homePage.open().clickBusinessLink().switchToSecondTab();
        Assert.assertEquals(homePage.getCtaSubHeaderText(), CTA_SUB_HEADER);
        Assert.assertTrue(homePage.checkCurrentUrlHasText("business"));
        homePage.open().clickTeachLink();
        Assert.assertEquals(homePage.getTeachingText(), TEACHING_TEXT);
        Assert.assertTrue(homePage.checkCurrentUrlHasText("teaching"));
    }
}
