package fr.ninauve.renaud.kata.pokerhands.domain.model.figures;

import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Suit.CLUBS;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Suit.DIAMONDS;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Suit.HEARTS;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Suit.SPADES;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.EIGHT;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.FOUR;
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

class FourOfAKindRankingTest {
  static Stream<Arguments> is_four_of_a_kind() {
    return Stream.of(
        hand(TWO.of(DIAMONDS), TWO.of(HEARTS), TWO.of(SPADES), TWO.of(CLUBS), SIX.of(DIAMONDS)));
  }

  static Stream<Arguments> is_not_for_of_a_kind() {
    return Stream.of(
        hand(
            TWO.of(DIAMONDS),
            FOUR.of(DIAMONDS),
            SIX.of(DIAMONDS),
            EIGHT.of(DIAMONDS),
            TEN.of(DIAMONDS)),
        hand(TWO.of(DIAMONDS), TWO.of(HEARTS), TWO.of(SPADES), THREE.of(CLUBS), SIX.of(DIAMONDS)));
  }

  @ParameterizedTest
  @MethodSource
  void is_four_of_a_kind(Hand hand) {
    is_four_of_a_kind(hand, true);
  }

  @ParameterizedTest
  @MethodSource
  void is_not_for_of_a_kind(Hand hand) {
    is_four_of_a_kind(hand, false);
  }

  void is_four_of_a_kind(Hand hand, boolean expected) {
    final boolean actual = new FourOfAKindRanking().matches(hand);
    assertThat(actual).isEqualTo(expected);
  }

  private static Arguments hand(Card card1, Card card2, Card card3, Card card4, Card card5) {
    return Arguments.of(Hand.of(card1, card2, card3, card4, card5));
  }
}
