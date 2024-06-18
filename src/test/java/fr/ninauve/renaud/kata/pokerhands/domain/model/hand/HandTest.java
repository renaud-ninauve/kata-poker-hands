package fr.ninauve.renaud.kata.pokerhands.domain.model.hand;

import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Suit.DIAMONDS;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Suit.SPADES;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.EIGHT;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.FIVE;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.FOUR;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.NINE;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.SEVEN;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.SIX;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.THREE;
import static org.assertj.core.api.Assertions.assertThat;

import fr.ninauve.renaud.kata.pokerhands.domain.model.Hand;
import org.junit.jupiter.api.Test;

class HandTest {

  @Test
  void shuffled_hands_are_equals() {
    assertThat(
            Hand.of(
                THREE.of(DIAMONDS),
                FOUR.of(SPADES),
                FIVE.of(DIAMONDS),
                SIX.of(SPADES),
                SEVEN.of(DIAMONDS)))
        .isEqualTo(
            Hand.of(
                FOUR.of(SPADES),
                THREE.of(DIAMONDS),
                FIVE.of(DIAMONDS),
                SIX.of(SPADES),
                SEVEN.of(DIAMONDS)));
  }

  @Test
  void create_straight_flush() {
    assertThat(Hand.straightFlush(NINE.of(DIAMONDS)))
        .isEqualTo(Hand.of(
            FIVE.of(DIAMONDS),
            SIX.of(DIAMONDS),
            SEVEN.of(DIAMONDS),
            EIGHT.of(DIAMONDS),
            NINE.of(DIAMONDS)));
  }
}
