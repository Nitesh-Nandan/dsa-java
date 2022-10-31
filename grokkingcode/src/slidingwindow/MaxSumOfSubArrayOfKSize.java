package slidingwindow;

public class MaxSumOfSubArrayOfKSize {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        System.out.println(maxSumOfK(arr, 3));
    }

    static int maxSumOfK(int[] arr, int k) {

        int maxSoFar = 0;
        int ksum = 0;
        for (int i = 0; i < k; i++) {
            ksum += arr[i];
        }
        maxSoFar = ksum;
        for (int i = k; i < arr.length; i++) {
            ksum -= (arr[i - k]);
            ksum += arr[i];

            maxSoFar = Math.max(ksum, maxSoFar);
        }
        return maxSoFar;
    }
}
