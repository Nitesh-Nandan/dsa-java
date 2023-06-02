package bp;

/*
A brave Knight "A" has an array of monsters to face, and will use a combination of might and magic to defeat as many as possible. In this challenge we'd like to know if the knight is successful at defeating them all, and if not, how many monsters are defeated.

A can see the monsters and their order ahead of time.  Despite being evil monsters they will politely queue and challenge A in the current order.  Knowing this, A can plan what to do so that it is optimal.
* The first monster will always be defeated by A's squires while A prepares for battle
* For each other monster there are two possibilities :

1) If the current monster is weaker than the previous one (i.e. enemies[curr] < enemies[curr-1]), The enemy surrenders - what goblin would face someone who has just defeated a dragon?
2) If the current monster is stronger than the previous one (i.e. enemies[curr] > enemies[curr-1]), then A has two options :
2.1) Might!  A fights the monster taking damage (reducing hitpoints by the difference between the current and the previous monster).
2.2) Magic!  A can drink an invulnerability potion, defeating the monster without taking damage.

Write a function that takes as initial parameters

* A list of monsters in order of how A will face them, with their strength as values;
* A’s initial hit points;
* A’s amount of invulnerability potions.

And returns

* The 0-based index of the last monster A defeated

Example1:
Monsters = [10, 9, 15, 2, 20, 5, 15, 17, 1, 30]
hp = 30
potions = 2
Solution: 9

Example2
Monsters = [10, 9, 8, 7, 6, 5]
Hp = 20
Potions = 2
Solution: ? 5

Example3
Monsters = [1, 3, 5, 7, 9]
Hp = 3
Potions = 0
Solution: ? 1

Example 4
enemies = [10, 30, 20, 25, 40, 15, 5, 3, 1]
Hp = 26 -> 6
Potions = 1
Solution: ?

Constraints:

* 0 <= enemies.length <= 10e6
* 1 <= enemies[i] <= 10e4
* 1 <= hp <= 10e5
* 0 <= potions <= 10e4

*/

import util.TestCaseUtil;

public class BraveKnight {

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
                } else if (dp[idx - 1][0][0] < dp[idx - 1][1][0] && dp[idx - 1][1][0] - diff >= 0) {
                    dp[idx][0][0] = dp[idx - 1][1][0] - diff;
                    dp[idx][0][1] = dp[idx - 1][1][1];
                    canMove = true;
                }

                if (dp[idx - 1][0][1] >= dp[idx - 1][1][1] && dp[idx - 1][0][1] > 0) {
                    dp[idx][1][0] = dp[idx - 1][0][0];
                    dp[idx][1][1] = dp[idx - 1][0][1] - 1;
                    canMove = true;
                } else if (dp[idx - 1][0][1] < dp[idx - 1][1][1] && dp[idx - 1][1][1] > 0) {
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
