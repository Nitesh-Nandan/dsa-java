package dp;

import util.TestCaseUtil;

public class ClimbingStairs {
    public static int climbStairs(int n) {
        if (n < 3) return n;
        int[] steps = new int[n + 1];
        steps[1] = 1;
        steps[2] = 2;

        for (int i = 3; i <= n; i++) {
            steps[i] = steps[i - 1] + steps[i - 2];
        }
        return steps[n];
    }

    public static void main(String[] args) {
        TestCaseUtil.test(8, climbStairs(5), 1);
        TestCaseUtil.test(89, climbStairs(10), 2);
        TestCaseUtil.test(1346269, climbStairs(30), 3);
        TestCaseUtil.test(433494437, climbStairs(42), 4);
        TestCaseUtil.test(55, climbStairs(9), 4);
    }
}
