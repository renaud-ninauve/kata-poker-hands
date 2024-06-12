package fr.ninauve.renaud.kata.pokerhands.domain.model.hand;

import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Suit.DIAMONDS;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Suit.HEARTS;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Suit.SPADES;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.EIGHT;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.FOUR;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.SEVEN;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.SIX;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.TEN;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.TWO;
import static org.assertj.core.api.Assertions.assertThat;

import fr.ninauve.renaud.kata.pokerhands.domain.model.Card;
import fr.ninauve.renaud.kata.pokerhands.domain.model.Hand;
import org.junit.jupiter.api.Test;

class HandReplaceTest {

  @Test
  void should_replace() {
    final Card card = SIX.of(DIAMONDS);
    final Card replacement = SEVEN.of(HEARTS);

    final Hand hand =
        Hand.of(TWO.of(DIAMONDS), FOUR.of(SPADES), card, EIGHT.of(HEARTS), TEN.of(DIAMONDS));

    final Hand actual = hand.replace(card, replacement);

    assertThat(actual)
        .isEqualTo(
            Hand.of(
                TWO.of(DIAMONDS),
                FOUR.of(SPADES),
                replacement,
                EIGHT.of(HEARTS),
                TEN.of(DIAMONDS)));
  }
}
