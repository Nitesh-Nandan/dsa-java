package slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/*
 * Input: String="ppqp", Pattern="pq"
 * Output: [1, 2]
 * Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".
 */

public class FindAllAnagramsOfPatternInString {

    public static void main(String[] args) {
        System.out.println(getAllMatch("ppqp", "pq")); // [1,2]
        System.out.println(getAllMatch("abbcabc", "abc")); //[2,3,4]

        System.out.println(getAllMatchOptimized("ppqp", "pq")); // [1,2]
        System.out.println(getAllMatchOptimized("abbcabc", "abc")); // [2,3,4]
    }

    static List<Integer> getAllMatch(String str, String pattern) {
        List<Integer> ans = new ArrayList<>();

        Map<Character, Integer> patternMap = new HashMap<>();
        Map<Character, Integer> charMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            patternMap.put(pattern.charAt(i), patternMap.getOrDefault(pattern.charAt(i), 0) + 1);
        }

        for (int i = 0; i < str.length(); i++) {
            charMap.put(str.charAt(i), charMap.getOrDefault(str.charAt(i), 0) + 1);
            if (i >= pattern.length() - 1) {
                if (isMatch(charMap, patternMap)) {
                    ans.add(i - (pattern.length() - 1));
                }
                char leftChar = str.charAt(i - (pattern.length() - 1));
                charMap.put(leftChar, charMap.get(leftChar) - 1);
            }
        }

        return ans;
    }

    static boolean isMatch(Map<Character, Integer> charMap, Map<Character, Integer> patternMap) {
        if (charMap.size() != patternMap.size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> entry : patternMap.entrySet()) {
            if (!Objects.equals(entry.getValue(), charMap.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    static List<Integer> getAllMatchOptimized(String str, String pattern) {
        List<Integer> ans = new ArrayList<>();
        Map<Character, Integer> patternMap = new HashMap<>();
        Map<Character, Integer> charMap = new HashMap<>();

        int si = 0, match = 0;
        for (int i = 0; i < pattern.length(); i++) {
            patternMap.put(pattern.charAt(i), patternMap.getOrDefault(pattern.charAt(i), 0) + 1);
        }

        for (int i = 0; i < str.length(); i++) {
            char rightChar = str.charAt(i);
            if (patternMap.containsKey(rightChar)) {
                patternMap.put(rightChar, patternMap.get(rightChar) - 1);
                if (patternMap.get(rightChar) == 0) {
                    match++;
                }
            }
            if (match == patternMap.size()) {
                ans.add(si);
            }

            if (i >= pattern.length() - 1) {
                char leftChar = str.charAt(si++);
                if (patternMap.containsKey(leftChar)) {
                    if (patternMap.get(leftChar) == 0) {
                        match--;
                    }
                    patternMap.put(leftChar, patternMap.get(leftChar) + 1);
                }
            }
        }

        return ans;
    }
}
