package com.telRan.tests.tests;

import com.telRan.tests.TestBase;
import com.telRan.tests.model.Board;
import org.testng.annotations.Test;

public class BoardModificationTests extends TestBase {

    @Test
    public void modifyBoardTest(){
        //enter to the first
        app.board().clickOnTheFirstBoard();
        //change name
        app.board().renameBoard(new Board().withBoardName("renameBoard"));
        app.header().returnOnHomePageFromBoard();

    }

    @Test
    public void closeDeleteBoard() {
        app.board().clickOnOpenBoardsButton();
        app.board().clickOnBoard("HH");
        app.board().clickOnMoreButton();
        app.board().clickOnCloseButton();
        app.board().confirmCloseButton();
        app.board().deleteButton();
        app.board().confirmDeleteButton();
    }





}
