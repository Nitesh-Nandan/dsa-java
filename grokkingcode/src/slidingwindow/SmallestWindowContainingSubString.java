package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string and a pattern,
 * find the smallest substring in the given string which has all the character occurrences of the given pattern.
 * <p>
 * Input: String="aabdec", Pattern="abc"
 * Output: "abdec"
 * Explanation: The smallest substring having all characters of the pattern is "abdec"
 */

public class SmallestWindowContainingSubString {
    public static void main(String[] args) {
        System.out.println(getSmallestSubString("aabdec", "abc")); // "abdec"
        System.out.println(getSmallestSubString("aabdec", "abac")); // "aabdec"
        System.out.println(getSmallestSubString("abdbca", "abc")); // "bca"
        System.out.println(getSmallestSubString("adcad", "abc")); // ""

    }

    static String getSmallestSubString(String str, String pattern) {
        String ans = null;
        int si = 0;

        Map<Character, Integer> patternMap = new HashMap<>();
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            patternMap.put(pattern.charAt(i), patternMap.getOrDefault(pattern.charAt(i), 0) + 1);
        }

        for (int i = 0; i < str.length(); i++) {
            char rightChar = str.charAt(i);
            charMap.put(rightChar, charMap.getOrDefault(rightChar, 0) + 1);

            while (isMatch(patternMap, charMap)) {
                String possibleAns = str.substring(si, i + 1);
                if (ans == null || ans.length() > possibleAns.length()) {
                    ans = possibleAns;
                }
                char leftChar = str.charAt(si++);
                charMap.put(leftChar, charMap.get(leftChar) - 1);
            }
        }
        return ans == null ? "" : ans;
    }

    static boolean isMatch(Map<Character, Integer> patternMap, Map<Character, Integer> charMap) {
        if (patternMap.size() > charMap.size()) return false;
        for (Map.Entry<Character, Integer> patternEntry : patternMap.entrySet()) {
            if (!charMap.containsKey(patternEntry.getKey())
                    || charMap.get(patternEntry.getKey()) < patternEntry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
