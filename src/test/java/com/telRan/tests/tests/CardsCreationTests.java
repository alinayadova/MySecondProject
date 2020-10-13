package com.telRan.tests.tests;

import com.telRan.tests.TestBase;
import com.telRan.tests.model.Card;
import com.telRan.tests.model.List;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CardsCreationTests extends TestBase {

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

    @Test(dataProvider = "validListsAndCards", dataProviderClass = DataProviders.class)
    public void addCardToList(String listName, String cardName){
        app.board().clickOnTheFirstBoard();
        List list = new List().withListName(listName);
        app.board().fillListFormInBoard(list);
        app.board().confirmAddListButton();
        Card card = new Card().withCardName(cardName);
        app.board().fillCardForm(card);
        app.board().confirmAddCardButton();
        app.board().cancelAddingAnotherCardButton();
        app.header().returnOnHomePageFromBoard();



    }

}
