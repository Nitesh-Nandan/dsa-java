package cyclicsort2;

import util.TestCaseUtil;

class DuplicateNumberSol {
    public static int findDuplicate(int[] arr) {
        int slow = arr[0];
        int fast = arr[0];

        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        slow = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }

        return slow;
    }
}

public class FindDuplicateNumber {
    public static int findDuplicate(int[] arr) {
        int itr = 0;
        while (itr < arr.length) {
            if (arr[itr] <= arr.length && arr[itr] != arr[arr[itr] - 1]) {
                swap(arr, itr, arr[itr] - 1);
            } else {
                itr++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) return arr[i];
        }

        return -1;
    }

    static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        tests();
    }

    static void tests() {
        TestCaseUtil.test(4, findDuplicate(new int[]{3, 4, 4, 4, 2}), 1);
        TestCaseUtil.test(4, DuplicateNumberSol.findDuplicate(new int[]{3, 4, 4, 4, 2}), 1);
        TestCaseUtil.test(1, findDuplicate(new int[]{1, 1}), 2);
        TestCaseUtil.test(1, DuplicateNumberSol.findDuplicate(new int[]{1, 1}), 2);
        TestCaseUtil.test(2, findDuplicate(new int[]{1, 3, 4, 2, 2}), 3);
        TestCaseUtil.test(2, DuplicateNumberSol.findDuplicate(new int[]{1, 3, 4, 2, 2}), 3);
        TestCaseUtil.test(3, findDuplicate(new int[]{1, 3, 6, 2, 7, 3, 5, 4}), 4);
        TestCaseUtil.test(3, DuplicateNumberSol.findDuplicate(new int[]{1, 3, 6, 2, 7, 3, 5, 4}), 4);
        TestCaseUtil.test(2, findDuplicate(new int[]{1, 2, 2}), 5);
        TestCaseUtil.test(2, DuplicateNumberSol.findDuplicate(new int[]{1, 2, 2}), 5);
    }
}
