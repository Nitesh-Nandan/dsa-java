package cache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;


class LFUCache {
    int capacity;
    int minFreq;
    Map<Integer, Node> cache = new HashMap<>();
    Map<Integer, LinkedHashSet<Integer>> freqKeyListMap = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
    }

    public int get(int key) {
        Node node = cache.getOrDefault(key, null);
        if (node == null) return -1;

        LinkedHashSet<Integer> keysSet = freqKeyListMap.get(node.freq);
        keysSet.remove(key);
        if (keysSet.isEmpty()) {
            freqKeyListMap.remove(node.freq);
            if (minFreq == node.freq) {
                minFreq++;
            }
        }
        node.inc();
        freqKeyListMap.putIfAbsent(node.freq, new LinkedHashSet<>());
        freqKeyListMap.get(node.freq).add(key);

        return node.val;
    }

    public void put(int key, int value) {
        Node node = cache.getOrDefault(key, null);
        if (node != null) {
            node.val = value;
            get(key);
            return;
        }

        if (capacity == cache.size()) {
            LinkedHashSet<Integer> keySet = freqKeyListMap.get(minFreq);
            Integer keyToRemove = keySet.iterator().next();
            cache.remove(keyToRemove);
            keySet.remove(keyToRemove);
            if (keySet.isEmpty()) {
                freqKeyListMap.remove(minFreq);
            }
        }

        minFreq = 1;
        cache.put(key, new Node(key, value));
        freqKeyListMap.putIfAbsent(minFreq, new LinkedHashSet<>());
        freqKeyListMap.get(minFreq).add(key);
    }


    static class Node {
        int key;
        int val;
        int freq;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }

        public void inc() {
            this.freq++;
        }
    }
}

public class LFUCacheImpl {
    public static void main(String[] args) {
        test1();
    }

    static void test1() {
        LFUCache cache = new LFUCache(3);
        cache.put(2, 2);
        cache.put(1, 1);

        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));

        cache.put(3, 3);
        cache.put(4, 4);

        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        System.out.println(cache.get(4));
    }

}

