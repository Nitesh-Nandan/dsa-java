package custom;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class LRU {
    private final int size;
    Map<String, CacheNode> map = new HashMap<>();
    LinkedList<CacheNode> list = new LinkedList<>();

    public LRU(int size) {
        this.size = size;
    }

    public void set(String key, String value) {
        evictIfRequired();
        CacheNode cache = new CacheNode(key, value);
        list.addFirst(cache);
        map.put(key, cache);
    }

    private void evictIfRequired() {
        if(map.size() >= size) {
            CacheNode node  = list.getLast();
            list.removeLast();
            map.remove(node.key);
        }
    }

    public String getValue(String key) {
        CacheNode node = map.get(key);
        list.remove(node);
        list.addFirst(node);

        return node.value;
    }

}

public class LRUCacheDemo {
    public static void main(String[] args) {
        test1();
    }

    static void test1() {
        LRU lru = new LRU(3);
        lru.set("City", "Dumka");
        lru.set("Name", "Nitesh");
        System.out.println(lru.getValue("City"));
        System.out.println(lru.getValue("Name"));
        lru.set("Job", "Engineer");
        lru.set("one", "ONE");

    }
}
