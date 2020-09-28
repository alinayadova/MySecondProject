package com.telRan.tests.fw;

import com.telRan.tests.model.Board;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BoardHelper extends HelperBase {

    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public int getBoardsCount() {
        if(!isElementPresent(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"))){
           waitForElement(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"), 20);
        return wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size()-1;
        }

        return wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size()-1;
    }

    public void confirmBoardCreation() {
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
    }

    public void fillBoardForm(Board board) {
        //title

        waitForElementAndType(By.xpath("//input[@data-test-id='create-board-title-input']"), 30,board.getBoardName());
        //team
        click(By.cssSelector(".W6rMLOx8U0MrPx"));
        //to check!
        if (isElementPresent(By.cssSelector("._1eiLh4-SJ3G7CY"))) {
            click(By.xpath("//nav[@class='_1eiLh4-SJ3G7CY']//li[1]/button"));
        }
        //public/private ("" + var + "")
        click(By.xpath("//*[@class='_1Lkx3EjS3wCrs7']"));
        click(By.xpath("//*[@name='" + board.getTeamVisible() + "']/../.."));

        //confirmPublic
        if (board.getTeamVisible().equals("public")) {
            click(By.cssSelector(".X6LMWvod566P68 button"));
        }

    }

    public void clickOnTheFirstBoard() {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));
    }

    public void renameBoard(Board board){
        click(By.cssSelector("js-rename-board"));
       // wd.findElement(By.cssSelector(".js-board-name-input")).clear();
        wd.findElement(By.cssSelector(".js-board-name-input"))
                .sendKeys(board.getBoardName() + System.currentTimeMillis() + Keys.ENTER);
    }

    public void confirmDeleteButton() {
        click(By.cssSelector(".js-confirm"));
    }

    public void deleteButton() {
        click(By.cssSelector(".js-delete"));
    }

    public void confirmCloseButton() {
        // click(By.xpath("//input[@class='js-confirm full negate']"));
        click(By.cssSelector(".js-confirm"));
    }

    public void clickOnCloseButton() {
        click(By.cssSelector(".js-close-board"));
    }

    public void clickOnMoreButton() {
        click(By.cssSelector("a.js-open-more"));
    }

    public void clickOnBoard(String boardName) {
        click(By.cssSelector("[title='" + boardName + "']"));
        //click(By.xpath("//a[@title='" + boardName + "']/../.."));
    }

    public void clickOnOpenBoardsButton() {
        click(By.cssSelector("[data-test-id='header-boards-menu-button']"));
    }

}
