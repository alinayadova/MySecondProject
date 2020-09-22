package com.telRan.tests;

import com.telRan.tests.fw.ApplicationManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeClass
    public void setUp() throws InterruptedException {
        app.init();
        app.session().login("mickeymouse.tester1@gmail.com", "Mm123456789");

    }

    @AfterClass(enabled = true)
    public void tearDown() {
        app.stop();
    }

}
