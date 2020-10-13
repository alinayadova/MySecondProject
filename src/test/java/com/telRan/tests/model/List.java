package com.telRan.tests.model;

public class List {

    private String listName;


    public List withListName(String listName) {
        this.listName = listName;
        return this;
    }

    public String getListName() {
        return listName;
    }

    @Override
    public String toString() {
        return "List{" +
                "listName='" + listName + '\'' +
                '}';
    }
}
