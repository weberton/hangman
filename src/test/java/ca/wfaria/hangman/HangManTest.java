package ca.wfaria.hangman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HangManTest {
    private Word word;
    private HangMan hangMan;

    @BeforeEach
    public void setup() {
        this.word = new TestRandomWordGenerator("today").getRandWord();
        this.hangMan = new HangMan(word, 7);
    }

    @Test
    public void testHasChance() {
        word = new TestRandomWordGenerator("today").getRandWord();
        hangMan = new HangMan(word, 2);

        hangMan.guess('a');
        assertTrue(hangMan.hasChance());

        hangMan.guess('b');
        assertFalse(hangMan.hasChance());
    }

    @Test
    public void getGuesses_whenThereIsNoGuessRight_returnsArrayHyphen() {
        char[] guesses = hangMan.getGuesses();

        assertEquals(5, guesses.length);
        assertFalse(hangMan.isWordDiscovered());

        for (int i = 0; i < word.getWord().length(); i++) {
            assertEquals('-', guesses[i]);
        }
    }

    @Test
    public void getGuesses_oneGuessRight() {
        hangMan.guess('y');
        char[] guesses = hangMan.getGuesses();

        assertEquals('y', guesses[4]);
        assertFalse(hangMan.isWordDiscovered());
    }

    @Test
    public void getGuesses_allGuessesRight() {
        hangMan.guess('y');
        hangMan.guess('a');
        hangMan.guess('d');
        hangMan.guess('o');
        hangMan.guess('t');

        char[] guesses = hangMan.getGuesses();

        assertEquals('y', guesses[4]);
        assertTrue(hangMan.isWordDiscovered());

        assertEquals('t', guesses[0]);
        assertEquals('o', guesses[1]);
        assertEquals('d', guesses[2]);
        assertEquals('a', guesses[3]);
        assertEquals('y', guesses[4]);
    }

    @Test
    public void getGuesses_throwsException() {
        word = new TestRandomWordGenerator("today").getRandWord();
        hangMan = new HangMan(word, 2);

        hangMan.guess('y');
        hangMan.guess('y');
        assertThrows(IllegalStateException.class, () -> hangMan.guess('y'));

    }

    @Test
    public void isWordDiscovered_whenWordIsRight_returnsTrue() {
        assertTrue(hangMan.isWordDiscovered("TODAY"));
    }

    @Test
    public void isWordDiscovered_whenWordIsWrong_returnsFalse() {
        assertFalse(hangMan.isWordDiscovered("TADAY"));
    }

    @Test
    public void testGetInputtedLetters() {
        //sometimes @BeaforeEach isn't working for some methods
        word = new TestRandomWordGenerator("today").getRandWord();
        hangMan = new HangMan(word, 2);
        hangMan.guess('a');
        hangMan.guess('b');

        assertEquals("ab", hangMan.getInputtedLetters());
    }

}
