package slidingwindow;


import java.util.HashMap;
import java.util.Map;

public class StringContainsAnyPermutationOfPattern {
    public static void main(String[] args) {
        System.out.println(isPermutationPresent("oidbcaf", "abc"));
        System.out.println(isPermutationPresent("odicf", "dc"));
        System.out.println(isPermutationPresent("bcdxabcdy", "bcdyabcdx"));
        System.out.println(isPermutationPresent("aaacb", "abc"));
    }

    static boolean isPermutationPresent(String str, String pattern) {
        Map<Character, Integer> patternMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            patternMap.put(pattern.charAt(i), patternMap.getOrDefault(pattern.charAt(i), 0) + 1);
        }
        int matched = 0;
        int si = 0;
        for (int i = 0; i < str.length(); i++) {
            Character rightChar = str.charAt(i);
            if (patternMap.containsKey(rightChar)) {
                patternMap.put(rightChar, patternMap.get(rightChar) - 1);
                if (patternMap.get(rightChar) == 0) {
                    matched++;
                }
            }
            if (matched == patternMap.size()) {
                return true;
            }
            if (i >= pattern.length() - 1) {
                char leftChar = str.charAt(si++);
                if (patternMap.containsKey(leftChar)) {
                    if (patternMap.get(leftChar) == 0) {
                        matched--;
                    }
                    patternMap.put(leftChar, patternMap.get(leftChar) + 1);
                }
            }
        }
        return false;
    }
}
