package fr.ninauve.renaud.kata.pokerhands.domain.model.figures;

import fr.ninauve.renaud.kata.pokerhands.domain.model.Card;
import fr.ninauve.renaud.kata.pokerhands.domain.model.Hand;
import fr.ninauve.renaud.kata.pokerhands.domain.model.RankingResult;
import java.util.Comparator;
import java.util.List;

public class FlushRanking {

  public boolean matches(Hand hand) {
    final List<Card> lowestToHighest = hand.lowestToHighest();

    boolean isFirst = true;
    Card previous = null;
    for (Card current : lowestToHighest) {
      if (isFirst) {
        isFirst = false;
        previous = current;
        continue;
      }
      if (!current.value().isNextAfter(previous.value())) {
        return false;
      }
      previous = current;
    }
    return true;
  }

  public RankingResult compareRanks(Hand hand1, Hand hand2) {
    return RankingResult.fromCompareResult(
        Comparator.comparing(this::matches).compare(hand1, hand2));
  }
}
