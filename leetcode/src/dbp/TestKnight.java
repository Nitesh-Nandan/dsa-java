package dbp;

import util.TestCaseUtil;

public class TestKnight {

    private static int maximumEnemyKill(int[] monsters, int might, int magic) {

        int[][][] dp = new int[monsters.length][2][2];
        dp[0][0] = new int[]{might, magic}; // hit
        dp[0][1] = new int[]{might, magic}; // potion
        int idx = 1;

        while (idx < monsters.length) {
            if (monsters[idx] <= monsters[idx - 1]) {
                dp[idx][0] = dp[idx - 1][0];
                dp[idx][1] = dp[idx - 1][1];
                idx++;
            } else {
                boolean canMove = false;
                int diff = monsters[idx] - monsters[idx - 1];
                if (dp[idx - 1][0][0] >= dp[idx - 1][1][0] && dp[idx - 1][0][0] - diff >= 0) {
                    dp[idx][0][0] = dp[idx - 1][0][0] - diff;
                    dp[idx][0][1] = dp[idx - 1][0][1];
                    canMove = true;
                } else if (dp[idx - 1][0][0] <= dp[idx - 1][1][0] && dp[idx - 1][1][0] - diff >= 0) {
                    dp[idx][0][0] = dp[idx - 1][1][0] - diff;
                    dp[idx][0][1] = dp[idx - 1][1][1];
                    canMove = true;
                }

                if (dp[idx - 1][0][1] >= dp[idx - 1][1][1] && dp[idx - 1][0][1] > 0) {
                    dp[idx][1][0] = dp[idx - 1][0][0];
                    dp[idx][1][1] = dp[idx - 1][0][1] - 1;
                    canMove = true;
                } else if (dp[idx - 1][0][1] <= dp[idx - 1][1][1] && dp[idx - 1][1][1] > 0) {
                    dp[idx][1][0] = dp[idx - 1][1][0];
                    dp[idx][1][1] = dp[idx - 1][1][1] - 1;
                    canMove = true;
                }
                if (!canMove) {
                    break;
                }
                idx++;
            }
        }

        return idx - 1;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    private static void test1() {
        int[] monsters = new int[]{4, 3, 2, 1};
        int hp = 5;
        int potions = 2;
        TestCaseUtil.test(3, maximumEnemyKill(monsters, hp, potions), 1);
    }


    private static void test2() {
        int[] monsters = new int[]{10, 9, 15, 2, 20, 5, 15, 17, 1, 30};
        int hp = 30; // 24
        int potions = 2;
        TestCaseUtil.test(9, maximumEnemyKill(monsters, hp, potions), 2);
    }

    private static void test3() {
        int[] monsters = new int[]{10, 9, 8, 7, 6, 5};
        int hp = 20;
        int potions = 2;
        TestCaseUtil.test(5, maximumEnemyKill(monsters, hp, potions), 3);

    }

    private static void test4() {

        int[] monsters = new int[]{1, 3, 5, 7, 9};
        int hp = 3;
        int potions = 0;
        TestCaseUtil.test(1, maximumEnemyKill(monsters, hp, potions), 4);
    }

    private static void test5() {
        int[] monsters = new int[]{10, 30, 20, 25, 40, 15, 5, 3, 1};
        int hp = 26;
        int potions = 1;
        TestCaseUtil.test(8, maximumEnemyKill(monsters, hp, potions), 5);
    }

    private static void test6() {
        int[] monsters = new int[]{10, 30, 40, 42, 50};
        int hp = 20;
        int potions = 1;
        TestCaseUtil.test(4, maximumEnemyKill(monsters, hp, potions), 6);
    }

}
