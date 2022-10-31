package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithMaximumKDistinctCharacter {
    public static void main(String[] args) {
        System.out.println(getMaxLen("araaci", 2)); // 4
        System.out.println(getMaxLen("araaci", 1)); // 2
        System.out.println(getMaxLen("cbbebi", 3)); // 5
        System.out.println(getMaxLen("cbbebi", 10)); // 6
    }

    static int getMaxLen(String str, int k) {
        Map<Character, Integer> charMap = new HashMap<>();
        int si = 0;
        int ans = 0;

        for (int i = 0; i < str.length(); i++) {
            charMap.put(str.charAt(i), charMap.getOrDefault(str.charAt(i), 0) + 1);
            while (charMap.size() > k) {
                char ch = str.charAt(si);
                charMap.put(ch, charMap.get(ch) - 1);
                if (charMap.get(ch) == 0) {
                    charMap.remove(ch);
                }
                si++;
            }
            ans = Math.max(ans, i - si + 1);
        }

        return ans;
    }
}
