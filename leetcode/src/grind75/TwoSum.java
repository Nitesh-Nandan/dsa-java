package grind75;

import util.TestCaseUtil;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int tar = target - nums[i];
            if (numIndexMap.containsKey(tar)) {
                return new int[]{numIndexMap.get(tar), i};
            }
            numIndexMap.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        TestCaseUtil.compareArrayIgnoreOrder(new int[]{0, 1}, twoSum(new int[]{2, 7, 11, 15}, 9), 1);
    }
}
