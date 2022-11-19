package twopointers;

import java.util.ArrayList;
import java.util.List;

public class ProductLessThanATarget {
    public static void main(String[] args) {
        System.out.println(getSubArray(new int[]{2, 5, 3, 10}, 30)); // [2], [5], [2, 5], [3], [5, 3], [10]
        System.out.println(getSubArray(new int[]{8, 2, 6, 5}, 50)); // [8], [2], [8, 2], [6], [2, 6], [5], [6, 5]
    }

    static List<List<Integer>> getSubArray(int[] arr, int tar) {
        List<List<Integer>> ans = new ArrayList<>();
        return ans;
    }
}
