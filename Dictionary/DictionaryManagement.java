package Dictionary;

import java.util.ArrayList;
import edu.princeton.cs.algs4.*;

class Dictionary {
    ArrayList<Word> a;
}

public class DictionaryManagement {
    private ArrayList<Word> a;

    public void insertFromCommandline() {
        int n = StdIn.readInt();
        for (int i = 0; i < n; i++) {
            String wordTarget = StdIn.readLine();
            String wordExplain = StdIn.readLine();
            a.add(new Word(wordTarget, wordExplain));
        }
    }

    public void insertFromFile() {
        In in = new In("..\\lib\\dictionaries.txt");
        while (!in.isEmpty()) {
            String wordTarget = StdIn.readString();
            String wordExplain = StdIn.readLine();
            a.add(new Word(wordTarget, wordExplain));
        }
    }

    public void showAllWord() {
        StdOut.println("No  |English    |Vietnamese");
        for (int i = 0; i < a.size(); i++)
            StdOut.println(i+1 + "  |" + a.get(i).word_target + "   |" + a.get(i).word_explain);
    }

    public void dictionaryLookup() {
        while (!StdIn.isEmpty()) {
            String wordToFind = StdIn.readString();
            for (Word i: a)
                if (i.word_target.equals(wordToFind)) {
                    StdOut.println(i);
                    break;
                }
        }
    }
}