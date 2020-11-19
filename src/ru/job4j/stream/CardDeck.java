package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CardDeck {
    public List<Card> collect () {
        return  Stream.of(Card.Suit.values())
                .flatMap(suit -> Stream.of(Card.Value.values())
                        .map(value -> new Card(suit,value)))
                .collect(Collectors.toList());
    }
}
