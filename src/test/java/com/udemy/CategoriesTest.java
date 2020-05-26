package com.udemy;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CategoriesTest extends TestBase {

    List<String> expectedMenuList = new ArrayList<>();

    @BeforeMethod(description = "prepare menu list")
    public void prepareMenuList() {
        expectedMenuList.add("Разработка");
        expectedMenuList.add("Бизнес");
        expectedMenuList.add("Финансы и бухгалтерский учет");
        expectedMenuList.add("ИТ и ПО");
        expectedMenuList.add("Офисное программное обеспечение");
        expectedMenuList.add("Личностный рост");
        expectedMenuList.add("Дизайн");
        expectedMenuList.add("Маркетинг");
        expectedMenuList.add("Стиль жизни");
        expectedMenuList.add("Фотография");
        expectedMenuList.add("Здоровье и фитнес");
        expectedMenuList.add("Музыка");
        expectedMenuList.add("Преподавание и академические дисциплины");
    }

    @Test(description = "Test Menu List")
    public void TestMenuList() {
        List<String> currentMenuList = homePage.open().getMenuCategoriesList();
        expectedMenuList.removeAll(currentMenuList);
        Assert.assertTrue(expectedMenuList.isEmpty());
    }
}
