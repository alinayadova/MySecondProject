package com.telRan.tests;

import com.telRan.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTests2 extends TestBase {


    @Test
    public void boardCreationTest() {
        int before = app.board().getBoardsCount();
        app.header().clickOnPlusButton();
        app.header().selectCreateBoard();
        app.board().fillBoardForm("HelloWorld", "public");
        app.board().confirmBoardCreation();
        app.header().returnOnHomePage();
        int after = app.board().getBoardsCount();
        System.out.println("was: " + before + " now: " + after);
        Assert.assertEquals(after, before+1);
    }

    @Test
    public void boardCreationTest2() {
        int before = app.board().getBoardsCount();
        app.header().clickOnPlusButton();
        app.header().selectCreateBoard();
        app.board().fillBoardForm("mmm", "public");
        app.board().confirmBoardCreation();
        app.header().returnOnHomePage();
        int after = app.board().getBoardsCount();
        System.out.println("was: " + before + " now: " + after);
        Assert.assertEquals(after, before+1);
    }

}

