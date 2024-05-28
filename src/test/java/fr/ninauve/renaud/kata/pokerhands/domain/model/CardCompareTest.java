package fr.ninauve.renaud.kata.pokerhands.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Suit;
import fr.ninauve.renaud.kata.pokerhands.domain.model.Card.Value;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CardCompareTest {

  @ParameterizedTest(name = "{0}")
  @CsvSource(
      value = {
        "card1.value = card2.value,ACE,ACE,0",
        "card1.value = card2.value + 1,THREE,TWO,1",
        "card1.value = card2.value + 1,FOUR,THREE,1",
        "card1.value = card2.value + 1,FIVE,FOUR,1",
        "card1.value = card2.value + 1,SIX,FIVE,1",
        "card1.value = card2.value + 1,SEVEN,SIX,1",
        "card1.value = card2.value + 1,HEIGHT,SEVEN,1",
        "card1.value = card2.value + 1,NINE,HEIGHT,1",
        "card1.value = card2.value + 1,TEN,NINE,1",
        "card1.value = card2.value + 1,JACK,TEN,1",
        "card1.value = card2.value + 1,QUEEN,JACK,1",
        "card1.value = card2.value + 1,KING,QUEEN,1",
        "card1.value = card2.value + 1,ACE,KING,1",
        "card1.value = card2.value - 1,THREE,TWO,-1"
      })
  void should_order_by_value(String description, String value1, String value2, int expected) {
    final Card card1 = new Card(Value.valueOf(value1), Suit.HEARTS);
    final Card card2 = new Card(Value.valueOf(value2), Suit.HEARTS);

    final int actual = card1.compareTo(card2);

    assertThat(actual).isEqualTo(expected);
  }
}
