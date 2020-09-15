import com.telRan.tests.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BoardClosingAndDeletingTest extends TestBase {

    @Test
    public void closeDeleteBoard() {
        clickOnOpenBoardsButton();
        clickOnBoard("mmm");
        clickOnMoreButton();
        clickOnCloseButton();
        confirmCloseButton();
        deleteButton();
        confirmDeleteButton();
    }

    public void confirmDeleteButton() {
        app.click(By.cssSelector(".js-confirm"));
    }

    public void deleteButton() {
        app.click(By.cssSelector(".js-delete"));
    }

    public void confirmCloseButton() {
       // click(By.xpath("//input[@class='js-confirm full negate']"));
        app.click(By.cssSelector(".js-confirm"));
    }

    public void clickOnCloseButton() {
        app.click(By.cssSelector(".js-close-board"));
    }

    public void clickOnMoreButton() {
        app.click(By.cssSelector("a.js-open-more"));
    }

    public void clickOnBoard(String boardName) {
        app.click(By.cssSelector("[title='" + boardName + "']"));
        //click(By.xpath("//a[@title='" + boardName + "']/../.."));
    }

    public void clickOnOpenBoardsButton() {
        app.click(By.cssSelector("[data-test-id='header-boards-menu-button']"));
    }

}

