package fr.ninauve.renaud.kata.pokerhands.domain.model;

import fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Suit;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Hand implements Comparable<Hand> {
  private final List<Card> cards;

  public static Hand of(Card card1, Card card2, Card card3, Card card4, Card card5) {
    return new Hand(List.of(card1, card2, card3, card4, card5));
  }

  @Override
  public int compareTo(Hand other) {
    final boolean handIsStraightFlush = this.isStraightFlush();
    final boolean otherIsStraightFlush = other.isStraightFlush();

    return Boolean.compare(handIsStraightFlush, otherIsStraightFlush);
  }

  private boolean isStraightFlush() {
    return distinctSuits().size() == 1;
  }

  private List<Suit> distinctSuits() {
    return cards.stream().map(Card::suit).distinct().toList();
  }
}
