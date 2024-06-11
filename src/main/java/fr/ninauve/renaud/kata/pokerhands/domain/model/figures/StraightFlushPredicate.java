package fr.ninauve.renaud.kata.pokerhands.domain.model.figures;

import fr.ninauve.renaud.kata.pokerhands.domain.model.Hand;
import java.util.function.Predicate;

public class StraightFlushPredicate implements Predicate<Hand> {
  private final FlushPredicate flushPredicate = new FlushPredicate();

  @Override
  public boolean test(Hand hand) {

    return hand.distinctSuits().size() == 1 && isFlush(hand);
  }

  private boolean isFlush(Hand hand) {
    return flushPredicate.test(hand);
  }
}
