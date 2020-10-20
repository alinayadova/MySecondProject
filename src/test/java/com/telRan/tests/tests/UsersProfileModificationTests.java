package com.telRan.tests.tests;

import com.telRan.tests.TestBase;
import org.testng.annotations.Test;

public class UsersProfileModificationTests extends TestBase {


    @Test
    public void testChangeAvatarForUser() throws InterruptedException {
        app.header().clickOnAvatar();
        app.header().openProfile();
        app.profile().switchToAttlassianAccWindow();
        app.profile().changeAvatar();
    }


}
