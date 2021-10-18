package Dictionary;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import edu.princeton.cs.algs4.In;

public class DictionaryManagement {
    Dictionary dictionary = new Dictionary();
    Scanner sc = new Scanner(System.in);

    public void insertFromCommandline() {
        System.out.print("Number of word to insert: ");
        int n = sc.nextInt();   sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("Target word: ");
            String wordTarget = sc.nextLine().toLowerCase().trim();
            System.out.print("Explain word: ");
            String wordExplain = sc.nextLine().toLowerCase().trim();

            dictionary.addWord(new Word(wordTarget, wordExplain));
        }
    }

    public void insertFromFile() {
        In in = new In(new File("D:\\Study\\OOP\\src\\Dictionary\\dictionaries.txt"));
        while (!in.isEmpty()) {
            String wordTarget = in.readString().toLowerCase().trim();
            String wordExplain = in.readLine().toLowerCase().trim();
            dictionary.addWord(new Word(wordTarget, wordExplain));
        }
    }

    public void removeFromCommandLine() {
        System.out.print("Number of word to remove: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Word to remove: ");
            String wordTarget = sc.nextLine().toLowerCase().trim();
            String wordExplain = sc.nextLine().toLowerCase().trim();
            dictionary.removeWord(new Word(wordTarget, wordExplain));
        }
    }

    public void dictionaryLookup() {
        System.out.print("Enter exactly the word to find: ");
        String wordToFind = sc.next().toLowerCase().trim();
        for (Word i: dictionary)
            if (i.getWord_target().equals(wordToFind)) {
                System.out.println("Explain word: " + i.getWord_explain());
                return;
            }
        System.out.println("We can not find your word!");
    }

    public void dictionaryExportToFile() throws IOException {
        FileWriter writer = new FileWriter(new File("D:\\Study\\OOP\\src\\Dictionary\\outPut.txt"));
        for (Word i: dictionary) {
            writer.write(i.getWord_target() + "\t" + i.getWord_explain() + "\n");
        }
        writer.close();
    }
}