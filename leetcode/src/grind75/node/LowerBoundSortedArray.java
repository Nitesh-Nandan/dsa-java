package grind75.node;

import util.TestCaseUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LowerBoundSortedArray {

    private static int findLowerBound(List<Integer> lis, int num) {
        int left = 0;
        int right = lis.size();


        while (left < right) {
            int mid = left + (right - left) / 2;
            if (num <= lis.get(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left < lis.size() && lis.get(left) < num) {
            left++;
        }
        return left;

    }

    public static void main(String[] args) {
        test2();
    }

    private static void test1() {
        List<Integer> list = Arrays.asList(4, 6, 7, 8, 19, 21, 23, 29);
        TestCaseUtil.test(0, findLowerBound(list, 3), 1);
        TestCaseUtil.test(0, findLowerBound(list, 4), 2);

        TestCaseUtil.test(7, findLowerBound(list, 29), 3);
        TestCaseUtil.test(1, findLowerBound(list, 5), 4);

        TestCaseUtil.test(4, findLowerBound(list, 18), 5);
        TestCaseUtil.test(5, findLowerBound(list, 20), 6);
    }

    private static void test2() {
        List<Integer> list = Arrays.asList(4, 6, 7, 8, 19, 21, 23, 29);
        Random random = new Random();

        for(int i=0; i<10; i++) {
            int num = random.nextInt(40);
            int indx = Collections.binarySearch(list, num);
            if (indx < 0) {
                indx = Math.abs(indx + 1);
            }
            System.out.println("num: " + num + " ind: " + indx);
        }

    }
}
