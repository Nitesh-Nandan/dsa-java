package slidingwindow;

/**
 * Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s,
 * find the length of the longest contiguous subarray having all 1s.
 * <p>
 * Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
 * Output: 6
 * Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.
 */

public class LongestSubArrayWithOnesAfterReplacement {

    public static void main(String[] args) {
        int[] arr1 = {0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};
        System.out.println(findMaxSubArrayLen(arr1, 2)); // 6

        int[] arr2 = {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
        System.out.println(findMaxSubArrayLen(arr2, 3)); // 9
    }

    static int findMaxSubArrayLen(int[] arr, int k) {
       return -1;
    }
}
