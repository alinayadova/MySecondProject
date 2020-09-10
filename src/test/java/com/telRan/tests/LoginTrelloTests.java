package com.telRan.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTrelloTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        if(isAvatarPresent()) {
            logout();
        }
    }

    @Test
    public void loginAtlassianAccPositiveTest() throws InterruptedException {
        //click on Login Button on Welcome Page
        login("mickeymouse.tester1@gmail.com", "Mm123456789");
        //ER userLoggedIn (is Avatar present)
        Assert.assertTrue(isAvatarPresent());
        //is user corrected
    }
    @Test
    public void negativeLoginAtlassianAccPositiveTest() throws InterruptedException {
        login("mickeymouse.tester1@gmail.com", "Mm12345678");
        Assert.assertTrue(isLoginErrorPresent());
        Assert.assertFalse(isAvatarPresent());
    }
}
