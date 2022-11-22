package binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindKClosetElements {

    static List<Integer> getKNearest(int[] arr, int tar, int k) {

        if (k >= arr.length) {
            return Arrays.stream(arr).boxed().collect(Collectors.toList());
        }

        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = (low + high) >> 1;
            if (arr[mid] < tar) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        int left = low - 1;
        int right = low + 1;

        List<Integer> ans = new ArrayList<>();

        while (right - left - 1 < k) {
            if (left == -1) {
                right++;
                continue;
            }

            if (right == arr.length || Math.abs(arr[left] - tar) <= Math.abs(arr[right] - tar)) {
                left--;
            } else {
                right++;
            }
        }

        for (int i = left + 1; i < right; i++) {
            ans.add(arr[i]);
        }

        return ans;
    }


    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        int[] arr = {1, 1, 4, 5, 6};
        System.out.println(getKNearest(arr, 1, 3));
    }

    private static void test2() {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(getKNearest(arr, 3, 4));
    }
}
