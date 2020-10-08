package com.telRan.tests.model;

public class Board {
    private String boardName;
    private String boardVisible;

    public Board withBoardName(String boardName) {
        this.boardName = boardName;
        return this;
    }

    public Board withBoardVisible(String boardVisible) {
        this.boardVisible = boardVisible;
        return this;
    }

    public String getBoardName() {
        return boardName;
    }

    public String getBoardVisible() {
        return boardVisible;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardName='" + boardName + '\'' +
                ", boardVisible='" + boardVisible + '\'' +
                '}';
    }
}
