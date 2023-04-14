package util;

import java.util.Arrays;

public class TestCaseUtil {

    public static void test(Object expected, Object actual, int number) {
        if (expected.equals(actual)) {
            System.out.println("Test Case: " + number + " Passed.");
        } else {
            System.out.println("Test Case: " + number + " Failed. Expected: " + expected + " Actual: " + actual);
        }
    }

    public static void compareArray(int[] arr1, int[] arr2, int number) {
        String res1 = getArrayAsString(arr1);
        String res2 = getArrayAsString(arr2);

        if (res1.equals(res2)) {
            System.out.println("Test Case: " + number + " Passed.");
        } else {
            System.out.println("Test Case: " + number + " Failed. Expected: " + res1 + " Actual: " + res2);
        }
    }

    public static void compareArrayIgnoreOrder(int[] arr1, int[] arr2, int number) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        String res1 = getArrayAsString(arr1);
        String res2 = getArrayAsString(arr2);

        if (res1.equals(res2)) {
            System.out.println("Test Case: " + number + " Passed.");
        } else {
            System.out.println("Test Case: " + number + " Failed. Expected: " + res1 + " Actual: " + res2);
        }
    }

    private static String getArrayAsString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int num : arr) {
            sb.append(num + ", ");
        }
        sb.append("]");
        if (sb.length() > 3) {
            sb.deleteCharAt(sb.length() - 3);
            sb.deleteCharAt(sb.length() - 2);
        }
        return sb.toString();
    }
}
