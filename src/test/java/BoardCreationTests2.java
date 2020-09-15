import com.telRan.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTests2 extends TestBase {


    @Test
    public void boardCreationTest() {
        int before = app.getBoardsCount();
        app.clickOnPlusButton();
        app.selectCreateBoard();
        app.fillBoardForm("HelloWorld", "public");
        app.confirmBoardCreation();
        app.returnOnHomePage();
        int after = app.getBoardsCount();
        System.out.println("was: " + before + " now: " + after);
        Assert.assertEquals(after, before+1);
    }

    @Test
    public void boardCreationTest2() {
        int before = app.getBoardsCount();
        app.clickOnPlusButton();
        app.selectCreateBoard();
        app.fillBoardForm("HelloWorld2", "private");
        app.confirmBoardCreation();
        app.returnOnHomePage();

    }

}

