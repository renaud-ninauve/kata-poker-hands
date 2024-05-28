package fr.ninauve.renaud.kata.pokerhands.domain.model;

public record Card(Value value, Suit suit) implements Comparable<Card> {

  @Override
  public int compareTo(Card other) {
    return this.value.compareTo(other.value);
  }

  public enum Value {
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    HEIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING,
    ACE;
  }

  public enum Suit {
    CLUBS,
    DIAMONDS,
    HEARTS,
    SPADES
  }
}
