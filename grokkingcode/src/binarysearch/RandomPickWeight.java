package binarysearch;


import util.TestCaseUtil;

import java.util.HashMap;
import java.util.Map;

public class RandomPickWeight {
    int[] csum;

    public RandomPickWeight(int[] w) {
        csum = new int[w.length];
        int sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            csum[i] = sum;
        }
    }

    public int pickIndex() {
        double randTarget = csum[csum.length - 1] * Math.random();

        int low = 0;
        int high = csum.length;

        while (low < high) {
            int mid = (low + high) >> 1;
            if (randTarget > csum[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }


    static void test1() {
        int[] weights1 = {1, 2, 3, 4, 5};
        Map<Integer, Integer> freqMap = new HashMap<>();
        int loop = 1000;
        RandomPickWeight randomPickWeight = new RandomPickWeight(weights1);
        while (loop-- > 0) {
            int index = randomPickWeight.pickIndex();
            freqMap.put(index, freqMap.getOrDefault(index, 0) + 1);
        }

        Map.Entry<Integer, Integer> res = null;

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (res == null || res.getValue() < entry.getValue()) {
                res = entry;
            }
        }
        System.out.println(res);
        TestCaseUtil.test(4, res.getKey(), 1);
    }

    static void test2() {
        int[] weights = {1, 12, 23, 34, 45, 56, 67, 78, 89, 90};
        Map<Integer, Integer> freqMap = new HashMap<>();
        int loop = 1000;
        RandomPickWeight randomPickWeight = new RandomPickWeight(weights);
        while (loop-- > 0) {
            int index = randomPickWeight.pickIndex();
            freqMap.put(index, freqMap.getOrDefault(index, 0) + 1);
        }

        Map.Entry<Integer, Integer> res = null;

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (res == null || res.getValue() < entry.getValue()) {
                res = entry;
            }
        }
        System.out.println(res);
        TestCaseUtil.test(9, res.getKey(), 1);
    }

    static void test3() {
        int[] weights1 = {10, 100, 10, 20};
        Map<Integer, Integer> freqMap = new HashMap<>();
        int loop = 1000;
        RandomPickWeight randomPickWeight = new RandomPickWeight(weights1);
        while (loop-- > 0) {
            int index = randomPickWeight.pickIndex();
            freqMap.put(index, freqMap.getOrDefault(index, 0) + 1);
        }

        Map.Entry<Integer, Integer> res = null;

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (res == null || res.getValue() < entry.getValue()) {
                res = entry;
            }
        }
        System.out.println(res);
        TestCaseUtil.test(1, res.getKey(), 1);
    }
}
