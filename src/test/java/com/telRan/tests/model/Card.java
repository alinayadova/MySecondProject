package com.telRan.tests.model;

public class Card {
    private String cardName;

    public Card withCardName(String cardName) {
        this.cardName = cardName;
        return this;
    }

    public String getCardName() {
        return cardName;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardName='" + cardName + '\'' +
                '}';
    }
}
