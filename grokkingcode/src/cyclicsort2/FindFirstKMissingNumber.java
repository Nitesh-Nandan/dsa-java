package cyclicsort2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindFirstKMissingNumber {
    public static List<Integer> firstKMissingNumbers(int[] arr, int k) {
        int itr = 0;
        while (itr < arr.length) {
            if ((arr[itr] > 0 && arr[itr] <= arr.length) && arr[itr] != arr[arr[itr] - 1]) {
                swap(arr, itr, arr[itr] - 1);
            } else {
                itr++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        Map<Integer, Boolean> valueExists = new HashMap<>();
        for (int i = 0; i < arr.length && ans.size() < k; i++) {
            if (arr[i] != i + 1) {
                ans.add(i + 1);
                valueExists.put(arr[i], true);
            }
        }
        int pointer = arr.length + 1;
        while (ans.size() != k) {
            if (!valueExists.containsKey(pointer)) {
                ans.add(pointer);
            }
            pointer++;
        }

        return ans;
    }

    static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    static void test1() {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(firstKMissingNumbers(arr, 6));
    }

    static void test2() {
        int[] arr = {1, -1, 2};
        System.out.println(firstKMissingNumbers(arr, 2));
    }

    static void test3() {
        int[] arr = {-4, 6};
        System.out.println(firstKMissingNumbers(arr, 4));
    }
}
