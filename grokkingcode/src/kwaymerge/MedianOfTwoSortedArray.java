package kwaymerge;

import util.TestCaseUtil;

public class MedianOfTwoSortedArray {
    public static float findMedian(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedian(nums2, nums1);
        }
        int n1 = nums1.length;
        int n2 = nums2.length;
        int low = 0;
        int high = n1;

        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = (n1 + n2 + 1) / 2 - cut1;

            int left1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];

            int right1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1];
            int right2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2];

            if (left1 <= right2 && left2 <= right1) {
                if ((n1 + n2) % 2 == 1) {
                    return Math.max(left1, left2);
                }
                return ((Math.max(left1, left2)) * 0.5f + (Math.min(right1, right2) * 0.5f));
            } else if (left1 > right2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        TestCaseUtil.test(2.5f, findMedian(new int[]{1, 2}, new int[]{3, 4}), 1);
        TestCaseUtil.test(6.0f, findMedian(new int[]{1, 5, 8}, new int[]{4, 7, 9}), 2);
        TestCaseUtil.test(6.5f, findMedian(new int[]{2, 4, 6, 8, 10, 12}, new int[]{1, 3, 5, 7, 9, 11}), 3);
        TestCaseUtil.test(22.0f, findMedian(new int[]{5, 7, 8, 13, 17, 22, 29}, new int[]{30, 32, 39, 41}), 4);
        TestCaseUtil.test(134.0f, findMedian(new int[]{100, 123, 145, 155}, new int[]{4, 76, 222, 635}), 5);
    }
}
