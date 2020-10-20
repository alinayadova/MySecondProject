package com.telRan.tests.tests;

import com.telRan.tests.TestBase;
import com.telRan.tests.model.Board;
import com.telRan.tests.tests.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class BoardCreationTests2 extends TestBase {


    @BeforeClass
    public void isOnBoardsPage(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(!app.board().isOnBoardsPage()){
            app.leftNav().returnToBoardsPage();
        }
    }

    @Test(dataProvider = "validBoardsFromCSV", dataProviderClass = DataProviders.class)
    public void boardCreationTestFromDataProviderCSV(Board board) {

        int before = app.board().getBoardsCount();
        app.header().clickOnPlusButton();
        app.header().selectCreateBoard();
       // Board board = new Board()
       //         .withBoardName(boardName)
       //         .withBoardVisible(boardVisible);
        app.board().fillBoardForm(board);
        app.board().confirmBoardCreation();
        app.header().returnOnHomePageFromBoard();
        int after = app.board().getBoardsCount();
        System.out.println("was: " + before + " now: " + after);
        Assert.assertEquals(after, before+1);
    }

    @Test(dataProvider = "validBoards", dataProviderClass = DataProviders.class)
    public void boardCreationTestFromDataProvider(String boardName, String boardVisible) {

        int before = app.board().getBoardsCount();
        app.header().clickOnPlusButton();
        app.header().selectCreateBoard();
        Board board = new Board()
                .withBoardName(boardName)
                .withBoardVisible(boardVisible);
        app.board().fillBoardForm(board);
        app.board().confirmBoardCreation();
        app.header().returnOnHomePageFromBoard();
        int after = app.board().getBoardsCount();
        System.out.println("was: " + before + " now: " + after);
        Assert.assertEquals(after, before+1);
    }

    @Test
    public void boardCreationTest() {

        int before = app.board().getBoardsCount();
        app.header().clickOnPlusButton();
        app.header().selectCreateBoard();
        app.board().fillBoardForm(new Board()
             //   .withBoardName("zzz")
                .withBoardVisible("public"));
        app.board().confirmBoardCreation();
        app.header().returnOnHomePageFromBoard();
        int after = app.board().getBoardsCount();
        System.out.println("was: " + before + " now: " + after);
        Assert.assertEquals(after, before+1);
    }

    @Test
    public void boardCreationTest2() {
        int before = app.board().getBoardsCount();
        app.header().clickOnPlusButton();
        app.header().selectCreateBoard();
        app.board().fillBoardForm(new Board()
                .withBoardName("ghj")
                .withBoardVisible("private"));
        app.board().confirmBoardCreation();
        app.header().returnOnHomePageFromBoard();
        int after = app.board().getBoardsCount();

        System.out.println("was: " + before + " now: " + after);
        Assert.assertEquals(after, before+1);
    }

}

