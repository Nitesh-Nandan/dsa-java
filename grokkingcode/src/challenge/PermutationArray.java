package challenge;

import java.util.ArrayList;
import java.util.List;

public class PermutationArray {

    public static List<List<Integer>> printUniquePermutations(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        helper(nums, 0, nums.length - 1, permutations);
        return permutations;
    }

    private static void helper(int[] nums, int low, int high, List<List<Integer>> ans) {
        if (low == high) {
            ans.add(getList(nums));
        }

        for (int i = low; i <= high; i++) {
            swap(nums, low, i);
            helper(nums, low + 1, high, ans);
            swap(nums, low, i);
        }

    }

    private static List<Integer> getList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return list;
    }

    private static void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        int[] arr = {1, 4, 5};
        System.out.println(printUniquePermutations(arr));
    }
}
