package ca.wfaria.hangman;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Generates a random word based on a set of words.
 */
public class RandomWordGenerator implements WordGenerator {

    private static final List<String> WORDS = generateWords();

    @Override
    public Word getRandWord() {
        String generatedWord = WORDS.get(new Random().nextInt(WORDS.size()));

        Word word = new Word(generatedWord);

        return word;
    }

    private static List<String> generateWords() {
        List<String> words = new ArrayList<>();

        words.add("tomorrow");
        words.add("television");
        words.add("mother");
        words.add("dad");
        words.add("father");
        words.add("bedroom");
        words.add("toy");

        return words;
    }

}
