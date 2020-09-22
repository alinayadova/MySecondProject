package com.telRan.tests.tests;

import com.telRan.tests.TestBase;
import org.testng.annotations.Test;

public class TeamCreationTest extends TestBase {

    @Test
    public void createTeam(){
        app.team().clickOnCreateTeamButton();
        app.team().fillTeamForm("WWW-Leningrad", "Operations", "It's the best team!");
        app.team().confirmCreationTeam();


    }



}
