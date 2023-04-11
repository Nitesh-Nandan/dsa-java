package challenge;

import util.TestCaseUtil;

import java.util.Stack;

public class ContainerWithMostWater {
    public static int containerWithMostWater(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            ans = Math.max(ans, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        test1();
    }

    static void test1() {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        TestCaseUtil.test(49, containerWithMostWater(heights), 1);
    }
}
