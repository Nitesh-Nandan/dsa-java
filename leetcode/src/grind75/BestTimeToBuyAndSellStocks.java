package grind75;

import util.TestCaseUtil;

public class BestTimeToBuyAndSellStocks {
    public static int maxProfit(int[] prices) {
        int[] leftMin = new int[prices.length];
        int[] rightMax = new int[prices.length];

        leftMin[0] = prices[0];
        rightMax[prices.length - 1] = prices[prices.length - 1];

        for (int i = 1; i < prices.length; i++) {
            leftMin[i] = Math.min(prices[i], leftMin[i - 1]);
        }
        for (int i = prices.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], prices[i]);
        }

        int ans = -1;

        for (int i = 0; i < prices.length; i++) {
            ans = Math.max(ans, rightMax[i] - leftMin[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        int[] stocks = new int[]{7, 1, 5, 3, 6, 4};
        TestCaseUtil.test(5, maxProfit(stocks), 1);
    }

    private static void test2() {
        int[] stocks = new int[]{7, 6, 4, 3, 1};
        TestCaseUtil.test(0, maxProfit(stocks), 2);
    }
}
