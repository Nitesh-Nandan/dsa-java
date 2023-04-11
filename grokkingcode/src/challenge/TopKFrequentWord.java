package challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentWord {

    public static List<String> topKFrequent(String[] arr, int k) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String str : arr) {
            freqMap.put(str, freqMap.getOrDefault(str, 0) + 1);
        }

        Queue<Data> queue = new PriorityQueue<>((a, b) -> {
            if (a.freq == b.freq) {
                return a.word.compareTo(b.word);
            } else {
                return Integer.compare(b.freq, a.freq);
            }
        });

        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            queue.offer(new Data(entry.getKey(), entry.getValue()));
        }
        List<String> ans = new ArrayList<>();
        while (!queue.isEmpty() && k-- > 0) {
            ans.add(queue.poll().word);
        }

        return ans;
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    static void test1() {
        String[] arr = {"lets", "play", "cricket", "and", "then", "lets", "play", "badminton"};
        System.out.println(topKFrequent(arr, 3)); // [lets, play, and]
    }

    static void test2() {
        String[] arr = {"for", "every", "action", "there", "is", "an", "equal", "but", "opposite", "reaction"};
        System.out.println(topKFrequent(arr, 2)); // ["action", "an"]

    }

    static class Data {
        String word;
        Integer freq;

        public Data(String word, Integer freq) {
            this.word = word;
            this.freq = freq;
        }
    }
}
