package dp.knapsack01;

import util.TestCaseUtil;

public class PartitionEqualSubset {

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        sum = sum >> 1;

        int row = nums.length;
        boolean[][] dp = new boolean[row + 1][sum + 1];
        for (int i = 0; i <= row; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= row; i++) {
            int val = nums[i - 1];
            for (int j = 0; j <= sum; j++) {
                if (j < val) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - val] || dp[i - 1][j];
                }
            }
        }
        return dp[row][sum];
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    private static void test1() {
        TestCaseUtil.test(true, canPartition(new int[]{1, 5, 11, 5}), 1);
    }

    private static void test2() {
        TestCaseUtil.test(false, canPartition(new int[]{1, 2, 3, 5}), 2);
    }

    private static void test3() {
        TestCaseUtil.test(true, canPartition(new int[]{1, 2, 2, 1}), 3);
    }

    private static void test4() {
        TestCaseUtil.test(true, canPartition(new int[]{14, 9, 8, 4, 3, 2}), 4);
    }
}
