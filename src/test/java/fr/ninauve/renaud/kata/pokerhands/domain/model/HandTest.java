package fr.ninauve.renaud.kata.pokerhands.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Suit;
import fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value;
import org.junit.jupiter.api.Test;

class HandTest {

  @Test
  void equals_when_same_values_different_suits() {

    final Hand hand1 =
        Hand.of(
            Value.TWO.of(Suit.DIAMONDS),
            Value.FOUR.of(Suit.HEARTS),
            Value.SIX.of(Suit.SPADES),
            Value.HEIGHT.of(Suit.CLUBS),
            Value.TEN.of(Suit.SPADES));

    final Hand hand2 =
        Hand.of(
            Value.TWO.of(Suit.HEARTS),
            Value.FOUR.of(Suit.SPADES),
            Value.SIX.of(Suit.HEARTS),
            Value.HEIGHT.of(Suit.SPADES),
            Value.TEN.of(Suit.DIAMONDS));

    final int actual = hand1.compareTo(hand1);

    assertThat(actual).isEqualTo(0);
  }

  @Test
  void straightflush_beats_highcard() {

    final Hand straightFlush =
        Hand.of(
            Value.TWO.of(Suit.DIAMONDS),
            Value.THREE.of(Suit.DIAMONDS),
            Value.FOUR.of(Suit.DIAMONDS),
            Value.FIVE.of(Suit.DIAMONDS),
            Value.SIX.of(Suit.DIAMONDS));

    final Hand highCard =
        Hand.of(
            Value.TWO.of(Suit.DIAMONDS),
            Value.FOUR.of(Suit.HEARTS),
            Value.SIX.of(Suit.SPADES),
            Value.HEIGHT.of(Suit.CLUBS),
            Value.TEN.of(Suit.SPADES));

    final int actual = straightFlush.compareTo(highCard);

    assertThat(actual).isEqualTo(1);
  }
}
