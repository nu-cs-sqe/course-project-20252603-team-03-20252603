package domain.factory;

import domain.model.Card;
import domain.model.Deck;

import java.util.ArrayList;
import java.util.List;

public class DeckFactory {

    private final int numPlayers;

    public DeckFactory(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    private static final int NUM_DEFUSE_CARDS = 6;
    private static final int NUM_SKIP_CARDS = 4;
    private static final int NUM_ATTACK_CARDS = 4;
    private static final int NUM_SHUFFLE_CARDS = 4;
    private static final int NUM_SEE_THE_FUTURE_CARDS = 5;
    private static final int NUM_FAVOR_CARDS = 4;
    private static final int NUM_NOPE_CARDS = 5;
    private static final int NUM_CAT_CARDS = 20;

    int getNumExplodingKittenCards() {
        return this.numPlayers - 1;
    }

    List<Card> generateDefuseCards() {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < NUM_DEFUSE_CARDS; i++) {
            cards.add(new Card());
        }
        return cards;
    }

    List<Card> generateExplodingKittenCards() {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < getNumExplodingKittenCards(); i++) {
            cards.add(new Card());
        }
        return cards;
    }

    List<Card> generateSkipCards() {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < NUM_SKIP_CARDS; i++) {
            cards.add(new Card());
        }
        return cards;
    }

    List<Card> generateAttackCards() {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < NUM_ATTACK_CARDS; i++) {
            cards.add(new Card());
        }
        return cards;
    }

    List<Card> generateShuffleCards() {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < NUM_SHUFFLE_CARDS; i++) {
            cards.add(new Card());
        }
        return cards;
    }

    List<Card> generateSeeTheFutureCards() {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < NUM_SEE_THE_FUTURE_CARDS; i++) {
            cards.add(new Card());
        }
        return cards;
    }

    List<Card> generateFavorCards() {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < NUM_FAVOR_CARDS; i++) {
            cards.add(new Card());
        }
        return cards;
    }

    List<Card> generateNopeCards() {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < NUM_NOPE_CARDS; i++) {
            cards.add(new Card());
        }
        return cards;
    }

    List<Card> generateCatCards() {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < NUM_CAT_CARDS; i++) {
            cards.add(new Card());
        }
        return cards;
    }

    public List<Card> buildExplodingKittenCards() {
        return generateExplodingKittenCards();
    }

    public List<Card> buildDefuseCards() {
        return generateDefuseCards();
    }

    public Deck buildDeck() {
        List<Card> cards = new ArrayList<>();
        cards.addAll(generateAttackCards());
        cards.addAll(generateCatCards());
        cards.addAll(generateNopeCards());
        cards.addAll(generateSeeTheFutureCards());
        cards.addAll(generateFavorCards());
        cards.addAll(generateShuffleCards());
        cards.addAll(generateSkipCards());

        return new Deck(cards);
    }
}