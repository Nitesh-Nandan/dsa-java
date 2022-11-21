package javads;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class JavaMapDemo {

    public static void main(String[] args) {
        test();
    }

    static void test() {
        Map<Character, Integer> mp = new HashMap<>();
        mp.put('C', 2);
        mp.put('A', 2);
        mp.put('X', 1);

        System.out.println(mp.entrySet());

        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a,b) -> Integer.compare(a.getValue(), b.getValue()));
        queue.addAll(mp.entrySet());

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
