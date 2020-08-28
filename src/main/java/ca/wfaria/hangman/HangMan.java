package ca.wfaria.hangman;

import java.util.List;

public class HangMan {

    private final Word word;
    private final int maxTries;
    private char[] guesses;
    private int numberLettersFound;
    private String inputtedLetters = "";
    private int tries = 1;

    public HangMan(Word word, int maxTries) {
        this.word = word;
        this.guesses = createArrayGuess(word.getWord().length());
        this.maxTries = maxTries;
    }

    public void guess(Character letter) {

        if (tries > maxTries) {
            throw new IllegalStateException("Max of tries exceeded");
        }

        tries++;
        inputtedLetters += Character.toString(letter);
        List<Integer> indexes = word.getIndexOf(letter);
        numberLettersFound += fillGuessArray(guesses, letter, indexes);
    }

    public boolean isWordDiscovered() {
        return numberLettersFound == word.getWord().length();
    }

    public boolean isWordDiscovered(String inputWord) {
        return inputWord.equalsIgnoreCase(this.word.getWord());
    }

    public char[] getGuesses() {
        return this.guesses;
    }

    public String getInputtedLetters() {
        return inputtedLetters;
    }

    private char[] createArrayGuess(int size) {
        char[] guesses = new char[size];

        for (int i = 0; i < guesses.length; i++) {
            guesses[i] = '-';
        }

        return guesses;
    }

    public boolean hasChance() {
        return tries <= maxTries;
    }

    public int getTries() {
        return tries;
    }

    private int fillGuessArray(char[] guesses, char letterChar, List<Integer> indexes) {
        int numberLettersFound = 0;
        for (int i : indexes) {
            if (guesses[i] != letterChar) {
                guesses[i] = letterChar;
                numberLettersFound++;
            }
        }
        return numberLettersFound;
    }

}
