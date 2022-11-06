package twopointers;

import java.util.Arrays;

public class TripletSmallerSum {
    public static void main(String[] args) {
        System.out.println(getTripletCount(new int[]{-1, 0, 2, 3}, 3)); // 2
        System.out.println(getTripletCount(new int[]{-1, 4, 2, 1, 3}, 5)); // 4
    }

    static int getTripletCount(int[] arr, int tar) {
        int count = 0;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {
                int tsum = arr[i] + arr[left] + arr[right];
                if (tsum < tar) {
                    count += (right - left);
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }
}
