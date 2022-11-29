package backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
    public static List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        restoreIPHelper(s, 0, 0, "", ans);
        return ans;
    }

    static void restoreIPHelper(String str, int index, int dot, String curr, List<String> ans) {
        if (index == str.length() && dot == 4) {
            ans.add(curr.substring(0, curr.length() - 1));
            return;
        }
        if (index >= str.length() || dot > 4) {
            return;
        }

        if (str.charAt(index) == '0') return;

        StringBuilder sb = new StringBuilder();

        for (int i = index; i < Math.min(index + 3, str.length()); i++) {
            sb.append(str.charAt(i));
            if (isValid(sb.toString())) {
                String newCurr = curr + sb + ".";
                restoreIPHelper(str, i + 1, dot + 1, newCurr, ans);
            }
        }
    }

    static boolean isValid(String str) {
        Integer val = Integer.parseInt(str);
        return val >= 0 && val <= 255;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }


    static void test1() {
        String str = "1253412125";
        System.out.println(restoreIpAddresses(str));
    }

    static void test2() {
        String str = "00000000";
        System.out.println(restoreIpAddresses(str));
    }

    static void test3() {
        String str = "255255255255";
        System.out.println(restoreIpAddresses(str));
    }

    static void test4() {
        String str = "010010";
        System.out.println(restoreIpAddresses(str));
    }

    static void test5() {
        String str = "201023";
        System.out.println(restoreIpAddresses(str));
    }

    static void test6() {
        String str = "12121212";
        System.out.println(restoreIpAddresses(str));
    }

}
