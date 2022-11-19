package slidingwindow;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
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
       return Collections.emptyList();
    }

    static boolean isMatch(Map<Character, Integer> charMap, Map<Character, Integer> patternMap) {
        return false;
    }

    static List<Integer> getAllMatchOptimized(String str, String pattern) {
        return Collections.emptyList();
    }
}
