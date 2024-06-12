package fr.ninauve.renaud.kata.pokerhands.domain.model.hand.create;

import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Suit.DIAMONDS;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Suit.HEARTS;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Suit.SPADES;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.EIGHT;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.FIVE;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.FOUR;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.JACK;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.NINE;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.SEVEN;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.SIX;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.TEN;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.THREE;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.TWO;
import static org.assertj.core.api.Assertions.assertThat;

import fr.ninauve.renaud.kata.pokerhands.domain.model.Hand;
import org.junit.jupiter.api.Test;

class HandIncrementValuesTest {

  @Test
  void should_incrementValues() {
    final Hand hand =
        Hand.of(
            TWO.of(DIAMONDS),
            FOUR.of(SPADES),
            SIX.of(DIAMONDS),
            EIGHT.of(HEARTS),
            TEN.of(DIAMONDS));

    final Hand actual = hand.incrementValues();

    assertThat(actual)
        .isEqualTo(
            Hand.of(
                THREE.of(DIAMONDS),
                FIVE.of(SPADES),
                SEVEN.of(DIAMONDS),
                NINE.of(HEARTS),
                JACK.of(DIAMONDS)));
  }
}
