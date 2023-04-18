package util;

public class Pair<K, V> {
    public K first;
    public V second;

    public Pair(K a, V b) {
        this.first = a;
        this.second = b;
    }

    public K getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }
}
