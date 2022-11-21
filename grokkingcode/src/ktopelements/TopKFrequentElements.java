package ktopelements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public static List<Integer> topKFrequent(int[] arr, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.getValue(), b.getValue()));

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else if (minHeap.peek().getValue() < entry.getValue()) {
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            ans.add(minHeap.poll().getKey());
        }
        return ans;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    static void test1() {
        int[] arr = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6, 7, 7, 8, 2, 3, 1, 1, 1, 10, 11, 5, 6, 2, 4, 7, 8, 5, 6};

        // [10, 11, 8, 4, 7, 3, 6, 2, 5, 1]
        System.out.println(topKFrequent(arr, 10));
    }

    static void test2() {
        int[] arr = new int[]{5, 1, -1, -8, -7, 8, -5, 0, 1, 10, 8, 0, -4, 3, -1, -1, 4, -5, 4, -3, 0, 2, 2, 2, 4, -2, -4, 8, -7, -7, 2, -8, 0, -8, 10, 8, -8, -2, -9, 4, -7, 6, 6, -1, 4, 2, 8, -3, 5, -9, -3, 6, -8, -5, 5, 10, 2, -5, -1, -5, 1, -3, 7, 0, 8, -2, -3, -1, -5, 4, 7, -9, 0, 2, 10, 4, 4, -4, -1, -1, 6, -8, -9, -1, 9, -9, 3, 5, 1, 6, -1, -2, 4, 2, 4, -6, 4, 4, 5, -5};

        // [0, 8, -8, -5, 2, -1, 4]
        System.out.println(topKFrequent(arr, 7));
    }


    static void test3() {
        int[] arr = new int[]{1, 1, 1, 1, 1, 1};

        // [1]
        System.out.println(topKFrequent(arr, 1));
    }

    static void test4() {
        int[] arr = new int[]{6, 0, 1, 4, 9, 7, -3, 1, -4, -8, 4, -7, -3, 3, 2, -3, 9, 5, -4, 0};

        // [0, 9, -4, 1, 4, -3]
        System.out.println(topKFrequent(arr, 6));
    }

    static void test5() {
        int[] arr = new int[]{1};

        // [1]
        System.out.println(topKFrequent(arr, 1));
    }

    static void test6() {
        int[] arr = new int[]{3, 4};

        // [3,4]
        System.out.println(topKFrequent(arr, 2));
    }

}
