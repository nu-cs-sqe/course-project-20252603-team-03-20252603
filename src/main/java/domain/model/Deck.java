package domain.model;

import domain.enums.CardType;

import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck(List<Card> cards) {
        this.cards = cards;
    }
    public void shuffle() {}
    public Card drawTop() { return null; }
    public void insertAt(Card card, int index) {}
    public int size() { return 0; }
    public boolean isEmpty() { return false; }
    public int countCardsByType(CardType cardType) { return 0;}
}