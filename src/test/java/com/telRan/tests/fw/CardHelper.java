package com.telRan.tests.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CardHelper extends HelperBase{
    public CardHelper(WebDriver wd) {
        super(wd);
    }

    public void moveCard() {
        WebElement card = wd.findElement(By.cssSelector("a[href$='1-task']"));
        new Actions(wd).clickAndHold(card).moveToElement(wd.findElement(By.cssSelector("[aria-label*='Second list']"))).release().perform();
    }
}
