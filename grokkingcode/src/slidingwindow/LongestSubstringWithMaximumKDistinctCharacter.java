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
        return -1;
    }
}
