package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.udemy.testdata.UserData.baseUser;

public class SignInUsingCookieTest extends TestBase {

    @Test(description = "SignIn with valid credential")
    public void signInUsingCookie() {

        homePage.open().setCookie().open();

        Assert.assertEquals(homePage.getUserAvatarName(), baseUser.getName());
    }
}
