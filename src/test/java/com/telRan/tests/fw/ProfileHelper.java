package com.telRan.tests.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class ProfileHelper extends HelperBase{

    public ProfileHelper(WebDriver wd) {
        super(wd);
    }

    public void switchToAttlassianAccWindow() {
        String trello = wd.getWindowHandle();
        System.out.println(trello);
        click(By.cssSelector("a[href$=manage-profile]"));

        List<String> availableWindows = new ArrayList<>(wd.getWindowHandles());
        if (!availableWindows.isEmpty()){
            wd.switchTo().window(availableWindows.get(1));
        }

        //now selenium on Atlassian page
        String atlassianAcc = wd.getWindowHandle();
        System.out.println(atlassianAcc);

     }

    public void changeAvatar() {
        WebElement avatar = wd.findElement(By.cssSelector("[data-test-selector='profile-avatar']"));
        new Actions(wd).moveToElement(avatar).click().click(wd.findElement(By.xpath("//*[@class='sc-hZSUBg dmzIAx']/span[1]"))).perform();


               // new Actions(wd).clickAndHold("").moveToElement("").release().perform();
    }
}
