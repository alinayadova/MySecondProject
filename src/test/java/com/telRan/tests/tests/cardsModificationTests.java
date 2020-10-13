package com.telRan.tests.tests;

import com.telRan.tests.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class cardsModificationTests extends TestBase {

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

    @Test
    public void moveCardToList(){
        app.board().clickOnTheFirstBoard();
        app.card().moveCard();
    }

}
