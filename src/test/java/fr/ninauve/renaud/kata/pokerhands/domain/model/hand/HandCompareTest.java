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
import static org.assertj.core.api.Assertions.assertThat;

import fr.ninauve.renaud.kata.pokerhands.domain.model.Hand;
import fr.ninauve.renaud.kata.pokerhands.domain.model.RankingResult;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class HandCompareTest {

  static Stream<Arguments> compareSource() {
    final Hand straightFlush = Hand.straightFlush(SIX.of(DIAMONDS));
    final Hand flush = Hand.straightFlush(SIX.of(HEARTS)).replace(SIX.of(HEARTS), SIX.of(SPADES));
    final Hand highCard =
        Hand.of(TWO.of(DIAMONDS), FOUR.of(HEARTS), SIX.of(SPADES), EIGHT.of(CLUBS), TEN.of(SPADES));

    return Stream.of(
        Arguments.of(straightFlush, straightFlush, RankingResult.SIMILAR),
        Arguments.of(straightFlush, highCard, RankingResult.HIGHER),
        Arguments.of(straightFlush, flush, RankingResult.HIGHER),
        Arguments.of(flush, flush, RankingResult.SIMILAR),
        Arguments.of(flush, highCard, RankingResult.HIGHER),
        Arguments.of(highCard, highCard, RankingResult.SIMILAR));
  }

  @ParameterizedTest
  @MethodSource("compareSource")
  void should_compare(Hand hand1, Hand hand2, RankingResult expected) {
    final RankingResult actual = hand1.compareRanks(hand2);
    assertThat(actual).isEqualTo(expected);
  }

  @ParameterizedTest
  @MethodSource("compareSource")
  void should_compare_reverse(Hand hand1, Hand hand2, RankingResult result) {
    final RankingResult expected = result.reverse();
    final RankingResult actual = hand2.compareRanks(hand1);
    assertThat(actual).isEqualTo(expected);
  }
}
