package kwaymerge;

public class MergeSortedArray {
    public static int[] mergeSorted(int[] nums1, int m, int[] nums2, int n) {
        int[] ans = new int[m + n];
        int k = 0;
        int p1 = 0;
        int p2 = 0;
        while (p1 < m && p2 < n) {
            if (nums1[p1] <= nums2[p2]) {
                ans[k++] = nums1[p1++];
            } else {
                ans[k++] = nums2[p2++];
            }
        }
        while (p1 < m) {
            ans[k++] = nums1[p1++];
        }
        while (p2 < n) {
            ans[k++] = nums2[p2++];
        }

        return ans;
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    static void test1() {
        printArray(
                MergeSortedArray.mergeSorted(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{4, 5, 6}, 3)
        );
    }

    static void test2() {
        printArray(
                MergeSortedArray.mergeSorted(new int[]{-1, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0}, 5, new int[]{1, 2, 4, 7, 8, 12, 15, 19, 24, 50, 69, 80, 100}, 13)
        );
    }

    static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

}
