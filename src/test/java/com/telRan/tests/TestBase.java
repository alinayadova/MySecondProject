package com.telRan.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver wd;

    @BeforeClass
    public void setUp() throws InterruptedException {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.manage().window().maximize();

        //open Site
        wd.navigate().to("https://trello.com/");
        login("mickeymouse.tester1@gmail.com", "Mm123456789");
    }

    public void logout() {
        clickOnAvatar();
        clickLogOut();
    }

    public void clickLogOut() {
        click(By.xpath("//button[@data-test-id='header-member-menu-logout']"));
    }

    public void clickOnAvatar() {
        click(By.xpath("//button[@data-test-id='header-member-menu-button']"));
    }

    public boolean isLoginErrorPresent() {
        return isElementPresent(By.cssSelector("#login-error"));
    }

    public void login(String email, String password) throws InterruptedException {
        click(By.cssSelector("[href='/login']"));
        type(By.name("user"), email);
        click(By.id("login"));
        Thread.sleep(10000);
        type(By.id("password"), password);
        click(By.id("login-submit"));
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator){
        wd.findElement(locator).click();
    }

    public boolean isAvatarPresent(){
        return isElementPresent(By.xpath("//button[@data-test-id='header-member-menu-button']")) ;
    }

    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }

    public boolean isBoardCreated(){
        return isElementAdded(By.xpath("//div[@title='HelloWorld']"));
    }

    public boolean isElementAdded(By locator){
        return wd.findElements(locator).size()>0;
    }



    @AfterClass(enabled = false)
    public void tearDown(){
        wd.quit();
    }
}
