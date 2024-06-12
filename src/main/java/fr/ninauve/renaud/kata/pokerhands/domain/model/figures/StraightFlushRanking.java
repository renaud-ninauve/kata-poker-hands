package fr.ninauve.renaud.kata.pokerhands.domain.model.figures;

import fr.ninauve.renaud.kata.pokerhands.domain.model.Hand;
import fr.ninauve.renaud.kata.pokerhands.domain.model.RankingResult;
import java.util.Comparator;

public class StraightFlushRanking {
  private final FlushRanking flushPredicate = new FlushRanking();

  public boolean matches(Hand hand) {
    return hand.distinctSuits().size() == 1 && isFlush(hand);
  }

  public RankingResult compareRanks(Hand hand1, Hand hand2) {
    return RankingResult.fromCompareResult(
        Comparator.comparing(this::matches).thenComparing(Hand::highest).compare(hand1, hand2));
  }

  private boolean isFlush(Hand hand) {
    return flushPredicate.matches(hand);
  }
}
