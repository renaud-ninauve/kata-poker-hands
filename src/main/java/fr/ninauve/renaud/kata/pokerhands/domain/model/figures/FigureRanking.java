package fr.ninauve.renaud.kata.pokerhands.domain.model.figures;

import fr.ninauve.renaud.kata.pokerhands.domain.model.Hand;
import fr.ninauve.renaud.kata.pokerhands.domain.model.RankingResult;

public interface FigureRanking {

  boolean matches(Hand hand);

  RankingResult compareRanks(Hand hand1, Hand hand2);
}
