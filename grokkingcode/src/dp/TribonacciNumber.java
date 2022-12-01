package dp;

import util.TestCaseUtil;

public class TribonacciNumber {
    public static int findTribonacci(int n) {
        if (n == 0) return 0;
        if (n < 3) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        TestCaseUtil.test(0, findTribonacci(0), 1);
        TestCaseUtil.test(1, findTribonacci(1), 2);
        TestCaseUtil.test(1, findTribonacci(2), 3);
        TestCaseUtil.test(2, findTribonacci(3), 4);
        TestCaseUtil.test(4, findTribonacci(4), 5);
        TestCaseUtil.test(7, findTribonacci(5), 6);
    }
}
