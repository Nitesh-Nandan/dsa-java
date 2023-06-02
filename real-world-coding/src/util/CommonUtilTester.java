package util;

import java.util.Arrays;
import java.util.List;

public class CommonUtilTester {
    public static void main(String[] args) {
//        test1();
        test2();
    }

    static void test1() {
        Integer[] arr = {1, 2, 3, 4};
        System.out.println(CommonUtils.fromArrayToList(arr));

    }

    static void test2() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Object[] arr = CommonUtils.listToArray(list);

        for(Object x : arr) {
            System.out.print((Integer) x + " ");
        }
    }
}
