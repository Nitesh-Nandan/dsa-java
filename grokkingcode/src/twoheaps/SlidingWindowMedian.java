package twoheaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    public static double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        Map<Integer, Integer> mp = new HashMap<>();

        List<Double> ans = new ArrayList<>();
        int itr = 0;
        for (itr = 0; itr < k; itr++) {
            maxHeap.offer(nums[itr]);
        }
        for (int j = 0; j < k / 2; j++) {
            minHeap.offer(maxHeap.poll());
        }
        while (true) {
            if ((k & 1) == 1) {
                ans.add(maxHeap.peek() * 1.0);
            } else {
                ans.add((maxHeap.peek() * 0.5 + minHeap.peek() * 0.5));
            }
            if (itr >= nums.length) {
                break;
            }
            int in = nums[itr];
            int out = nums[itr - k];
            itr++;

            int balance = 0;
            if (!maxHeap.isEmpty() && out <= maxHeap.peek()) {
                balance--;
            } else {
                balance++;
            }
            mp.put(out, mp.getOrDefault(out, 0) + 1);

            if (!maxHeap.isEmpty() && in <= maxHeap.peek()) {
                maxHeap.offer(in);
                balance++;
            } else {
                minHeap.offer(in);
                balance--;
            }

            if (balance < 0) {
                maxHeap.offer(minHeap.poll());
            } else if (balance > 0) {
                minHeap.offer(maxHeap.poll());
            }

            while (!maxHeap.isEmpty() && mp.containsKey(maxHeap.peek())) {
                mp.put(maxHeap.peek(), mp.get(maxHeap.peek()) - 1);
                if (mp.get(maxHeap.peek()) == 0) {
                    mp.remove(maxHeap.peek());
                }
                maxHeap.poll();
            }

            while (!minHeap.isEmpty() && mp.containsKey(minHeap.peek())) {
                mp.put(minHeap.peek(), mp.get(minHeap.peek()) - 1);
                if (mp.get(minHeap.peek()) == 0) {
                    mp.remove(minHeap.peek());
                }
                minHeap.poll();
            }
        }
        return ans.stream().mapToDouble(Double::doubleValue).toArray();
    }

    public static void main(String[] args) {
        double[] ans1 = medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        print(ans1);
    }

    private static void print(double[] arr) {
        for (double d : arr) {
            System.out.print(d + " ");
        }
        System.out.println();
    }
}
