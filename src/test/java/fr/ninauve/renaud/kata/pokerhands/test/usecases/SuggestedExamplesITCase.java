package fr.ninauve.renaud.kata.pokerhands.test.usecases;

import static org.mockito.Mockito.verify;

import fr.ninauve.renaud.kata.pokerhands.PokerApplication;
import fr.ninauve.renaud.kata.pokerhands.Printer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SuggestedExamplesITCase {
  @InjectMocks PokerApplication sut;
  @Mock Printer printer;

  @ParameterizedTest
  @CsvSource(
      delimiterString = " -> ",
      value = {
        "Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH -> White wins. - with high card: Ace",
        "Black: 2H 4S 4C 2D 4H  White: 2S 8S AS QS 3S -> Black wins. - with full house: 4 over 2",
        "Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C KH -> Black wins. - with high card: 9",
        "Black: 2H 3D 5S 9C KD  White: 2D 3H 5C 9S KH -> Tie."
      })
  void should_handle_suggested_examples(String input, String expected) {
    sut.play(input);

    verify(printer).print(expected);
  }
}
