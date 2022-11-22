package binarysearch;

import util.TestCaseUtil;

public class SingleElementInSortedArray {

    public static int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length;

        while (low < high) {
            int mid = (low + high) >> 1;
            if ((mid & 1) == 1) mid--;

            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            } else {
                high = mid;
            }
        }

        return nums[low];
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    static void test1() {
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 4, 5, 8, 8};
        TestCaseUtil.test(5, singleNonDuplicate(arr), 1);
    }

    static void test2() {
        int[] arr = {1, 1, 2, 2, 3, 4, 4, 5, 5};
        TestCaseUtil.test(3, singleNonDuplicate(arr), 2);
    }

    static void test3() {
        int[] arr = {1, 1, 2, 3, 3};
        TestCaseUtil.test(2, singleNonDuplicate(arr), 3);
    }

    static void test4() {
        int[] arr = {0, 2, 2, 3, 3, 4, 4, 5, 5};
        TestCaseUtil.test(0, singleNonDuplicate(arr), 4);
    }
}
