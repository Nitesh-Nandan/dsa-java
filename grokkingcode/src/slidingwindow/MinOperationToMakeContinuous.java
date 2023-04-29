package slidingwindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinOperationToMakeContinuous {
    public static int minOperations(int[] nums) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length - 1;
        int index = -1;


        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] - nums[0] == mid) {
                index = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (index == nums.length - 1) return 0;

        int ans = nums.length - index - 1;
        Set<Integer> set = new HashSet<>();

        for (int i = index + 1; i < nums.length; i++) {
            int rnum = nums[i] - nums[0];
            if (!set.contains(rnum) && rnum < nums.length) {
                ans--;
                set.add(rnum);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        test3();
    }

    private static void test1() {
        int[] arr = {4, 2, 5, 3};
        System.out.println(minOperations(arr));
    }

    private static void test2() {
        int[] arr = {1, 2, 3, 5, 6};
        System.out.println(minOperations(arr));
    }

    private static void test3() {
        int[] arr = {1, 10, 100, 1000};
        System.out.println(minOperations(arr));
    }
}
