package trie;

import util.TestCaseUtil;

public class TrieTest {
    public static void main(String[] args) {
        test1();
    }

    static void test1() {
        Trie trie = new Trie();
        trie.insert("nitesh");
        trie.insert("nandan");
        TestCaseUtil.test(true, trie.search("nandan"), 1);
        TestCaseUtil.test(true, trie.search("nitesh"), 2);
        TestCaseUtil.test(false, trie.search("nandesh"), 3);
        TestCaseUtil.test(false, trie.search("kumar"), 4);
        TestCaseUtil.test(true, trie.searchPrefix("nite"), 5);
        TestCaseUtil.test(true, trie.searchPrefix("nanda"), 6);
        TestCaseUtil.test(false, trie.searchPrefix("kar"), 7);
    }
}
