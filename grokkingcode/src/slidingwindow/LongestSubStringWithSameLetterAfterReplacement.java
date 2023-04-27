package slidingwindow;

// copied https://www.educative.io/courses/grokking-the-coding-interview/R8DVgjq78yR
// LeetCode: https://leetcode.com/problems/longest-repeating-character-replacement/description/

import util.TestCaseUtil;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithSameLetterAfterReplacement {

    public static int characterReplacement(String s, int k) {
        int left = 0;
        int ans = 0;
        int len = s.length();
        Map<Character, Integer> charFreqMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            charFreqMap.put(s.charAt(i), charFreqMap.getOrDefault(s.charAt(i), 0) + 1);
            while ((i - left + 1) - getMaxFreq(charFreqMap) > k) {
                charFreqMap.put(s.charAt(left), charFreqMap.get(s.charAt(left)) - 1);
                left++;

            }
            ans = Math.max(ans, i - left + 1);
        }

        return ans;

    }

    private static int getMaxFreq(Map<Character, Integer> charFreqMap) {
        int ans = 0;
        for (int val : charFreqMap.values()) {
            ans = Math.max(ans, val);
        }
        return ans;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    static void test1() {
        TestCaseUtil.test(4, characterReplacement("ABBB", 2), 1);
    }

    static void test2() {
        TestCaseUtil.test(4, characterReplacement("ABAB", 2), 2);

    }

    static void test3() {
        TestCaseUtil.test(4, characterReplacement("AABABBA", 1), 3);
    }

}
