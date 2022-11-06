package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

        return triplets;
    }


    static List<List<Integer>> getListOfPairs(int[] arr, int si, int tar) {
        return Collections.emptyList();
    }

}
