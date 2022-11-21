package binarysearch;

import util.TestCaseUtil;

import java.util.Arrays;
import java.util.List;

public class SearchInRotatedArray {

    public static int binarySearchRotated(List<Integer> nums, int target) {
        return searchInRotatedArray(nums.stream().mapToInt(Integer::intValue).toArray(), 0, nums.size() - 1, target);
    }

    static int searchInRotatedArray(int[] arr, int start, int end, int num) {
        if (start == end) {
            if (arr[start] == num) return start;
            else return -1;
        }

        int mid = (start + end) / 2;
        if (arr[mid] == num) return mid;
        if (arr[start] <= arr[mid]) {
            if (arr[mid] > num && num >= arr[start]) {
                return searchInRotatedArray(arr, start, mid - 1, num);
            } else {
                return searchInRotatedArray(arr, mid + 1, end, num);
            }
        } else if (num >= arr[mid] && num <= arr[end]) {
            return searchInRotatedArray(arr, mid + 1, end, num);
        } else {
            return searchInRotatedArray(arr, start, mid - 1, num);
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    static void test1() {
        TestCaseUtil.test(4, binarySearchRotated(Arrays.asList(6, 7, 1, 2, 3, 4, 5), 3), 1);
    }

    static void test2() {
        TestCaseUtil.test(0, binarySearchRotated(Arrays.asList(6, 7, 1, 2, 3, 4, 5), 6), 2);
    }

    static void test3() {
        TestCaseUtil.test(5, binarySearchRotated(Arrays.asList(4, 5, 6, 1, 2, 3), 3), 3);
    }

    static void test4() {
        TestCaseUtil.test(2, binarySearchRotated(Arrays.asList(4, 5, 6, 1, 2, 3), 6), 4);
    }
}
