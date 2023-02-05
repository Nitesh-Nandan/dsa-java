package trie;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SearchTrie {
    SearchTrieNode searchTrieNode;

    public SearchTrie() {
        this.searchTrieNode = new SearchTrieNode();
    }

    public void insert(String word) {
        SearchTrieNode curr = searchTrieNode;
        for (char ch : word.toCharArray()) {
            if (!curr.getChildren().containsKey(ch)) {
                curr.getChildren().put(ch, new SearchTrieNode());
            }
            curr = curr.getChildren().get(ch);
            curr.searchWords.offer(word);
            if (curr.searchWords.size() > 3) {
                curr.searchWords.pollLast();
            }
        }
    }

    public List<String> getSearchWordsForPrefix(String prefix) {
        SearchTrieNode curr = searchTrieNode;
        for (char ch : prefix.toCharArray()) {
            if (!curr.getChildren().containsKey(ch)) {
                return Collections.emptyList();
            }
            curr = curr.getChildren().get(ch);
        }

        return curr.getSearchWords();
    }

    static class SearchTrieNode {
        boolean isWord;
        Map<Character, SearchTrieNode> children;
        LinkedList<String> searchWords;

        public SearchTrieNode() {
            isWord = false;
            children = new HashMap<>();
            searchWords = new LinkedList<>();
        }

        public boolean isWord() {
            return this.isWord;
        }

        public List<String> getSearchWords() {
            return this.searchWords;
        }

        public Map<Character, SearchTrieNode> getChildren() {
            return this.children;
        }
    }
}
