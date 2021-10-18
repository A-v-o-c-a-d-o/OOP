package Dictionary;

public class Word implements Comparable<Word> {
    private String word_target, word_explain;

    public String getWord_target() {
        return word_target;
    }

    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    public String getWord_explain() {
        return word_explain;
    }

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }

    public Word(String word_target, String word_explain) {
        this.word_target = word_target;
        this.word_explain = word_explain;
    }

    public Word(Word word) {
        this.word_target = word.getWord_target();
        this.word_explain = word.getWord_explain();
    }

    public String toString() {
        String ans = "|" + word_target;
        for (int i = 0; i < 20-word_target.length(); i++) ans += " ";
        return ans + "|" + word_explain;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((word_explain == null) ? 0 : word_explain.hashCode());
        result = prime * result + ((word_target == null) ? 0 : word_target.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Word other = (Word) obj;
        if (word_explain == null) {
            if (other.word_explain != null)
                return false;
        } else if (!word_explain.equals(other.word_explain))
            return false;
        if (word_target == null) {
            if (other.word_target != null)
                return false;
        } else if (!word_target.equals(other.word_target))
            return false;
        return true;
    }

    @Override
    public int compareTo(Word o) {
        return word_target.concat(word_explain).compareTo(o.getWord_target().concat(o.getWord_explain()));
    }
}