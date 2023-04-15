package grind75;

import util.CommonUtils;
import util.TestCaseUtil;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];

        int len = heights.length;

        for (int i = 0; i < len; i++) {
            int high = heights[i];
            while (!stack.isEmpty() && high <= heights[stack.peek()]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            stack.push(i);
        }

//        CommonUtils.printArr(left, "LeftArray");
        stack.clear();

        for (int i = len - 1; i >= 0; i--) {
            int high = heights[i];
            while (!stack.isEmpty() && high <= heights[stack.peek()]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? len - 1 : stack.peek() - 1;
            stack.push(i);
        }

//        CommonUtils.printArr(right, "RightArray");

        int ans = 0;

        for (int i = 0; i < len; i++) {
            ans = Math.max(ans, (right[i] - left[i] + 1) * heights[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        test1();
        tes2();
    }

    static void test1() {
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        TestCaseUtil.test(10, largestRectangleArea(heights), 2);
    }

    static void tes2() {
        int[] heights = new int[]{2, 4};
        TestCaseUtil.test(4, largestRectangleArea(heights), 2);
    }
}
