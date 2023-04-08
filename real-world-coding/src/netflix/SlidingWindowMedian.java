package netflix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    public static List<Double> medianSlidingWindow(int[] nums, int k){
        PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
        PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>();
        Map<Integer, Integer> outEleFreqMap = new HashMap<>();
        List<Double> ans = new ArrayList<>();

        for(int i=0; i<k;i++) {
            leftMaxHeap.offer(nums[i]);
            if(leftMaxHeap.size() - rightMinHeap.size() > 1) {
                rightMinHeap.offer(leftMaxHeap.poll());
            }
        }

        for(int i=k; i<nums.length; i++) {
            int out = nums[i-k];

        }

        return ans;
    }


    public static void main(String[] args) {
        test1();
    }

    static void test1() {
        int[] nums = new int[]{1,3,-1,2,-2,-3,5,1,5,3};
        List<Double> medians = medianSlidingWindow(nums, 4);
        System.out.println(medians); // [1.5 0.5 -1.5 0 -0.5 3 4]
    }
}
