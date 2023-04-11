package challenge;

import util.TestCaseUtil;

public class ProductArray {

    public static int[] product(int[] arr) {
        int[] ans = new int[arr.length];
        int mul = 1;
        for (int i = 0; i < arr.length; i++) {
            ans[i] = mul;
            mul = mul * arr[i];
        }

        mul = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            ans[i] *= mul;
            mul = mul * arr[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        TestCaseUtil.compareArray(new int[]{-48, 0, 0, 0, 0, 0}, product(new int[]{0, -1, 2, -3, 4, -2}), 1);
    }

    private static void test2() {
        TestCaseUtil.compareArray(new int[]{-72, -120, 360, -60, -90}, product(new int[]{5, 3, -1, 6, 4}), 2);
    }
}