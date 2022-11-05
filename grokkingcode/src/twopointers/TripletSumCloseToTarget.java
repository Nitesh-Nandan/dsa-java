package twopointers;

import java.util.Arrays;

public class TripletSumCloseToTarget {
    public static void main(String[] args) {

        System.out.println(getClosetSum(new int[]{-2, 0, 1, 2}, 2)); // 1
        System.out.println(getClosetSum(new int[]{-3, -1, 1, 2}, 1)); // 0
        System.out.println(getClosetSum(new int[]{1, 0, 1, 1}, 100)); // 3
    }

    static int getClosetSum(int[] arr, int tar) {
        Arrays.sort(arr);
        int ans = arr[0] + arr[1] + arr[2];

        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {
                int tmp = arr[i] + arr[left] + arr[right];
                if (tmp > tar) {
                    right--;
                } else {
                    left++;
                }
                if (Math.abs(ans - tar) > Math.abs(tmp - tar)) {
                    ans = tmp;
                }
            }
        }
        return ans;
    }
}
