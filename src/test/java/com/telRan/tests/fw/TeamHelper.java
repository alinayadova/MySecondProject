package com.telRan.tests.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TeamHelper extends HelperBase{

    public TeamHelper (WebDriver wd){
        super (wd);
    }


    public void clickOnCreateTeamButton() {
        click(By.cssSelector("[data-test-id='home-navigation-create-team-button']"));
    }

    public void fillTeamForm(String teamName, String typeTeam, String descriptionTeam) {
        //title
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"), teamName);
        //typeTeam
        click(By.cssSelector("[data-test-id='header-create-team-type-input']"));
        click (By.cssSelector("[data-test-id^=header-create-team-type] li"));
        //click(By.cssSelector("[data-test-id^='" + typeTeam + "'] li"));
        type(By.cssSelector("._15aIJYNKhrO4vB"), descriptionTeam);

    }
    public void confirmCreationTeam(){
        click(By.cssSelector("[data-test-id='header-create-team-submit-button']"));
    }
}
