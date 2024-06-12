package fr.ninauve.renaud.kata.pokerhands.domain.model.hand;

import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Suit.CLUBS;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Suit.DIAMONDS;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Suit.HEARTS;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Suit.SPADES;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.EIGHT;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.FIVE;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.FOUR;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.SEVEN;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.SIX;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.TEN;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.THREE;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value.TWO;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.RankingResult.HIGHER;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.RankingResult.LOWER;
import static fr.ninauve.renaud.kata.pokerhands.domain.model.RankingResult.SIMILAR;
import static org.assertj.core.api.Assertions.assertThat;

import fr.ninauve.renaud.kata.pokerhands.domain.model.Hand;
import fr.ninauve.renaud.kata.pokerhands.domain.model.RankingResult;
import org.junit.jupiter.api.Test;

class FlushHandTest {

  @Test
  void flush_beats_highcard() {

    final Hand straightFlush =
        Hand.of(
            TWO.of(DIAMONDS),
            THREE.of(SPADES),
            FOUR.of(DIAMONDS),
            FIVE.of(HEARTS),
            SIX.of(DIAMONDS));

    final Hand highCard =
        Hand.of(TWO.of(DIAMONDS), FOUR.of(HEARTS), SIX.of(SPADES), EIGHT.of(CLUBS), TEN.of(SPADES));

    final RankingResult actual = straightFlush.compareRanks(highCard);

    assertThat(actual).isEqualTo(HIGHER);
  }

  @Test
  void flush_beats_flush() {

    final Hand higher =
        Hand.of(
            THREE.of(DIAMONDS),
            FOUR.of(SPADES),
            FIVE.of(DIAMONDS),
            SIX.of(SPADES),
            SEVEN.of(DIAMONDS));

    final Hand lower =
        Hand.of(TWO.of(SPADES), THREE.of(CLUBS), FOUR.of(SPADES), FIVE.of(CLUBS), SIX.of(SPADES));

    final RankingResult actual = higher.compareRanks(lower);

    assertThat(actual).isEqualTo(HIGHER);
  }

  @Test
  void flush_loses_straightflush() {

    final Hand flush =
        Hand.of(
            THREE.of(DIAMONDS),
            FOUR.of(SPADES),
            FIVE.of(DIAMONDS),
            SIX.of(SPADES),
            SEVEN.of(DIAMONDS));

    final Hand straightFlush =
        Hand.of(TWO.of(HEARTS), THREE.of(HEARTS), FOUR.of(HEARTS), FIVE.of(HEARTS), SIX.of(HEARTS));

    final RankingResult actual = flush.compareRanks(straightFlush);

    assertThat(actual).isEqualTo(LOWER);
  }

  @Test
  void flush_draws_flush() {

    final Hand flush1 =
        Hand.of(
            TWO.of(DIAMONDS),
            THREE.of(SPADES),
            FOUR.of(DIAMONDS),
            FIVE.of(SPADES),
            SIX.of(DIAMONDS));

    final Hand flush2 =
        Hand.of(TWO.of(CLUBS), THREE.of(HEARTS), FOUR.of(CLUBS), FIVE.of(HEARTS), SIX.of(CLUBS));

    final RankingResult actual = flush1.compareRanks(flush2);

    assertThat(actual).isEqualTo(SIMILAR);
  }
}
