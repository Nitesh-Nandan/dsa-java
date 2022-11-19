package util;

public class TestCaseUtil {

    public static void run(Object expected, Object actual, int number) {
        if (expected.equals(actual)) {
            System.out.println("Test Case: " + number + " Passed.");
        } else {
            System.out.println("Test Case: " + number + " Failed.");
        }
    }
}
