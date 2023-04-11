package challenge;

import util.TestCaseUtil;

import java.util.Arrays;

public class LIS {
    public static int longestSubsequence(int[] nums) {
        int[] ans = new int[nums.length];
        int len = 1;
        Arrays.fill(ans, 1);

        for (int i = 1; i < nums.length; i++) {
            int tmp = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    tmp = Math.max(tmp, ans[i] + ans[j]);
                }
            }
            ans[i] = tmp;
            len = Math.max(len, ans[i]);
        }
        return len;
    }

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        TestCaseUtil.test(4, longestSubsequence(arr), 1);
    }
}
