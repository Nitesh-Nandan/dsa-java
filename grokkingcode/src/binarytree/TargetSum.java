package binarytree;

import util.TestCaseUtil;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {
    static Map<String, Integer> dp = new HashMap<>();

    public static int findTargetSumWays(int[] nums, int target) {
        return helper(nums, 0, 0, target);

    }

    private static int helper(int[] nums, int i, int curr, int tar) {
        if (i == nums.length) {
            return curr == tar ? 1 : 0;
        }
        String key = getKey(i, curr);
        if (dp.getOrDefault(key, -1) != -1) {
            return dp.get(key);
        }

        int val = helper(nums, i + 1, curr - nums[i], tar) + helper(nums, i + 1, curr + nums[i], tar);
        dp.put(key, val);
        return dp.get(key);
    }

    private static String getKey(int idx, int val) {
        return String.format("index=%s::val=%s", idx, val);
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        dp.clear();
        int[] arr = new int[]{1, 1, 1, 1, 1};
        TestCaseUtil.test(5, findTargetSumWays(arr, 3), 1);
    }

    private static void test2() {
        dp.clear();
        int[] arr = new int[]{1};
        TestCaseUtil.test(1, findTargetSumWays(arr, 1), 2);
    }

}
