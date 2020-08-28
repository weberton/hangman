package ca.wfaria.hangman;

import java.util.Scanner;

/**
 * It's an interface between the user and the hangman. It managers the game and the console
 */
public class GameManager {

    private static final int MAX_TRIES = 7;
    private final Scanner sc;
    private WordGenerator wordGenerator;

    public GameManager(Scanner sc) {
        this.sc = sc;
    }

    public void start() {
        this.wordGenerator = createWordGenerator();

        Word word = wordGenerator.getRandWord();
        ConsoleUtil.clearScreen();
        HangMan hangMan = new HangMan(word, MAX_TRIES);

        System.out.println(String.format("The word is %d characters", word.getWord().length()));

        while (hangMan.hasChance()) {
            System.out.println("Letters entered: " + hangMan.getInputtedLetters());

            System.out.println(String.format("What is you guess? %d / %d tries", hangMan.getTries(), MAX_TRIES));

            String letter = sc.next();

            hangMan.guess(letter.toLowerCase().charAt(0));

            if (hangMan.isWordDiscovered()) {
                printWinMessage();
                break;
            } else {
                printGuesses(hangMan.getGuesses());
            }
        }

        if (!hangMan.isWordDiscovered()) {
            handleLatChance(hangMan);
        }

        System.out.println("The word is: " + word.getWord());
    }

    private void handleLatChance(HangMan hangMan) {
        System.out.println("What is the word?");
        String inputWord = sc.next();
        if (hangMan.isWordDiscovered(inputWord)) {
            printWinMessage();
        } else {
            printLooseMessage();
        }

    }

    private WordGenerator createWordGenerator() {
        System.out.println("Please enter the following options:");
        System.out.println("1 - To a random word");
        System.out.println("2 - Enter a word");

        String option = sc.next();

        if (option.equalsIgnoreCase("1")) {
            return new RandomWordGenerator();

        } else if (option.equals("2")) {
            return new UserWordGenerator(sc);
        } else {
            throw new IllegalArgumentException("Invalid option. Restart the game");
        }
    }

    private void printGuesses(char[] guesses) {
        for (int i = 0; i < guesses.length; i++) {
            System.out.print(guesses[i]);
        }
        System.out.println("");
    }

    private void printWinMessage() {
        System.out.println("You win :-)");
    }

    private void printLooseMessage() {
        System.out.println("You loose :-(");
    }

}
