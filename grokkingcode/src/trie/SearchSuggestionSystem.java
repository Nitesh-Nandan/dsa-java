package trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchSuggestionSystem {

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        for (String product : products) {
            trie.insert(product);
        }
        List<List<String>> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : searchWord.toCharArray()) {
            sb.append(ch);
            ans.add(getPrefixMatch(trie.getRoot(), sb.toString(), 3));
        }
        return ans;
    }

    static List<String> getPrefixMatch(Trie.TrieNode trieNode, String str, int limit) {
        return Collections.emptyList();
    }

    public static void main(String[] args) {
        test1();
    }

    static void test1() {
        String[] products = new String[]{"carpet", "cart", "car", "camera", "crate"};
        String searchWord = "camera";

        System.out.println(suggestedProducts(products, searchWord));
    }

}
