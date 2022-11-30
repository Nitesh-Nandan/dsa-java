package dp;

import util.TestCaseUtil;

import java.util.Arrays;
import java.util.List;

public class KnapSack01 {
    public static int findMaxKnapsackProfit(int capacity, List<Integer> weights, List<Integer> values) {
        int[] profit = new int[capacity + 1];
        for (int i = 0; i < weights.size(); i++) {
            for (int c = capacity; c > 0; c--) {
                if (c >= weights.get(i)) {
                    profit[c] = Math.max(profit[c], values.get(i) + profit[c - weights.get(i)]);
                }
            }
        }
        return profit[capacity];
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    static void test1() {
        List<Integer> weights = Arrays.asList(1, 2, 3, 5);
        List<Integer> values = Arrays.asList(10, 5, 4, 8);
        TestCaseUtil.test(15, findMaxKnapsackProfit(5, weights, values), 1);
    }

    static void test2() {
        List<Integer> weights = Arrays.asList(1, 2, 3, 5);
        List<Integer> values = Arrays.asList(1, 5, 4, 8);
        TestCaseUtil.test(10, findMaxKnapsackProfit(6, weights, values), 2);
    }

    static void test3() {
        List<Integer> weights = Arrays.asList(2);
        List<Integer> values = Arrays.asList(3);
        TestCaseUtil.test(3, findMaxKnapsackProfit(3, weights, values), 3);
    }

    static void test4() {
        List<Integer> weights = Arrays.asList(4);
        List<Integer> values = Arrays.asList(2);
        TestCaseUtil.test(0, findMaxKnapsackProfit(3, weights, values), 4);
    }

    static void test5() {
        List<Integer> weights = Arrays.asList(3, 6, 10, 7, 2);
        List<Integer> values = Arrays.asList(12, 10, 15, 17, 13);
        TestCaseUtil.test(30, findMaxKnapsackProfit(10, weights, values), 5);
    }

    static void test6() {
        List<Integer> weights = Arrays.asList(10, 20, 30);
        List<Integer> values = Arrays.asList(22, 33, 44);
        TestCaseUtil.test(55, findMaxKnapsackProfit(30, weights, values), 6);
    }
}
