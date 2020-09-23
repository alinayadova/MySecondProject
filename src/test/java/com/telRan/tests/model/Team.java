package com.telRan.tests.model;

public class Team {
    private String teamName;
    private String typeTeam;
    private String descriptionTeam;

    public Team withTeamName(String teamName) {
        this.teamName = teamName;
        return this;
    }

    public Team withTypeTeam(String typeTeam) {
        this.typeTeam = typeTeam;
        return this;
    }

    public Team withDescriptionTeam(String descriptionTeam) {
        this.descriptionTeam = descriptionTeam;
        return this;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTypeTeam() {
        return typeTeam;
    }

    public String getDescriptionTeam() {
        return descriptionTeam;
    }
}
