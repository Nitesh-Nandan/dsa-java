package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithSameLetterAfterReplacement {
    public static void main(String[] args) {
//        System.out.println(getMaxLength("aabccbb", 2));
//        System.out.println(getMaxLength("abbcb", 1));
//        System.out.println(getMaxLength("abccde", 1));
        System.out.println(findLength("aaxcdec", 2));
//        System.out.println(getMaxLength("aaxcdec", 2));
    }

    // copied https://www.educative.io/courses/grokking-the-coding-interview/R8DVgjq78yR
     static int findLength(String str, int k) {
        int windowStart = 0, maxLength = 0, maxRepeatLetterCount = 0;
        Map<Character, Integer> letterFrequencyMap = new HashMap<>();
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            letterFrequencyMap.put(rightChar, letterFrequencyMap.getOrDefault(rightChar, 0) + 1);

            // we don't need to place the maxRepeatLetterCount under the below 'if', see the
            // explanation in the 'Solution' section above.
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, letterFrequencyMap.get(rightChar));

            // current window size is from windowStart to windowEnd, overall we have a letter which is
            // repeating 'maxRepeatLetterCount' times, this means we can have a window which has one letter
            // repeating 'maxRepeatLetterCount' times and the remaining letters we should replace.
            // if the remaining letters are more than 'k', it is the time to shrink the window as we
            // are not allowed to replace more than 'k' letters
            if (windowEnd - windowStart + 1 - maxRepeatLetterCount > k) {
                char leftChar = str.charAt(windowStart);
                letterFrequencyMap.put(leftChar, letterFrequencyMap.get(leftChar) - 1);
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    static int getMaxLength(String str, int k) {
        int si = 0, ans = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        for(int i = 0; i<str.length(); i++) {
            charMap.put(str.charAt(i), charMap.getOrDefault(str.charAt(i), 0)+1);
            while (!isPossible(charMap, k)) {
                char leftChar = str.charAt(si);
                charMap.put(leftChar, charMap.get(leftChar)-1);
                if(charMap.get(leftChar) == 0) {
                    charMap.remove(leftChar);
                }
                si++;
            }

            ans = Math.max(ans, getLen(charMap));
        }
        return ans;
    }

    private static int getLen(Map<Character, Integer> charMap) {
        int len = 0;
        for(Map.Entry<Character, Integer> entry: charMap.entrySet()) {
            len += entry.getValue();
        }
        return len;
    }

    static boolean isPossible(Map<Character, Integer> charMap, int k) {
        if(k >= charMap.size()) {
            return true;
        }
        int sum = 0;
        int charWithMax = 0;

        for(Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            charWithMax = Math.max(charWithMax, entry.getValue());
            sum += entry.getValue();
        }
        return k>= (sum - charWithMax);
    }
}
