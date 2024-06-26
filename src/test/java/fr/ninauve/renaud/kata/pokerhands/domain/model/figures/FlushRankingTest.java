package fr.ninauve.renaud.kata.pokerhands.domain.model.figures;

import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Suit.DIAMONDS;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Suit.SPADES;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.EIGHT;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.FIVE;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.FOUR;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.SEVEN;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.SIX;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.TEN;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.THREE;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.TWO;
import static org.assertj.core.api.Assertions.assertThat;

import fr.ninauve.renaud.kata.pokerhands.domain.model.Card;
import fr.ninauve.renaud.kata.pokerhands.domain.model.Hand;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FlushRankingTest {

  static Stream<Arguments> is_flush() {
    return Stream.of(
        hand(
            TWO.of(DIAMONDS),
            THREE.of(DIAMONDS),
            FOUR.of(DIAMONDS),
            FIVE.of(DIAMONDS),
            SIX.of(DIAMONDS)),
        hand(
            TWO.of(DIAMONDS),
            THREE.of(SPADES),
            FOUR.of(DIAMONDS),
            FIVE.of(DIAMONDS),
            SIX.of(DIAMONDS)));
  }

  static Stream<Arguments> is_not_flush() {
    return Stream.of(
        hand(
            TWO.of(DIAMONDS),
            FOUR.of(DIAMONDS),
            SIX.of(DIAMONDS),
            EIGHT.of(DIAMONDS),
            TEN.of(DIAMONDS)),
        hand(
            TWO.of(DIAMONDS),
            THREE.of(SPADES),
            FOUR.of(DIAMONDS),
            FIVE.of(DIAMONDS),
            SEVEN.of(DIAMONDS)));
  }

  @ParameterizedTest
  @MethodSource
  void is_flush(Hand hand) {
    is_flush(hand, true);
  }

  @ParameterizedTest
  @MethodSource
  void is_not_flush(Hand hand) {
    is_flush(hand, false);
  }

  void is_flush(Hand hand, boolean expected) {
    final boolean actual = new FlushRanking().matches(hand);
    assertThat(actual).isEqualTo(expected);
  }

  private static Arguments hand(Card card1, Card card2, Card card3, Card card4, Card card5) {
    return Arguments.of(Hand.of(card1, card2, card3, card4, card5));
  }
}
