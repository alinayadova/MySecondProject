package com.telRan.tests;

import org.testng.annotations.Test;

public class BoardModificationTests extends TestBase {

    @Test
    public void modifyBoardTest(){
        //enter to the first
        app.board().clickOnTheFirstBoard();
        //change name
        app.board().renameBoard();

    }

    @Test
    public void closeDeleteBoard() {
        app.board().clickOnOpenBoardsButton();
        app.board().clickOnBoard("mmm");
        app.board().clickOnMoreButton();
        app.board().clickOnCloseButton();
        app.board().confirmCloseButton();
        app.board().deleteButton();
        app.board().confirmDeleteButton();
    }




}
