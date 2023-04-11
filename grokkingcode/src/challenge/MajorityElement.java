package challenge;

import util.TestCaseUtil;

public class MajorityElement {
    public static int findMajorityElement(int[] nums) {
        int maj = nums[0];
        int freq = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == maj) {
                freq++;
            } else {
                freq--;
            }
            if (freq < 0) {
                maj = nums[i];
            }
        }
        return maj;
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        int[] arr = {1, 2, 1, 1, 1};
        TestCaseUtil.test(1, findMajorityElement(arr), 1);

    }

    private static void test2() {
        int[] arr = {7, 7, 5, 5, 7, 5, 7, 5, 7, 5, 7, 5, 7, 7, 5, 5, 7, 5, 5};
        TestCaseUtil.test(5, findMajorityElement(arr), 2);
    }
}
