package dp;

import util.TestCaseUtil;

import java.util.Arrays;
import java.util.List;

public class MinimumCoin {
    public static int coinChange(List<Integer> coins, int total) {
        int[] dp = new int[total + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = total + 1;
        }

        for (Integer coin : coins) {
            for (int c = coin; c <= total; c++) {
                dp[c] = Math.min(dp[c], 1 + dp[c - coin]);
            }
        }
        return dp[total] == total + 1 ? -1 : dp[total];
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    static void test1() {
        List<Integer> coins = Arrays.asList(2, 3, 4, 6, 8);
        TestCaseUtil.test(4, coinChange(coins, 23), 1);
    }

    static void test2() {
        List<Integer> coins = Arrays.asList(1, 2, 5);
        TestCaseUtil.test(3, coinChange(coins, 11), 2);
    }

    static void test3() {
        List<Integer> coins = Arrays.asList(2);
        TestCaseUtil.test(2, coinChange(coins, 4), 3);
    }

    static void test4() {
        List<Integer> coins = Arrays.asList(1, 2, 5);
        TestCaseUtil.test(0, coinChange(coins, 0), 4);
    }
}
