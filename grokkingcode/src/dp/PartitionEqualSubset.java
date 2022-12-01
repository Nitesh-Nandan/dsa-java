package dp;

import util.TestCaseUtil;

import java.util.Arrays;
import java.util.Collections;

// very-very inefficient way of doing it.
class Solution1 {
    public static boolean canPartitionArray(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        if (sum % 2 == 1) return false;

        int[] nums = Arrays.stream(arr).boxed()
                .sorted((a, b) -> Integer.compare(b, a))
                .mapToInt(Integer::intValue)
                .toArray();

        int[] sums = new int[2];
        return canPartitionArrayHelper(nums, sums, 0, sum >> 1);
    }

    private static boolean canPartitionArrayHelper(int[] nums, int[] sums, int index, int tar) {
        if (index == nums.length) {
            return sums[0] == sums[1];
        }
        int val = nums[index];
        for (int i = 0; i < 2; i++) {
            if (sums[i] + val <= tar) {
                sums[i] = sums[i] + val;
                if (canPartitionArrayHelper(nums, sums, index + 1, tar)) {
                    return true;
                }
                sums[i] = sums[i] - val;
            }
        }
        return false;
    }
}

class Solution2 {
    public static boolean canPartitionArray(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        if (sum % 2 == 1) return false;
        int tar = sum >> 1;

        return isTargetPossible(arr, 0, 0, tar);
    }

    private static boolean isTargetPossible(int[] arr, int index, int curr, int tar) {
        if (curr == tar) return true;
        if (index == arr.length) return false;

        boolean ans = false;
        ans = isTargetPossible(arr, index + 1, curr + arr[index], tar);
        ans = ans | isTargetPossible(arr, index + 1, curr, tar);
        return ans;
    }
}

class Solution3 {
    public static boolean canPartitionArray(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        if (sum % 2 == 1) return false;
        int tar = sum >> 1;
        boolean[] dp = new boolean[tar + 1];
        dp[0] = true;
        int[] nums = Arrays.stream(arr).boxed()
                .sorted((a, b) -> Integer.compare(b, a))
                .mapToInt(Integer::intValue)
                .toArray();

        for (int coin : nums) {
            if (coin > tar) return false;
            for (int k = tar; k >= coin; k--) {
                if (dp[k - coin]) {
                    dp[k] = dp[k - coin];
                }
            }
        }
        return dp[tar];
    }
}

public class PartitionEqualSubset {
    public static void main(String[] args) {
        test3();
        test1();
        test2();
    }

    static void test1() {
        int[] arr = {3, 1, 1, 2, 2, 1};
        TestCaseUtil.test(true, Solution1.canPartitionArray(arr), 1);
        TestCaseUtil.test(true, Solution2.canPartitionArray(arr), 1);
        TestCaseUtil.test(true, Solution3.canPartitionArray(arr), 1);
    }

    static void test2() {
        int[] arr = {1, 2, 5};
        TestCaseUtil.test(false, Solution1.canPartitionArray(arr), 2);
        TestCaseUtil.test(false, Solution2.canPartitionArray(arr), 2);
        TestCaseUtil.test(false, Solution3.canPartitionArray(arr), 2);
    }

    static void test3() {
        int[] arr = {2, 2, 1, 1};
        TestCaseUtil.test(true, Solution1.canPartitionArray(arr), 3);
        TestCaseUtil.test(true, Solution2.canPartitionArray(arr), 3);
        TestCaseUtil.test(true, Solution3.canPartitionArray(arr), 3);
    }
}
