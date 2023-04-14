package util;

public class Pair<T> {
    public T first;
    public T second;

    public Pair(T a, T b) {
        this.first = a;
        this.second = b;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }
}
