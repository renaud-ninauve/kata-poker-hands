package fr.ninauve.renaud.kata.pokerhands.domain.model;

import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Suit.CLUBS;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Suit.DIAMONDS;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Suit.HEARTS;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Suit.SPADES;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.EIGHT;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.FIVE;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.FOUR;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.SIX;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.TEN;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.THREE;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.TWO;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class HandTest {

  @Test
  void equals_when_same_values_different_distinctSuits() {

    final Hand hand1 =
        Hand.of(TWO.of(DIAMONDS), FOUR.of(HEARTS), SIX.of(SPADES), EIGHT.of(CLUBS), TEN.of(SPADES));

    final Hand hand2 =
        Hand.of(
            TWO.of(HEARTS), FOUR.of(SPADES), SIX.of(HEARTS), EIGHT.of(SPADES), TEN.of(DIAMONDS));

    final int actual = hand1.compareTo(hand2);

    assertThat(actual).isZero();
  }

  @Test
  void straightflush_beats_highcard() {

    final Hand straightFlush =
        Hand.of(
            TWO.of(DIAMONDS),
            THREE.of(DIAMONDS),
            FOUR.of(DIAMONDS),
            FIVE.of(DIAMONDS),
            SIX.of(DIAMONDS));

    final Hand highCard =
        Hand.of(TWO.of(DIAMONDS), FOUR.of(HEARTS), SIX.of(SPADES), EIGHT.of(CLUBS), TEN.of(SPADES));

    final int actual = straightFlush.compareTo(highCard);

    assertThat(actual).isEqualTo(1);
  }

  @Test
  void straightflush_beats_flush() {

    final Hand straightFlush =
        Hand.of(
            TWO.of(DIAMONDS),
            THREE.of(DIAMONDS),
            FOUR.of(DIAMONDS),
            FIVE.of(DIAMONDS),
            SIX.of(DIAMONDS));

    final Hand flush =
        Hand.of(TWO.of(CLUBS), FOUR.of(CLUBS), SIX.of(CLUBS), EIGHT.of(CLUBS), TEN.of(CLUBS));

    final int actual = straightFlush.compareTo(flush);

    assertThat(actual).isEqualTo(1);
  }
}
