package binarysearch;

import util.TestCaseUtil;

public class MinCallForFirstBadVersion {


    static int minCall(int num, int badVersion) {
        int low = 1;
        int high = num;
        int call = 0;

        while (low < high) {
            int mid = (low + high) / 2;
            if (isBadVersion(badVersion, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
            call++;
        }

        return call;
    }

    static boolean isBadVersion(int var, int cur) {
        return cur >= var;
    }


    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    static void test1() {
        TestCaseUtil.test(5, minCall(38, 28), 1);
    }

    static void test2() {
        TestCaseUtil.test(3, minCall(13, 10), 2);
    }

    static void test3() {
        TestCaseUtil.test(5, minCall(29, 10), 3);
    }
}
