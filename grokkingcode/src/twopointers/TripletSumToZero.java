package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
 * Input: [-3, 0, 1, 2, -1, 1, -2]
 * Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
 * Explanation: There are four unique triplets whose sum is equal to zero.
 */
public class TripletSumToZero {

    public static void main(String[] args) {
        System.out.println(searchTriplets(new int[]{-3, 0, 1, 2, -1, 1, -2}));
    }

    static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 3; i++) {
            if (arr[i] != arr[i + 1]) {
                triplets.addAll(getListOfPairs(arr, i, -arr[i]));
            }
        }

        return triplets;
    }


    static List<List<Integer>> getListOfPairs(int[] arr, int si, int tar) {
        int left = si + 1;
        int right = arr.length - 1;

        List<List<Integer>> ans = new ArrayList<>();

        while (left < right) {
            if (arr[left] + arr[right] == tar) {
                ans.add(Arrays.asList(arr[si], arr[left], arr[right]));
                left++;
                right--;
                while (left < right && arr[left] == arr[left - 1]) left++; // 0, 1,1,1, 2
                while (left < right && arr[right] == arr[right + 1]) right--;
            } else if (arr[left] + arr[right] < tar) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }

}
