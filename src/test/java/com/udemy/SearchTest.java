package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class SearchTest extends TestBase {

    @Test(description = "Check search field")
    public void testSearchField() throws MalformedURLException {
        homePage.open().setSearchWord().clickSearchHomeButton();
        Assert.assertTrue(searchResultPage.getSearchHeaderText().contains("результатов по запросу «angular»"));
        Assert.assertFalse(searchResultPage.getSearchValue().isEmpty());
        Assert.assertEquals(searchResultPage.getUrlParamRefValue(), "home");
        Assert.assertTrue(searchResultPage.getFirstItemTitleText().contains("Angular"));
    }
}
