package cache;

import util.TestCaseUtil;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class LRUCache {
    int capacity;
    Map<Integer, Node> cache = new HashMap<>();
    Deque<Node> list = new LinkedList<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.getOrDefault(key, null);
        if (node == null) return -1;
        if (list.getFirst() != node) {
            list.remove(node);
            list.addFirst(node);
        }
        return node.val;
    }

    public void put(int key, int value) {
        Node node = cache.getOrDefault(key, null);
        if (node != null) {
            node.val = value;
            get(key);
            return;
        }
        if (cache.size() == capacity) {
            Node toRemove = list.removeLast();
            cache.remove(toRemove.key);
        }

        Node toBeAdded = new Node(key, value);
        cache.put(key, toBeAdded);
        list.addFirst(toBeAdded);
    }

    static class Node {
        int key;
        int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

public class LRUCacheImpl {

    public static void main(String[] args) {
        test1();
    }

    static void test1() {
//        [[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
        LRUCache cache = new LRUCache(2);
        TestCaseUtil.test(-1, cache.get(2), 1);
        cache.put(2, 6);
        TestCaseUtil.test(-1, cache.get(1), 2);
        cache.put(1, 5);
        cache.put(1, 2);
        TestCaseUtil.test(2, cache.get(1), 3);
        TestCaseUtil.test(6, cache.get(2), 4);
    }
}
