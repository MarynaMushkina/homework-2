package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.udemy.constants.BaseConst.MAIN_CATEGORIES;

public class CategoriesTest extends TestBase {
    @Test(description = "Test Menu List")
    public void testMenuList() {
        Assert.assertEquals(homePage.open().getMenuCategoriesList() ,MAIN_CATEGORIES);
    }
}
