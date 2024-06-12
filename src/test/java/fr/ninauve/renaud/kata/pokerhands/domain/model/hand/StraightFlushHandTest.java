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
import static fr.ninauve.renaud.kata.pokerhands.domain.model.RankingResult.SIMILAR;
import static org.assertj.core.api.Assertions.assertThat;

import fr.ninauve.renaud.kata.pokerhands.domain.model.Hand;
import fr.ninauve.renaud.kata.pokerhands.domain.model.RankingResult;
import org.junit.jupiter.api.Test;

class StraightFlushHandTest {

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

    final RankingResult actual = straightFlush.compareRanks(highCard);

    assertThat(actual).isEqualTo(HIGHER);
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

    final RankingResult actual = straightFlush.compareRanks(flush);

    assertThat(actual).isEqualTo(HIGHER);
  }

  @Test
  void straightflush_beats_straightflush() {

    final Hand higher =
        Hand.of(
            THREE.of(SPADES), FOUR.of(SPADES), FIVE.of(SPADES), SIX.of(SPADES), SEVEN.of(SPADES));

    final Hand lower =
        Hand.of(
            TWO.of(DIAMONDS),
            THREE.of(DIAMONDS),
            FOUR.of(DIAMONDS),
            FIVE.of(DIAMONDS),
            SIX.of(DIAMONDS));

    final RankingResult actual = higher.compareRanks(lower);

    assertThat(actual).isEqualTo(HIGHER);
  }
}