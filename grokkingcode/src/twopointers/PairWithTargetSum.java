package twopointers;

import java.util.ArrayList;
import java.util.List;

public class PairWithTargetSum {
    public static void main(String[] args) {
        System.out.println(getPairIndex(new int[]{1, 2, 3, 4, 6}, 6)); // [1,3]
        System.out.println(getPairIndex(new int[]{2, 5, 9, 11}, 11)); // [0,2]
    }

    static List<Integer> getPairIndex(int[] arr, int target) {
        int first = 0;
        int last = arr.length - 1;

        List<Integer> ans = new ArrayList<>();

        while (first < last) {
            if (arr[first] + arr[last] == target) {
                ans.add(first);
                ans.add(last);
                return ans;
            } else if (arr[first] + arr[last] > target) {
                last--;
            } else {
                first++;
            }
        }
        return ans;
    }
}
