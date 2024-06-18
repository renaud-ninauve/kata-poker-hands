package fr.ninauve.renaud.kata.pokerhands.domain.model;

import fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Suit;
import fr.ninauve.renaud.kata.pokerhands.domain.model.figures.FigureRanking;
import fr.ninauve.renaud.kata.pokerhands.domain.model.figures.FlushRanking;
import fr.ninauve.renaud.kata.pokerhands.domain.model.figures.StraightFlushRanking;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Hand {
  private final Set<Card> cards;

  public static Hand of(Card card1, Card card2, Card card3, Card card4, Card card5) {
    return new Hand(Set.of(card1, card2, card3, card4, card5));
  }

  public RankingResult compareRanks(Hand other) {
    final List<FigureRanking> rankings = List.of(new StraightFlushRanking(), new FlushRanking());

    return rankings.stream()
        .filter(ranking -> ranking.matches(this) || ranking.matches(other))
        .findFirst()
        .map(ranking -> ranking.compareRanks(this, other))
        .orElse(RankingResult.SIMILAR);
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

  public Hand replace(Card card, Card replacement) {
    final Set<Card> newCards =
        cards.stream()
            .map(current -> current.equals(card) ? replacement : current)
            .collect(Collectors.toSet());
    return new Hand(newCards);
  }

  public Hand incrementValues() {
    final Set<Card> newCards =
        cards.stream().map(card -> card.value().next().of(card.suit())).collect(Collectors.toSet());
    return new Hand(newCards);
  }
}
