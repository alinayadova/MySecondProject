package com.telRan.tests.model;

public class Board {
    private String boardName;
    private String teamVisible;

    public Board withBoardName(String boardName) {
        this.boardName = boardName;
        return this;
    }

    public Board withTeamVisible(String teamVisible) {
        this.teamVisible = teamVisible;
        return this;
    }

    public String getBoardName() {
        return boardName;
    }

    public String getTeamVisible() {
        return teamVisible;
    }
}
