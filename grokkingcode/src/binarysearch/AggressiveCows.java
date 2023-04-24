package binarysearch;

import util.TestCaseUtil;

import java.util.Arrays;

public class AggressiveCows {
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int low = 1;
        int high = stalls[stalls.length - 1];
        int dist = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canPlaced(stalls, k, mid)) {
                dist = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return dist;
    }

    private static boolean canPlaced(int[] stalls, int k, int dist) {
        int placed = 1;
        int left = 0;
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - stalls[left] >= dist) {
                left = i;
                placed++;
            }
            if (placed == k) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        int[] stalls = new int[]{1, 2, 3};
        TestCaseUtil.test(2, aggressiveCows(stalls, 2), 1);
    }

    private static void test2() {
        int[] stalls = new int[]{0, 3, 4, 7, 10, 9};
        TestCaseUtil.test(3, aggressiveCows(stalls, 4), 2);
    }

    private static void test3() {
        int[] stalls = new int[]{4, 2, 1, 3, 6};
        TestCaseUtil.test(5, aggressiveCows(stalls, 2), 3);
    }
}
