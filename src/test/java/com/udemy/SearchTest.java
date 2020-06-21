package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static com.udemy.constants.BaseConst.SEARCH_PHRASE;
import static com.udemy.constants.BaseConst.SEARCH_PHRASE_RESULTS;

public class SearchTest extends TestBase {

    @Test(description = "Check search field")
    public void testSearchField() throws MalformedURLException {
        homePage.open().setSearchWord(SEARCH_PHRASE).clickSearchHomeButton();
        Assert.assertTrue(searchResultPage.getSearchHeaderText().contains(SEARCH_PHRASE_RESULTS));
        Assert.assertFalse(searchResultPage.getSearchValue().isEmpty());
        Assert.assertEquals(searchResultPage.getUrlParamRefValue(), SEARCH_PHRASE);
        Assert.assertTrue(searchResultPage.getFirstItemTitleText().contains(SEARCH_PHRASE));
    }
}
