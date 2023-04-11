package challenge;

import util.TestCaseUtil;

public class HouseRobber {
    public static int robHouses(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int include = nums[i] + dp[i - 1][1];
            int exclude = dp[i - 1][0];
            dp[i][0] = Math.max(include, dp[i - 1][0]);
            dp[i][1] = exclude;
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    static void test1() {
        int[] values = {0, 1, 2, 5};
        TestCaseUtil.test(6, robHouses(values), 1);
    }

    static void test2() {
        int[] values = {1, 2, 3, 1};
        TestCaseUtil.test(4, robHouses(values), 1);
    }

    static void test3() {
        int[] values = {4, 6, 3, 9, 3, 8, 3};
        TestCaseUtil.test(23, robHouses(values), 1);
    }

    static void test4() {
        int[] values = {1, 5, 7, 3, 7, 2, 3};
        TestCaseUtil.test(18, robHouses(values), 1);
    }

}
