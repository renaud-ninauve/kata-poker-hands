package fr.ninauve.renaud.kata.pokerhands.domain.model.figures;

import fr.ninauve.renaud.kata.pokerhands.domain.model.Card;
import fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value;
import fr.ninauve.renaud.kata.pokerhands.domain.model.Hand;
import fr.ninauve.renaud.kata.pokerhands.domain.model.RankingResult;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class FourOfAKindRanking implements FigureRanking {

  @Override
  public boolean matches(Hand hand) {
    final Map<Value, Long> groupByValues =
        hand.lowestToHighest().stream()
            .collect(Collectors.groupingBy(Card::value, Collectors.counting()));
    return groupByValues.containsValue(4L);
  }

  @Override
  public RankingResult compareRanks(Hand hand1, Hand hand2) {
    return RankingResult.fromCompareResult(
        Comparator.comparing(this::matches).compare(hand1, hand2));
  }
}
