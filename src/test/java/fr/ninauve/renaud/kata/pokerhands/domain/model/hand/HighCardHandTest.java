package fr.ninauve.renaud.kata.pokerhands.domain.model.hand;

import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Suit.CLUBS;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Suit.DIAMONDS;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Suit.HEARTS;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Suit.SPADES;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.EIGHT;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.FOUR;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.SIX;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.TEN;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.TWO;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.RankingResult.SIMILAR;
import static org.assertj.core.api.Assertions.assertThat;

import fr.ninauve.renaud.kata.pokerhands.domain.model.Hand;
import fr.ninauve.renaud.kata.pokerhands.domain.model.RankingResult;
import org.junit.jupiter.api.Test;

class HighCardHandTest {

  @Test
  void equals_when_same_values_different_distinctSuits() {

    final Hand hand1 =
        Hand.of(TWO.of(DIAMONDS), FOUR.of(HEARTS), SIX.of(SPADES), EIGHT.of(CLUBS), TEN.of(SPADES));

    final Hand hand2 =
        Hand.of(
            TWO.of(HEARTS), FOUR.of(SPADES), SIX.of(HEARTS), EIGHT.of(SPADES), TEN.of(DIAMONDS));

    final RankingResult actual = hand1.compareRanks(hand2);

    assertThat(actual).isEqualTo(SIMILAR);
  }
}
