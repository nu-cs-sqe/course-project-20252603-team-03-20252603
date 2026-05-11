package domain.factory;

import domain.model.Card;
import domain.model.Deck;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DeckFactoryTest {

    // --- buildDeck ---

    @Test
    void buildDeck_TwoPlayers_ReturnsDeck() {
        DeckFactory factory = new DeckFactory(2);
        Deck deck = factory.buildDeck();

        assertNotNull(deck);
        // other card type asserts will be added once deck class is implemented as integration tests
    }

    @Test
    void buildDeck_FivePlayers_ReturnsDeck() {
        DeckFactory factory = new DeckFactory(5);
        Deck deck = factory.buildDeck();

        assertNotNull(deck);
        // other card type asserts will be added once deck class is implemented as integration tests
    }

    // --- buildExplodingKittenCards() ---

    @Test
    void buildExplodingKittenCards_TwoPlayers_ReturnsOneCard() {
        DeckFactory factory = new DeckFactory(2);
        List<Card> cards = factory.buildExplodingKittenCards();
        assertEquals(1, cards.size());
    }

    @Test
    void buildExplodingKittenCards_FivePlayers_ReturnsFourCards() {
        DeckFactory factory = new DeckFactory(5);
        List<Card> cards = factory.buildExplodingKittenCards();
        assertEquals(4, cards.size());
    }

    // --- buildDefuseCards() ---

    @Test
    void buildDefuseCards_ReturnsSixDefuseCards() {
        DeckFactory factory = new DeckFactory(2);
        List<Card> cards = factory.buildDefuseCards();
        assertEquals(6, cards.size());
    }

    // --- getNumExplodingKittenCards() ---

    @Test
    void getNumExplodingKittenCards_TwoPlayers_ReturnsOne() {
        DeckFactory deckFactory = new DeckFactory(2);
        assertEquals(1, deckFactory.getNumExplodingKittenCards());
    }

    @Test
    void getNumExplodingKittenCards_FivePlayers_ReturnsFour() {
        DeckFactory deckFactory = new DeckFactory(5);
        assertEquals(4, deckFactory.getNumExplodingKittenCards());
    }

    // --- generate methods ---

    @Test
    void generateDefuseCards_ReturnsSixCards() {
        DeckFactory deckFactory = new DeckFactory(2);
        assertEquals(6, deckFactory.generateDefuseCards().size());
    }

    @Test
    void generateExplodingKittenCards_TwoPlayers_ReturnsOneCard() {
        DeckFactory deckFactory = new DeckFactory(2);
        assertEquals(1, deckFactory.generateExplodingKittenCards().size());
    }

    @Test
    void generateExplodingKittenCards_FivePlayers_ReturnsFourCards() {
        DeckFactory deckFactory = new DeckFactory(5);
        assertEquals(4, deckFactory.generateExplodingKittenCards().size());
    }

    @Test
    void generateSkipCards_ReturnsFourCards() {
        DeckFactory deckFactory = new DeckFactory(2);
        assertEquals(4, deckFactory.generateSkipCards().size());
    }

    @Test
    void generateAttackCards_ReturnsFourCards() {
        DeckFactory deckFactory = new DeckFactory(2);
        assertEquals(4, deckFactory.generateAttackCards().size());
    }

    @Test
    void generateShuffleCards_ReturnsFourCards() {
        DeckFactory deckFactory = new DeckFactory(2);
        assertEquals(4, deckFactory.generateShuffleCards().size());
    }

    @Test
    void generateSeeTheFutureCards_ReturnsFiveCards() {
        DeckFactory deckFactory = new DeckFactory(2);
        assertEquals(5, deckFactory.generateSeeTheFutureCards().size());
    }

    @Test
    void generateFavorCards_ReturnsFourCards() {
        DeckFactory deckFactory = new DeckFactory(2);
        assertEquals(4, deckFactory.generateFavorCards().size());
    }

    @Test
    void generateNopeCards_ReturnsFiveCards() {
        DeckFactory deckFactory = new DeckFactory(2);
        assertEquals(5, deckFactory.generateNopeCards().size());
    }

    @Test
    void generateCatCards_ReturnsTwentyCards() {
        DeckFactory deckFactory = new DeckFactory(2);
        assertEquals(20, deckFactory.generateCatCards().size());
    }
}