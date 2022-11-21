package ktopelements;

import util.TestCaseUtil;

import java.util.PriorityQueue;

public class KLargestNumberInStream {

    static int kThLargestElement(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            if (minHeap.size() == k && minHeap.peek() < nums[i]) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            } else if (minHeap.size() < k) {
                minHeap.offer(nums[i]);
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        TestCaseUtil.test(6, kThLargestElement(new int[]{3, 6, 9, 10, 4}, 3), 1);
        TestCaseUtil.test(7, kThLargestElement(new int[]{3, 6, 9, 10, 4, 7}, 3), 2);
        TestCaseUtil.test(9, kThLargestElement(new int[]{3, 6, 9, 10, 4, 7, 10}, 3), 3);
    }
}
