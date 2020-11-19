package ru.job4j.stream;

import java.util.List;

public class Card {
    public enum Suit {
        Diamonds, Hearts, Spades, Clubs
    }

    public enum Value {
        V_6, V_7, V_8
    }

    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        /*
        Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Value.values())
                        .map(value -> suit + " " + value))
                .forEach(System.out::println);
*/
        CardDeck cardDeck = new CardDeck();
        List<Card> rsl = cardDeck.collect();
        for (Card card: rsl) {
            System.out.println(card.suit+" "+card.value);
        }
    }
}
