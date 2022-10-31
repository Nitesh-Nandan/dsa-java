package slidingwindow;

public class SmallestSubArrayWithGreaterOrEqualK {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 2, 3, 2};
        System.out.println(getSmallestSubArrayLen(arr, 7)); // 2
        int[] arr2 = {2, 1, 5, 2, 8};
        System.out.println(getSmallestSubArrayLen(arr2, 7)); // 1
        int[] arr3 = {3, 4, 1, 1, 6};
        System.out.println(getSmallestSubArrayLen(arr3, 8)); // 3
    }

    static int getSmallestSubArrayLen(int[] arr, int k) {
        int si = 0;
        int ksum = 0;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            ksum += arr[i];
            while (ksum >= k) {
                ans = Math.min(ans, (i - si + 1));
                ksum -= arr[si++];
            }
        }
        return ans;
    }
}
