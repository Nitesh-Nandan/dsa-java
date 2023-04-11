package custom;

public class CacheNode {
    String key;
    String value;
    int freq;

    public CacheNode(String key, String value) {
        this.key = key;
        this.value = value;
        this.freq = 0;
    }

    public CacheNode(String key, String value, int freq) {
        this.key = key;
        this.value = value;
        this.freq = freq;
    }

    public void increment() {
        this.freq++;
    }

    @Override
    public String toString() {
        return "[Key:" + key + ", Value:" + value + ", feq:" + freq + "]";
    }
}
