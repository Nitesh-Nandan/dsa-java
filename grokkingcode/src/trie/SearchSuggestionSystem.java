package trie;

import java.util.ArrayList;
import java.util.List;

public class SearchSuggestionSystem {

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        SearchTrie searchTrie = new SearchTrie();
        for (String product : products) {
            searchTrie.insert(product);
        }

        List<List<String>> ans = new ArrayList<>();
        String prefix = "";

        for (char ch : searchWord.toCharArray()) {
            prefix = prefix + ch;
            ans.add(searchTrie.getSearchWordsForPrefix(prefix));
        }

        return ans;
    }


    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    static void test1() {
        String[] products = new String[]{"carpet", "cart", "car", "camera", "crate"};
        String searchWord = "camera";

        System.out.println(suggestedProducts(products, searchWord));
    }

    static void test2() {
        String[] products = new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";

        System.out.println(suggestedProducts(products, searchWord));
    }

    static void test3() {
        String[] products = new String[]{"havana"};
        String searchWord = "havana";

        System.out.println(suggestedProducts(products, searchWord));
    }

    static void test4() {
        String[] products = new String[]{"bags", "baggage", "banner", "box", "cloths"};
        String searchWord = "bags";

        System.out.println(suggestedProducts(products, searchWord));
    }

    static void test5() {
        String[] products = new String[]{"havana"};
        String searchWord = "tatiana";

        System.out.println(suggestedProducts(products, searchWord));
    }

    static void test6() {
        String[] products = new String[]{"razer", "blade", "knife", "cutter", "games"};
        String searchWord = "games";

        System.out.println(suggestedProducts(products, searchWord));
    }

}
