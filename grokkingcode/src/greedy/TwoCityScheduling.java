package greedy;

import util.TestCaseUtil;

import java.util.Arrays;

public class TwoCityScheduling {
    public static int twoCityScheduling(int[][] costs) {
        Arrays.sort(costs, (a, b) -> Integer.compare((a[0] - a[1]), (b[0] - b[1])));
        int cost = 0;

        for (int i = 0; i < costs.length; i++) {
            if (i < costs.length / 2) {
                cost += costs[i][0];
            } else {
                cost += costs[i][1];
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    static void test1() {
        int[][] arr = {{10, 20}, {30, 200}, {400, 50}, {30, 20}};
        TestCaseUtil.test(110, twoCityScheduling(arr), 1);
    }

    static void test2() {
        int[][] arr = {{259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}};
        TestCaseUtil.test(1859, twoCityScheduling(arr), 2);
    }

    static void test3() {
        int[][] arr = {{515, 563}, {451, 713}, {537, 709}, {343, 819}, {855, 779}, {457, 60}, {650, 359}, {631, 42}};
        TestCaseUtil.test(3086, twoCityScheduling(arr), 3);
    }

    static void test4() {
        int[][] arr = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        TestCaseUtil.test(18, twoCityScheduling(arr), 4);
    }

    static void test5() {
        int[][] arr = {{1, 2}, {1, 2}, {1, 2}, {1, 2}};
        TestCaseUtil.test(6, twoCityScheduling(arr), 5);
    }

}



