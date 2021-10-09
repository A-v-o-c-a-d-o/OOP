package Dictionary;

/* import edu.princeton.cs.algs4.StdIn; */
public class DictionaryCommandLine {
    private DictionaryManagement manager = new DictionaryManagement();

    public void dictionaryBasic() {
        manager.insertFromCommandline();
        manager.showAllWord();
    }

    public void dictionaryAdvanced() {
        manager.insertFromFile();
        manager.showAllWord();
        manager.dictionaryLookup();
    }

    public void dictionarySearcher() {

    }
}