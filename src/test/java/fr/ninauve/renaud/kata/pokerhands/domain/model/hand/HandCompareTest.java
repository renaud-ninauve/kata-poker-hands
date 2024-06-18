package fr.ninauve.renaud.kata.pokerhands.domain.model.hand;

import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Suit.CLUBS;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Suit.DIAMONDS;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Suit.HEARTS;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Suit.SPADES;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.EIGHT;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.FOUR;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.KING;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.SEVEN;
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
    final Hand straight = Hand.straightFlush(SIX.of(DIAMONDS));
    final Hand kingStraight = Hand.straightFlush(KING.of(DIAMONDS));
    final Hand sevenStraight = Hand.straightFlush(SEVEN.of(HEARTS));

    final Hand flush = Hand.straightFlush(SIX.of(HEARTS)).replace(SIX.of(HEARTS), SIX.of(SPADES));
    final Hand kingFlush =
        Hand.straightFlush(KING.of(HEARTS)).replace(KING.of(HEARTS), KING.of(SPADES));
    final Hand sevenFlush =
        Hand.straightFlush(SEVEN.of(DIAMONDS)).replace(SEVEN.of(DIAMONDS), SEVEN.of(CLUBS));

    final Hand highCard =
        Hand.of(TWO.of(DIAMONDS), FOUR.of(HEARTS), SIX.of(SPADES), EIGHT.of(CLUBS), TEN.of(SPADES));

    return Stream.of(
        Arguments.of(straight, straight, RankingResult.SIMILAR),
        Arguments.of(straight, highCard, RankingResult.HIGHER),
        Arguments.of(straight, flush, RankingResult.HIGHER),
        Arguments.of(kingStraight, sevenStraight, RankingResult.HIGHER),
        Arguments.of(sevenStraight, kingFlush, RankingResult.HIGHER),
        Arguments.of(flush, flush, RankingResult.SIMILAR),
        Arguments.of(flush, highCard, RankingResult.HIGHER),
        Arguments.of(kingFlush, sevenFlush, RankingResult.HIGHER),
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
