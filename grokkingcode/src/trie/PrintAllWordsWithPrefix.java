package trie;

import java.util.Arrays;
import java.util.List;

public class PrintAllWordsWithPrefix {

    public static void main(String[] args) {
        test1();
    }

    static void test1() {
        List<String> words = Arrays.asList("bat", "batter", "bats", "bar", "best", "bear");
        Trie trie = new Trie();
        words.forEach(trie::insert);

        trie.printAllStringMatchesToPrefix("b");
        trie.printAllStringMatchesToPrefix("be");
        trie.printAllStringMatchesToPrefix("bes");
    }
}
