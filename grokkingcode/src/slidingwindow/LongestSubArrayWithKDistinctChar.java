package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithKDistinctChar {

    public static void main(String[] args) {
        System.out.println(getMaxLenWithKDistinct("aabccbb"));
        System.out.println(getMaxLenWithKDistinct("abbbb"));
        System.out.println(getMaxLenWithKDistinct("abccde"));
    }

    static int getMaxLenWithKDistinct(String str) {
        int si = 0, maxSoFar = 0;
        Map<Character, Integer> charMap = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            while (charMap.containsKey(str.charAt(i))) {
                charMap.remove(str.charAt(si));
                si++;
            }
            charMap.put(str.charAt(i), 1);
            maxSoFar = Math.max(maxSoFar, i - si + 1);
        }
        return maxSoFar;
    }
}
