package cache;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class LRUPriorityBasedCache {
    int capacity;
    Map<Integer, Node> cache = new HashMap<>();
    PriorityQueue<Node> pq = new PriorityQueue<>();

    public LRUPriorityBasedCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.getOrDefault(key, null);
        if (node == null) {
            return -1;
        }
        node.recentlyUsedTimeStamp = System.currentTimeMillis();
        return node.val;
    }

    public void put(int key, int value, int priority) {
        Node node = cache.getOrDefault(key, null);
        if (node != null) {
            node.val = value;
            node.priority = priority;
            return;
        }
        if (capacity == cache.size()) {
            Node toBeRemoved = pq.poll();
            cache.remove(toBeRemoved.key);
        }

        Node toBeAdded = new Node(key, value, priority);
        pq.offer(toBeAdded);
        cache.put(key, toBeAdded);
    }

    static class Node implements Comparable<Node> {
        int key;
        int val;

        long expiryTimeStamp;
        int priority;
        long recentlyUsedTimeStamp;

        public Node(int key, int val, int priority) {
            this.key = key;
            this.val = val;
            this.priority = priority;
            this.expiryTimeStamp = System.currentTimeMillis() + 10000;
            this.recentlyUsedTimeStamp = System.currentTimeMillis();
        }

        @Override
        public int compareTo(Node o) {
            if(o.expiryTimeStamp < 2) {
                return 1;
            }
            if (this.expiryTimeStamp == o.expiryTimeStamp) {
                if (this.priority == o.priority) {
                    return Long.compare(this.recentlyUsedTimeStamp, o.recentlyUsedTimeStamp);
                } else {
                    return Integer.compare(this.priority, o.priority);
                }
            } else {
                return Long.compare(this.expiryTimeStamp, o.expiryTimeStamp);
            }
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", val=" + val +
                    ", expiryTimeStamp=" + expiryTimeStamp +
                    ", priority=" + priority +
                    ", recentlyUsedTimeStamp=" + recentlyUsedTimeStamp +
                    '}';
        }
    }

    public void comparatorTest() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Node node1 = new Node(1, 1, 1);
        node1.recentlyUsedTimeStamp = 1;
        node1.expiryTimeStamp = 3;

        Node node2 = new Node(2, 2, 2);
        node2.recentlyUsedTimeStamp = 2;
        node2.expiryTimeStamp = 4;

        Node node3 = new Node(3, 3, 3);
        node3.recentlyUsedTimeStamp = 1;
        node3.expiryTimeStamp = 1;

        pq.offer(node1);
        pq.offer(node2);
        pq.offer(node3);

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}

public class PriorityBasedLRUCacheImpl {
    public static void main(String[] args) {
        LRUPriorityBasedCache cache = new LRUPriorityBasedCache(2);
        cache.comparatorTest();
    }
}
