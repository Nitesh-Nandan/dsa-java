package twoheaps;

import util.TestCaseUtil;


public class MaximizeCapital {
    // O(N^2)
    public static int maximumCapital(int cap, int k, int[] capitals, int[] profits) {
        int ans = cap;

        while (k > 0) {
            int maxProfit = 0;
            int index = -1;
            for (int i = 0; i < capitals.length; i++) {
                if (ans >= capitals[i] && maxProfit < profits[i]) {
                    maxProfit = profits[i];
                    index = i;
                }
            }
            ans += maxProfit;
            if (index != -1) {
                capitals[index] = Integer.MAX_VALUE;
            }
            k--;
        }

        return ans;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    private static void test1() {
        int capital = 1;
        int totalInvest = 2;
        int[] capitals = new int[]{1, 2, 2, 3};
        int[] profits = new int[]{2, 4, 6, 8};
        TestCaseUtil.run(11, maximumCapital(capital, totalInvest, capitals, profits), 1);
    }

    private static void test2() {
        int capital = 2;
        int totalInvest = 2;
        int[] capitals = new int[]{1, 2, 3, 4};
        int[] profits = new int[]{1, 3, 5, 7};
        TestCaseUtil.run(12, maximumCapital(capital, totalInvest, capitals, profits), 2);

    }

    private static void test3() {
        int capital = 2;
        int totalInvest = 3;
        int[] capitals = new int[]{1, 3, 4, 5, 6};
        int[] profits = new int[]{1, 2, 3, 4, 5};
        TestCaseUtil.run(9, maximumCapital(capital, totalInvest, capitals, profits), 3);
    }

    private static void test4() {
        int capital = 1;
        int totalInvest = 3;
        int[] capitals = new int[]{0, 1, 2};
        int[] profits = new int[]{1, 2, 3};
        TestCaseUtil.run(7, maximumCapital(capital, totalInvest, capitals, profits), 4);
    }

    private static void test5() {
        int capital = 1;
        int totalInvest = 3;
        int[] capitals = new int[]{1, 2, 3, 11, 19, 21};
        int[] profits = new int[]{2, 7, 9, 16, 17, 18};
        TestCaseUtil.run(28, maximumCapital(capital, totalInvest, capitals, profits), 5);
    }
}
