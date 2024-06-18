package fr.ninauve.renaud.kata.pokerhands.domain.model.figures;

import fr.ninauve.renaud.kata.pokerhands.domain.model.Hand;
import fr.ninauve.renaud.kata.pokerhands.domain.model.RankingResult;

public class FourOfAKindRanking implements FigureRanking {

  @Override
  public boolean matches(Hand hand) {
    return false;
  }

  @Override
  public RankingResult compareRanks(Hand hand1, Hand hand2) {
    return null;
  }
}
