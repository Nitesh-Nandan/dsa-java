package ktopelements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

    private static String reorganizeString(String str) {
        Map<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            mp.put(str.charAt(i), mp.getOrDefault(str.charAt(i), 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        maxHeap.addAll(mp.entrySet());

        Map.Entry<Character, Integer> prevEntry = null;
        StringBuilder sb = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
            if (prevEntry != null && prevEntry.getValue() > 0) {
                maxHeap.offer(prevEntry);
            }
            sb.append(currentEntry.getKey());
            currentEntry.setValue(currentEntry.getValue() - 1);
            prevEntry = currentEntry;
        }

        return str.length() == sb.length() ? sb.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("programming"));
        System.out.println(reorganizeString("hello"));
        System.out.println(reorganizeString("fofjjb"));
        System.out.println(reorganizeString("abbacdde"));
        System.out.println(reorganizeString("aba"));
        System.out.println(reorganizeString("awesome"));
    }
}
