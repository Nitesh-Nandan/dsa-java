package challenge;

import util.TestCaseUtil;

public class LongestPalindromicSubString {
    public static String longestSubPalindrome(String str) {
        String ans = "";
        boolean[][] dp = new boolean[str.length()][str.length()];

        for (int gap = 0; gap < str.length(); gap++) {
            for (int i = 0, j = gap; j < str.length(); i++, j++) {
                if (gap == 0) {
                    dp[i][j] = true;
                } else if (gap == 1) {
                    dp[i][j] = str.charAt(i) == str.charAt(j);
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && str.charAt(i) == str.charAt(j);
                }
                if (dp[i][j]) {
                    ans = str.substring(i, j + 1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        TestCaseUtil.test("aba", longestSubPalindrome("babad"), 1);
    }
    public static void test2() {
        TestCaseUtil.test("abbccddccbba", longestSubPalindrome("aabbccddccbbae"), 2);
    }
    public static void test3() {
        TestCaseUtil.test("madam", longestSubPalindrome("madam"), 3);
    }
}
