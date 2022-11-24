package greedy;

import util.TestCaseUtil;

public class JumpGame {
    public static boolean jumpGame(int[] nums) {
        return helper(nums, 0);
    }

    static boolean helper(int[] arr, int cur) {
        if (cur >= arr.length) {
            return false;
        }
        if (cur == arr.length - 1) {
            return true;
        }

        int steps = arr[cur];
        boolean ans = false;

        for (int i = 1; i <= steps; i++) {
            ans = ans | helper(arr, cur + i);
        }

        return ans;
    }

    private static boolean canJump(int[] arr) {
        int start = 0;
        for(int i=0; i<arr.length; i++) {
            start = Math.max(start, i + arr[i]);
            if(start >= arr.length-1) return true;
            if(start < i+1) return false;
        }
        return false;
    }

    public static void main(String[] args) {
        TestCaseUtil.test(true, jumpGame(new int[]{2, 3, 1, 1, 9}), 1);
        TestCaseUtil.test(false, jumpGame(new int[]{3, 2, 1, 0, 4}), 2);
        TestCaseUtil.test(true, jumpGame(new int[]{4, 0, 0, 0, 4}), 3);
        TestCaseUtil.test(true, jumpGame(new int[]{0}), 4);
        TestCaseUtil.test(true, jumpGame(new int[]{1}), 5);

        TestCaseUtil.test(true, canJump(new int[]{3,0,8,2,0,0,1}), 6);
        TestCaseUtil.test(true, canJump(new int[]{0}), 7);
        TestCaseUtil.test(false, canJump(new int[]{3, 2, 1, 0, 4}), 8);
        TestCaseUtil.test(true, canJump(new int[]{4, 0, 0, 0, 4}), 9);
    }
}
