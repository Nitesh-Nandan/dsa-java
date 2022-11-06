package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProductLessThanATarget {
    public static void main(String[] args) {
        System.out.println(getSubArray(new int[]{2, 5, 3, 10}, 30)); // [2], [5], [2, 5], [3], [5, 3], [10]
        System.out.println(getSubArray(new int[]{8, 2, 6, 5}, 50)); // [8], [2], [8, 2], [6], [2, 6], [5], [6, 5]
    }

    static List<List<Integer>> getSubArray(int[] arr, int tar) {
        List<List<Integer>> ans = new ArrayList<>();
        int left = 0;
        int product = 1;

        for (int i = 0; i < arr.length; i++) {
            product = product * arr[i];
            while (product >= tar && left < i) {
                product /= arr[left++];
            }

            List<Integer> tans = new ArrayList<>();
            for (int j = i; j >= left; j--) {
                tans.add(0, arr[j]);
                ans.add(new ArrayList<>(tans));
            }

//            for (int j = left; j <= i; j++) {
//                tans.add(0, arr[j]);
//                ans.add(new ArrayList<>(tans));
//            }
        }

        return ans;
    }
}
