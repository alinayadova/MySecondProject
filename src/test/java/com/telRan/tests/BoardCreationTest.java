package com.telRan.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        if(app.isBoardCreated()){
            //closeBoard();
           // deleteBoard();
        }
    }

    @Test
    public void boardCreationPositiveTest(){
        //boardCreation();
       // Assert.assertTrue(isBoardCreated());
    }


}
