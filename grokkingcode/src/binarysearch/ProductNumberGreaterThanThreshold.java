package binarysearch;

import util.TestCaseUtil;

import java.util.Arrays;

public class ProductNumberGreaterThanThreshold {

    private int[] getNoOfProductGreaterThanThreshold(int[] candidate, int[] factor, int threshold) {
        Arrays.sort(factor);

        return new int[0];
    }

    // should return index of threshold or just greater than threshold
    private static int getLowerBound(int[] factor, int threshold) {
        int low = 0;
        int high = factor.length - 1;
        int res = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (factor[mid] >= threshold) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        testForLowerBound();
    }

    private static void testForLowerBound() {
        int[] arr = {5, 12, 16, 23, 24, 25, 40, 55, 60};

        TestCaseUtil.test(0, getLowerBound(arr, 4), 1);
        TestCaseUtil.test(0, getLowerBound(arr, 5), 2);
        TestCaseUtil.test(1, getLowerBound(arr, 6), 3);
        TestCaseUtil.test(3, getLowerBound(arr, 23), 4);
        TestCaseUtil.test(4, getLowerBound(arr, 24), 5);
        TestCaseUtil.test(-1, getLowerBound(arr, 70), 6);
    }
}
