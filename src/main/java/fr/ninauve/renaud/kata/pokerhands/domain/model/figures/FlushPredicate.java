package fr.ninauve.renaud.kata.pokerhands.domain.model.figures;

import fr.ninauve.renaud.kata.pokerhands.domain.model.Card;
import fr.ninauve.renaud.kata.pokerhands.domain.model.Hand;
import java.util.List;
import java.util.function.Predicate;

public class FlushPredicate implements Predicate<Hand> {

  @Override
  public boolean test(Hand hand) {
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
}
