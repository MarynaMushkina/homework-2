package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

import static com.udemy.constants.BaseConst.MAIN_CATEGORIES;

public class CategoriesTest extends TestBase {
    @Test(description = "Test Menu List")
    public void TestMenuList() {
        List<String> currentMenuList = homePage.open().getMenuCategoriesList();
        Assert.assertEquals(currentMenuList ,MAIN_CATEGORIES);
    }
}
