package com.telRan.tests.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BoardHelper extends HelperBase {

    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public int getBoardsCount() {
        int res = wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size()-1;
        return res;
    }

    public void confirmBoardCreation() {
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
    }

    public void fillBoardForm(String boardName, String teamVisible) {
        //title
        type(By.xpath("//input[@data-test-id='create-board-title-input']"), boardName);
        //team
        click(By.cssSelector(".W6rMLOx8U0MrPx"));
        //to check!
        if (isElementPresent(By.cssSelector("._1eiLh4-SJ3G7CY"))) {
            click(By.xpath("//nav[@class='_1eiLh4-SJ3G7CY']//li[1]/button"));
        }
        //public/private ("" + var + "")
        click(By.xpath("//*[@class='_1Lkx3EjS3wCrs7']"));
        click(By.xpath("//*[@name='" + teamVisible + "']/../.."));

        //confirmPublic
        if (teamVisible.equals("public")) {
            click(By.cssSelector(".X6LMWvod566P68 button"));
        }

    }

    public void clickOnTheFirstBoard() {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));
    }

    public void renameBoard(){
        click(By.cssSelector(".mod-board-name"));
        wd.findElement(By.cssSelector(".board-name-input.js-board-name-input")).clear();
        wd.findElement(By.cssSelector(".board-name-input.js-board-name-input")).sendKeys("test" + Keys.ENTER);
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
