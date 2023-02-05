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

    public TrieNode getRoot() {
        return this.root;
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

    public void printAllStringMatchesToPrefix(String prefix) {
        TrieNode currNode = root;
        for (char ch : prefix.toCharArray()) {
            if (!currNode.getChildren().containsKey(ch)) {
                return;
            }
            currNode = currNode.getChildren().get(ch);
        }
        if (currNode.isWord()) {
            System.out.print(prefix + " ");
        }
        helper(currNode, prefix);
        System.out.println();
    }

    private void helper(TrieNode node, String prefix) {
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (node.getChildren().containsKey(ch)) {
                TrieNode curr = node.getChildren().get(ch);
                if (curr.isWord) {
                    System.out.print(prefix + ch + " ");
                }
                helper(curr, prefix + ch);
            }
        }
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
