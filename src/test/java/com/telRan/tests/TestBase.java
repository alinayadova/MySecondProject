package com.telRan.tests;

import com.telRan.tests.fw.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    protected static ApplicationManager app =
            new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite
    public void setUp() throws InterruptedException {
        app.init();
        app.session().login("mickeymouse.tester1@gmail.com", "Mm123456789");

    }

    @AfterSuite(enabled = true)
    public void tearDown() {
        app.stop();
    }

}
