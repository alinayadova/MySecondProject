package com.telRan.tests.fw;

import com.telRan.tests.model.Team;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class TeamHelper extends HelperBase{

    public TeamHelper (WebDriver wd){
        super (wd);
    }


    public void clickOnCreateTeamButton() {
        click(By.cssSelector("[data-test-id='home-navigation-create-team-button']"));
    }

    public void fillTeamForm(Team team) {
        //title
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"), team.getTeamName());
        //typeTeam
        click(By.cssSelector("[data-test-id='header-create-team-type-input']"));
        //click (By.cssSelector("[data-test-id^=header-create-team-type] li"));
        click(By.cssSelector("[data-test-id='header-create-team-type-input-"+ team.getTypeTeam() +"']"));
        type(By.cssSelector("._15aIJYNKhrO4vB"), team.getDescriptionTeam());

    }
    public void confirmCreationTeam(){
        click(By.cssSelector("[data-test-id='header-create-team-submit-button']"));
    }

    public void selectIwillDoThisLaterButton(){
        click(By.cssSelector("[data-test-id='show-later-button']"));
    }

    public int getTeamCount() {
        return wd.findElements(By.cssSelector("[data-test-id='home-team-tab-name']")).size();
    }

    public void clickOnTeam(Team team){
        click(By.xpath("//span[@class='_3qwe2tMMFonNvf' and contains(text(), '" + team.getTeamName() + "')]"));
     }

    public void clickOnSettingsTeam() {
        click(By.cssSelector("[data-test-id='home-team-settings-tab']"));
    }

    public void clickDeleteThisTeam() {
        click(By.cssSelector("a.quiet-button"));
    }

    public void confirmDeleteTeam() {
        click(By.cssSelector(".js-confirm.full.negate"));
    }

    public void clickOnEditTeamProfile() {
        click(By.cssSelector(".css-j8fq0c"));
    }

    public void renameTeam(Team team) {
       click(By.cssSelector("[id='displayName']"));
        wd.findElement(By.cssSelector("[id='displayName']")).clear();
        wd.findElement(By.cssSelector("[id='displayName']"))
                .sendKeys(team.getTeamName() + TimeUnit.MILLISECONDS + Keys.ENTER);
    }

    public void confirmRenameTeamButton() {
        click(By.cssSelector("[type='submit']"));
    }

}

