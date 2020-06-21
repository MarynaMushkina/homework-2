package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;
import static com.udemy.testdata.UserData.baseUser;


public class SignUpTest extends TestBase {

    @Test(description = "SignUp with valid credential")
    public void signUpWithValidCredentials() {
       homePage.open();
        signupPopup.open().setName(baseUser.getName()).setEmail(baseUser.getEmail()).setPassword(baseUser.getPassword()).clickSignUpButton();
        Assert.assertEquals(homePage.getUserAvatarName(), baseUser.getName());
    }
}
