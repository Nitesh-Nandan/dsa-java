package adhoc;

import util.TestCaseUtil;

public class SubArrayWithMaxContinousCharacter {
    private static int getMaxContinuousChar(String str) {
        char[] arr = str.toCharArray();

        int len = str.length();
        int ans = 1;

        int left = 0;
        int right = 0;

        while (right < len) {
            while (right < len && arr[left] == arr[right]) {
                right++;
            }
            ans = Math.max(ans, right-left);
            left = right;
        }

        return ans;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    private static void test1() {
        String str = "s";
        System.out.println(getMaxContinuousChar(str));
    }

    private static void test2() {
        String str = "sx";
        System.out.println(getMaxContinuousChar(str));
    }

    private static void test3() {
        String str = "sabaaabxa";
        System.out.println(getMaxContinuousChar(str));
    }

    private static void test4() {
        String str = "abababbab";
        System.out.println(getMaxContinuousChar(str));
    }
    private static void test5() {
        String str = "sabacdefaa";
        System.out.println(getMaxContinuousChar(str));
    }

    private static void test6() {
        String str = "aaaaaaaabacdefaa";
        System.out.println(getMaxContinuousChar(str));
    }
}
