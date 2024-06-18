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
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING,
    ACE;

    public Card of(Suit suit) {
      return new Card(this, suit);
    }

    public boolean isNextAfter(Value other) {
      return this == other.next();
    }

    public Value next() {
      return values()[ordinal() + 1];
    }

    public Value previous() {
      return values()[ordinal() - 1];
    }
  }

  public enum Suit {
    CLUBS,
    DIAMONDS,
    HEARTS,
    SPADES
  }
}
