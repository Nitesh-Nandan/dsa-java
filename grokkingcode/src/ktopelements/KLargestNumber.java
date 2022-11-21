package ktopelements;

import util.TestCaseUtil;

import java.util.PriorityQueue;

public class KLargestNumber {
    public static int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a, b));

        for (int num : arr) {
            if (minHeap.size() < k) {
                minHeap.offer(num);
            } else if (minHeap.peek() < num) {
                minHeap.poll();
                minHeap.offer(num);
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    static void test1() {
        int[] arr = new int[]{1, 5, 12, 2, 11, 9, 7, 30, 20};
        TestCaseUtil.test(12, findKthLargest(arr, 3), 1);
    }

    static void test2() {
        int[] arr = new int[]{23, 13, 17, 19, 10};
        TestCaseUtil.test(13, findKthLargest(arr, 4), 2);
    }

    static void test3() {
        int[] arr = new int[]{3, 2, 5, 6, 7};
        TestCaseUtil.test(2, findKthLargest(arr, 5), 3);
    }

    static void test4() {
        int[] arr = new int[]{1, 4, 6, 0, 2};
        TestCaseUtil.test(6, findKthLargest(arr, 1), 4);
    }

    static void test5() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        TestCaseUtil.test(1, findKthLargest(arr, 7), 5);
    }
}
