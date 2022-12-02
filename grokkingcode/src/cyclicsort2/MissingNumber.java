package cyclicsort2;

import util.TestCaseUtil;

class MissingNumberSol1 {
    public static int findMissingNumber(int[] arr) {
        int itr = 0;
        while (itr < arr.length) {
            if (arr[itr] < arr.length && arr[itr] != arr[arr[itr]]) {
                swap(arr, itr, arr[itr]);
            } else {
                itr++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i) return i;
        }
        return -1;
    }

    static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}

public class MissingNumber {

    public static void main(String[] args) {
        tests();
    }

    static void tests() {
        TestCaseUtil.test(3, MissingNumberSol1.findMissingNumber(new int[]{0, 1, 2, 4}), 1);
        TestCaseUtil.test(2, MissingNumberSol1.findMissingNumber(new int[]{3, 0, 1, 4}), 2);
        TestCaseUtil.test(3, MissingNumberSol1.findMissingNumber(new int[]{1, 4, 5, 6, 8, 2, 0, 7}), 3);
        TestCaseUtil.test(10, MissingNumberSol1.findMissingNumber(new int[]{1, 0, 2, 3, 4, 5, 6, 8, 9, 7, 11}), 4);
        TestCaseUtil.test(0, MissingNumberSol1.findMissingNumber(new int[]{1}), 5);

    }
}
