package fr.ninauve.renaud.kata.pokerhands.domain.model;

import fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Suit;
import fr.ninauve.renaud.kata.pokerhands.domain.model.figures.FlushPredicate;
import fr.ninauve.renaud.kata.pokerhands.domain.model.figures.StraightFlushPredicate;
import java.util.Comparator;
import java.util.List;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Hand {
  private final List<Card> cards;

  public static Hand of(Card card1, Card card2, Card card3, Card card4, Card card5) {
    return new Hand(List.of(card1, card2, card3, card4, card5));
  }

  public RankingResult compareRanks(Hand other) {
    if (isStraightFlush()) {
      return RankingResult.fromCompareResult(
          Comparator.comparing(Hand::isStraightFlush)
              .thenComparing(Hand::highest)
              .compare(this, other));
    }
    return RankingResult.fromCompareResult(
        Comparator.comparing(Hand::isFlush).compare(this, other));
  }

  public List<Card> lowestToHighest() {
    return cards.stream().sorted(Comparator.comparing(Card::value)).toList();
  }

  public Card highest() {
    return lowestToHighest().get(4);
  }

  public List<Suit> distinctSuits() {
    return cards.stream().map(Card::suit).distinct().toList();
  }

  private boolean isStraightFlush() {
    return new StraightFlushPredicate().test(this);
  }

  private boolean isFlush() {
    return new FlushPredicate().test(this);
  }
}
