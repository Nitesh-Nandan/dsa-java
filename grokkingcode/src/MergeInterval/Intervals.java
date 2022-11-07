package MergeInterval;

public class Intervals {
    int start;
    int end;

    Intervals(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public String toString() {
        return "[" + start + "," + end + "]";
    }
}
