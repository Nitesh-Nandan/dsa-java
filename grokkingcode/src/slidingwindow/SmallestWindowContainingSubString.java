package slidingwindow;

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
        return "";
    }

    static boolean isMatch(Map<Character, Integer> patternMap, Map<Character, Integer> charMap) {
       return false;
    }
}
