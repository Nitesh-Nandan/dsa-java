package hashmap;

import util.TestCaseUtil;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public static int longestPalindrome(String palString) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : palString.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        int oddMaxLen = 0;
        int maxLen = 0;

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                maxLen += entry.getValue();
            } else {
                maxLen += entry.getValue() - 1;
                oddMaxLen = 1;
            }
        }

        return maxLen + oddMaxLen;
    }

    public static void main(String[] args) {
        TestCaseUtil.test(11, longestPalindrome("dfssdnojfnaosbdf"), 1);
        TestCaseUtil.test(9, longestPalindrome("GOODMORNINGTOYOU"), 2);
        TestCaseUtil.test(9, longestPalindrome("asfewgfweoifhsdb"), 3);
        TestCaseUtil.test(11, longestPalindrome("thisREALLYisaGOODbook"), 4);
    }
}
