package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void whenMakeCardDeck() {
        CardDeck cardDeck = new CardDeck();
        List<Card> rsl = cardDeck.collect();
        List<Card> expected = new ArrayList<>();
        expected.add(new Card(Card.Suit.Diamonds, Card.Value.V_6));
        expected.add(new Card(Card.Suit.Diamonds, Card.Value.V_7));
        expected.add(new Card(Card.Suit.Diamonds, Card.Value.V_8));
        expected.add(new Card(Card.Suit.Hearts, Card.Value.V_6));
        expected.add(new Card(Card.Suit.Hearts, Card.Value.V_7));
        expected.add(new Card(Card.Suit.Hearts, Card.Value.V_8));
        expected.add(new Card(Card.Suit.Spades, Card.Value.V_6));
        expected.add(new Card(Card.Suit.Spades, Card.Value.V_7));
        expected.add(new Card(Card.Suit.Spades, Card.Value.V_8));
        expected.add(new Card(Card.Suit.Clubs, Card.Value.V_6));
        expected.add(new Card(Card.Suit.Clubs, Card.Value.V_7));
        expected.add(new Card(Card.Suit.Clubs, Card.Value.V_8));
        assertThat(rsl, is(expected));
    }
}