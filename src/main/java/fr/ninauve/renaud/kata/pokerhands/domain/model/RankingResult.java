package fr.ninauve.renaud.kata.pokerhands.domain.model;

public enum RankingResult {
  HIGHER,
  LOWER,
  SIMILAR;

  public static RankingResult fromCompareResult(int compareResult) {
    if (compareResult > 0) {
      return HIGHER;
    } else if (compareResult < 0) {
      return LOWER;
    }
    return SIMILAR;
  }

  public RankingResult reverse() {
    return switch (this) {
      case HIGHER -> LOWER;
      case LOWER -> HIGHER;
      case SIMILAR -> SIMILAR;
    };
  }
}
