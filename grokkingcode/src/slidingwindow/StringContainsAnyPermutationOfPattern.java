package slidingwindow;


import java.util.HashMap;
import java.util.Map;

public class StringContainsAnyPermutationOfPattern {
    public static void main(String[] args) {
        System.out.println(isPermutationPresent("oidbcaf", "abc")); // true
        System.out.println(isPermutationPresent("odicf", "dc")); // false
        System.out.println(isPermutationPresent("bcdxabcdy", "bcdyabcdx")); // true
        System.out.println(isPermutationPresent("aaacb", "abc")); // true
    }

    static boolean isPermutationPresent(String str, String pattern) {
       return false;
    }
}
