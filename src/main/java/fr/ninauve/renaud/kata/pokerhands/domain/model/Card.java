package fr.ninauve.renaud.kata.pokerhands.domain.model;

public record Card(Value value, Suit suit) {

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
