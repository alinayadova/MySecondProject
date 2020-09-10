package com.telRan.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeClass
    public void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.manage().window().maximize();

        //open Site
        wd.navigate().to("https://trello.com/");
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

    public void boardCreation(){
        clickOnPlusButton();
        selectCreateBoard();
        fillBoardForm();
        confirmBoardCreation();
        returnOnHomePage();
    }

    public void returnOnHomePage() {
        click(By.cssSelector("[data-test-id='header-home-button']"));
    }

    public void confirmBoardCreation() {
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
    }

    public void fillBoardForm() {
        type(By.cssSelector("[data-test-id='create-board-title-input']"), "HelloWorld");
    }

    public void selectCreateBoard() {
        click(By.cssSelector("[title='green']"));
    }

    public void clickOnPlusButton() {
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));
        click(By.cssSelector("[data-test-id='header-create-board-button']"));
    }

    public void deleteBoard(){
        clickOnOpenBoardsButton();
        clickOnClosedBoardsButton();
        clickOnDeleteButton();
    }

    public void clickOnDeleteButton() {
        click(By.cssSelector("[class='nch-icon _2_Q6rrYCFblD3M _3Dk1GPoKnJxuep vmfY4Z5HOr-J1T']"));
    }

    public void clickOnClosedBoardsButton() {
        click(By.cssSelector("[data-test-id='header-boards-menu-open-closed']"));
    }

    public void clickOnOpenBoardsButton() {
        click(By.cssSelector("[data-test-id='header-boards-menu-button']"));
    }

    public void closeBoard(){
        clickOnMenuButton();
        clickOnMoreButton();
        clickOnCloseButton();
    }

    public void clickOnCloseButton() {
        click(By.cssSelector("[class='board-menu-navigation-item-link js-close-board']"));
    }

    public void clickOnMoreButton() {
        click(By.cssSelector("[class='board-menu-navigation-item-link js-open-more']"));
    }

    public void clickOnMenuButton() {
        click(By.cssSelector("[class='board-header-btn mod-show-menu js-show-sidebar']"));
    }

    public boolean isBoardCreated(){
        return isElementAdded(By.xpath("//div[@title='HelloWorld']"));
    }

    public boolean isElementAdded(By locator){
        return wd.findElements(locator).size()>0;
    }



    @AfterClass(enabled = true)
    public void tearDown(){
        wd.quit();
    }
}
