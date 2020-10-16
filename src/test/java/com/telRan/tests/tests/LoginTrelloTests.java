package com.telRan.tests.tests;

import com.telRan.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTrelloTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if(app.header().isAvatarPresent()) {
            app.header().logout();
        }
    }

    @Test
    public void loginAtlassianAccPositiveTest() throws InterruptedException {
        //click on Login Button on Welcome Page
        app.session().login("mickeymouse.tester1@gmail.com", "Mm123456789");
        //ER userLoggedIn (is Avatar present)
        Assert.assertTrue(app.header().isAvatarPresent());
        //is user corrected
    }
    @Test
    public void negativeLoginAtlassianAccPositiveTest() throws InterruptedException {
        app.session().login("mickeymouse.tester1@gmail.com", "Mm12345678");
        Assert.assertTrue(app.session().isLoginErrorPresent());
        Assert.assertFalse(app.header().isAvatarPresent());
    }
}
