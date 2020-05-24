package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;


public class SignUpTest extends TestBase {

    @Test(description = "SignUp with valid credential")
    public void signUpWithValidCredentials() {
       homePage.open();
        signupPopup.open().setName().setEmail().setPassword().clickSignUpButton();
        Assert.assertEquals(homePage.getUserAvatarLabel(), "Maryna");
    }
}
