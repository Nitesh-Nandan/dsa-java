package greedy;

import util.TestCaseUtil;

public class JumpGame2 {

    static int minimumStep(int[] arr) {
        int[] dp = new int[arr.length];
        for (int i = arr.length - 2; i >= 0; i--) {
            int step = Integer.MAX_VALUE;
            for (int j = i + 1; j <= Math.min(i + arr[i], arr.length - 1); j++) {
                step = Math.min(step, dp[j]);
            }
            dp[i] = step == Integer.MAX_VALUE ? Integer.MAX_VALUE : step + 1;
        }

        return dp[0] == Integer.MAX_VALUE ? -1 : dp[0];
    }

    static int minimumStep2(int[] nums) {
        int end = 0;
        int startIndex = 0;
        int step = 0;
        for (int i = 0; i < nums.length-1; i++) {
            startIndex = Math.max(i + nums[i], startIndex);
            if(end == i) {
                end = startIndex;
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        TestCaseUtil.test(2, minimumStep(new int[]{2, 3, 1, 1, 9}), 1);
        TestCaseUtil.test(2, minimumStep(new int[]{3, 0, 8, 2, 0, 0, 1}), 2);
        TestCaseUtil.test(0, minimumStep(new int[]{0}), 3);
        TestCaseUtil.test(-1, minimumStep(new int[]{3, 2, 1, 0, 4}), 4);
        TestCaseUtil.test(1, minimumStep(new int[]{4, 0, 0, 0, 4}), 5);

        TestCaseUtil.test(2, minimumStep2(new int[]{2, 3, 1, 1, 9}), 1);
        TestCaseUtil.test(2, minimumStep2(new int[]{3, 0, 8, 2, 0, 0, 1}), 2);
        TestCaseUtil.test(0, minimumStep2(new int[]{0}), 3);
//        TestCaseUtil.test(-1, minimumStep2(new int[]{3, 2, 1, 0, 4}), 4);
        TestCaseUtil.test(1, minimumStep2(new int[]{0, 0, 0, 0, 4}), 5);
    }
}
