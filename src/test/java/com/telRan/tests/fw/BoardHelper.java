package com.telRan.tests.fw;

import com.telRan.tests.model.Board;
import com.telRan.tests.model.Card;
import com.telRan.tests.model.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class BoardHelper extends HelperBase {

    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public int getBoardsCount() {
        if (!isElementPresent(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"))) {
            waitForElement(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"), 30);
        }
        return wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size() - 1;
    }

    public void confirmBoardCreation() {
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
    }

    public void fillBoardForm(Board board) {
        //title

        waitForElementAndType(By.xpath("//input[@data-test-id='create-board-title-input']"),
                30, board.getBoardName());
        //team
        click(By.cssSelector(".W6rMLOx8U0MrPx"));
        //to check!
        if (isElementPresent(By.cssSelector("._1eiLh4-SJ3G7CY"))) {
            click(By.xpath("//nav[@class='_1eiLh4-SJ3G7CY']//li[1]/button"));
        }
        //public/private ("" + var + "")
        click(By.xpath("//*[@class='_1Lkx3EjS3wCrs7']"));
        click(By.xpath("//*[@name='" + board.getBoardVisible() + "']/../.."));

        //confirmPublic
        if (board.getBoardVisible().equals("public")) {
            click(By.cssSelector(".X6LMWvod566P68 button"));
        }
    }

    public void clickOnTheFirstBoard() {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));

        // wd.findElement().isDisplayed();
    }

    public void renameBoard(Board board) {
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


    public boolean isOnBoardsPage() {
        String personalBoards = "//*[@class='icon-lg icon-member']/../../..//li";
        new WebDriverWait(wd, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(personalBoards)));
        return isElementPresent(By.xpath(personalBoards));
    }

    public void fillListFormInBoard(List listName) {
        click(By.cssSelector(".js-add-list"));
        type(By.cssSelector(".list-name-input"),listName.getListName());
    }

    public void confirmAddListButton() {
        click(By.cssSelector(".js-save-edit"));
    }

    public void fillCardForm(Card cardName) {
        click(By.cssSelector(".js-open-card-composer"));
        type(By.cssSelector(".js-card-title"),cardName.getCardName());
    }

    public void confirmAddCardButton() {
        click(By.cssSelector(".js-add-card"));
    }

    public void cancelAddingAnotherCardButton() {
        click(By.cssSelector(".js-cancel"));
    }


}
