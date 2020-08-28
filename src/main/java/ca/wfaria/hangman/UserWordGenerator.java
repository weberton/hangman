package ca.wfaria.hangman;

import java.util.Scanner;

/**
 * Class that allows the user to define a word to the game.
 */
public class UserWordGenerator implements WordGenerator {

    private Scanner scanner;

    public UserWordGenerator(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Word getRandWord() {
        System.out.println("Enter the secret word:");
        String word = scanner.next();
        return new Word(word);
    }
}
