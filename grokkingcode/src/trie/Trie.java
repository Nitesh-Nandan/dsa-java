package trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode currNode = root;
        for (char ch : word.toCharArray()) {
            if (!currNode.getChildren().containsKey(ch)) {
                currNode.getChildren().put(ch, new TrieNode());
            }
            currNode = currNode.getChildren().get(ch);
        }
        currNode.isWord = true;
    }

    public boolean search(String word) {
        TrieNode currNode = root;
        for (char ch : word.toCharArray()) {
            if (!currNode.getChildren().containsKey(ch)) {
                return false;
            }
            currNode = currNode.getChildren().get(ch);
        }

        return currNode.isWord;
    }

    public boolean searchPrefix(String prefix) {
        TrieNode currNode = root;
        for (char ch : prefix.toCharArray()) {
            if (!currNode.getChildren().containsKey(ch)) {
                return false;
            }
            currNode = currNode.getChildren().get(ch);
        }
        return true;
    }

    static class TrieNode {
        boolean isWord;
        Map<Character, TrieNode> children;

        public TrieNode() {
            this.isWord = false;
            this.children = new HashMap<>();
        }

        public boolean isWord() {
            return this.isWord;
        }

        public Map<Character, TrieNode> getChildren() {
            return this.children;
        }
    }
}
