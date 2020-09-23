package com.telRan.tests.tests;


import com.telRan.tests.TestBase;
import com.telRan.tests.model.Board;
import com.telRan.tests.model.Team;
import org.testng.annotations.Test;

public class teamModificationTest extends TestBase {
    @Test
    public void modifyTeamTest(){
        app.team().clickOnTeam("hop");
        app.team().clickOnSettingsTeam();
        //edit team profile
        app.team().clickOnEditTeamProfile();
        app.team().renameTeam(new Team().withTeamName("HOP"));
        //save
        app.team().confirmRenameTeamButton();
    }

    @Test
    public void deleteTeamTest(){
        //click on team
        app.team().clickOnTeam("mmm ");
        //click on settings
        app.team().clickOnSettingsTeam();
        //click on delete this team
        app.team().clickDeleteThisTeam();
        //confirmDelete
        app.team().confirmDeleteTeam();
    }
}
    