package Dictionary;

public class Word {
    String word_target, word_explain;

    public Word(String word_target, String word_explain) {
        this.word_target = word_target;
        this.word_explain = word_explain;
    }

    public String toString() {
        return word_target + ": " + word_explain;
    }
}