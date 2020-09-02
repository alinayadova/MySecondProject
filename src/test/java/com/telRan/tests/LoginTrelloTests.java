package com.telRan.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTrelloTests {
    WebDriver wd;

    @BeforeClass
    public void setUp(){
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.manage().window().maximize();

    //open Site
        wd.navigate().to("https://trello.com/");
    }

    @Test
    public void loginAtlassianAccPositiveTest() throws InterruptedException {
        //click on Login Button on Welcome Page
        wd.findElement(By.cssSelector("[href='/login']")).click();
        //fill Login form
            //fill email
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys("mickeymouse.tester1@gmail.com");

        Thread.sleep(10000);
            //click on login with Atlassian Button
        wd.findElement(By.id("login")).click();
        Thread.sleep(10000);
            //fill password
        wd.findElement(By.id("password")).click();
        wd.findElement(By.id("password")).clear();
        wd.findElement(By.id("password")).sendKeys("Mm123456789");
            //click submit button
        wd.findElement(By.id("login-submit")).click();
        //ER userLoggedIn (is Avatar present)


    }

    @AfterClass(enabled = false)
    public void tearDown(){
        wd.quit();
    }
}
