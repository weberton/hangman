package ca.wfaria.hangman;

public class TestRandomWordGenerator implements WordGenerator {

    private final String word;

    public TestRandomWordGenerator(String word) {
        this.word = word;
    }

    @Override
    public Word getRandWord() {
        return new Word(word);
    }
}
