package com.telRan.tests.tests;

import com.telRan.tests.TestBase;
import com.telRan.tests.model.Team;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TeamCreationTest extends TestBase {

    @Test
    public void createTeam(){
        int before = app.team().getTeamCount();
        app.team().clickOnCreateTeamButton();
        app.team().fillTeamForm(new Team().withTeamName("London")
                .withTypeTeam("operations")
                .withDescriptionTeam("It's the best team!"));
        app.team().confirmCreationTeam();
        app.team().selectIwillDoThisLaterButton();

        app.header().returnOnHomePageFromTeam();
        int after = app.team().getTeamCount();

        System.out.println("was: " + before + " now: " + after);
        Assert.assertEquals(after, before+1);
    }

    @Test
    public void createTeamFromHeader(){
        int before = app.team().getTeamCount();
        app.header().clickOnPlusButton();
        app.header().selectCreateTeam();
        app.team().fillTeamForm(new Team().withTeamName("New York")
                .withTypeTeam("engineering-it")
                .withDescriptionTeam(""));
        app.team().confirmCreationTeam();
        app.team().selectIwillDoThisLaterButton();

        app.header().returnOnHomePageFromTeam();
        int after = app.team().getTeamCount();

        System.out.println("was: " + before + " now: " + after);
        Assert.assertEquals(after, before+1);

    }

    @AfterClass
    public void postActions(){
       app.leftNav().returnToBoardsPage();
    }


}
