package cyclicsort2;

import util.TestCaseUtil;

class MissingFirstPositiveNumberSol1 {
    public static int firstMissingPositiveInteger(int[] nums) {
        int itr = 0;
        while (itr < nums.length) {
            if ((nums[itr] > 0 && nums[itr] <= nums.length) && nums[itr] != nums[nums[itr]-1]) {
                swap(nums, itr, nums[itr]-1);
            } else {
                itr++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) return i+1;
        }

        return nums.length + 1;
    }

    static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}

public class MissingFirstPositiveNumber {
    public static void main(String[] args) {
        tests();
    }

    static void tests() {
        TestCaseUtil.test(4, MissingFirstPositiveNumberSol1.firstMissingPositiveInteger(new int[]{1, 2, 3, 5}), 1);
        TestCaseUtil.test(1, MissingFirstPositiveNumberSol1.firstMissingPositiveInteger(new int[]{2, 3, 4, 5, 6}), 2);
        TestCaseUtil.test(1, MissingFirstPositiveNumberSol1.firstMissingPositiveInteger(new int[]{-1, -2, -3, -4}), 3);
        TestCaseUtil.test(2, MissingFirstPositiveNumberSol1.firstMissingPositiveInteger(new int[]{55, 22, 52, 100, 1, 3, -5}), 4);
        TestCaseUtil.test(1, MissingFirstPositiveNumberSol1.firstMissingPositiveInteger(new int[]{0, -1, -2, -3, 5}), 5);
        TestCaseUtil.test(4, MissingFirstPositiveNumberSol1.firstMissingPositiveInteger(new int[]{1, 2, 3, 5}), 6);
    }
}
