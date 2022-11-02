package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithKDistinctChar {

    public static void main(String[] args) {
        System.out.println(getMaxLenWithKDistinct("aabccbb")); // 3
        System.out.println(getMaxLenWithKDistinct("abbbb")); // 2
        System.out.println(getMaxLenWithKDistinct("abccde")); // 3
    }

    static int getMaxLenWithKDistinct(String str) {
        return -1;
    }
}
