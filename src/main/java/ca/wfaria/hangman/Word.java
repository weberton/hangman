package ca.wfaria.hangman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class that represents a word.
 */
public class Word {

    private String word;
    private Map<Character, List<Integer>> letters;

    public Word(String word) {
        this.word = word;
        mapLetters(word);
    }

    public List<Integer> getIndexOf(Character c) {
        List<Integer> indexes = letters.get(c);
        return indexes != null ? indexes : Collections.emptyList();
    }

    /**
     * Creates a map of letters. The key is the letter and the value are the index(s) of the letter in the word.
     * It avoids to check for each guess if a word contains a letter and get the indexe(s) of the letter in the word.
     *
     * @param word
     */
    private void mapLetters(String word) {
        Map<Character, List<Integer>> letters = new HashMap<>();

        for (Character c : word.toCharArray()) {
            int index = word.indexOf(c);
            List<Integer> indexes = new ArrayList<>();
            while (index != -1) {
                indexes.add(index);
                index = word.indexOf(c, index + 1);
            }
            letters.put(c, indexes);
        }

        this.letters = letters;
    }

    public String getWord() {
        return word;
    }
}
