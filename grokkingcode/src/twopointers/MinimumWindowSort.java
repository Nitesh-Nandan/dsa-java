package twopointers;

public class MinimumWindowSort {

    public static void main(String[] args) {
        System.out.println(minimumLengthSort(new int[]{1, 2, 5, 3, 7, 10, 9, 12})); // 5
        System.out.println(minimumLengthSort(new int[]{1, 3, 2, 0, -1, 7, 10})); // 5
        System.out.println(minimumLengthSort(new int[]{1, 2, 3})); // 0
        System.out.println(minimumLengthSort(new int[]{3, 2, 1})); // 3
    }

    static int minimumLengthSort(int[] arr) {
        int left = 0;
        int right = arr.length-1;

        while (left < arr.length-1 && arr[left] <= arr[left+1]) {
            left++;
        }
        if(left == arr.length-1) return 0;

        while (right > 0 && arr[right] >= arr[right-1]) {
            right--;
        }

        int subarrayMax = Integer.MIN_VALUE, subarrayMin = Integer.MAX_VALUE;
        for (int k = left; k <= right; k++) {
            subarrayMax = Math.max(subarrayMax, arr[k]);
            subarrayMin = Math.min(subarrayMin, arr[k]);
        }
        while (left > 0 && arr[left - 1] > subarrayMin) {
            left--;
        }
        while (right < arr.length - 1 && arr[right + 1] < subarrayMax) {
            right++;
        }
        return right-left+1;
    }
}
