package hashmap;

import util.TestCaseUtil;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {
    public static boolean isIsomorphic(String string1, String string2) {
        Map<Character, Character> mapping1 = new HashMap<>();
        Map<Character, Character> mapping2 = new HashMap<>();
        if (string1.length() != string2.length()) return false;
        int len = string1.length();
        for (int i = 0; i < len; i++) {
            char ch1 = string1.charAt(i);
            char ch2 = string2.charAt(i);
            if (mapping1.containsKey(ch1) && mapping1.get(ch1) != ch2) {
                return false;
            }
            if (mapping2.containsKey(ch2) && mapping2.get(ch2) != ch1) {
                return false;
            }
            mapping1.put(ch1, ch2);
            mapping2.put(ch2, ch1);
        }
        return true;
    }

    public static void main(String[] args) {
        TestCaseUtil.test(true, isIsomorphic("egg", "all"), 1);
        TestCaseUtil.test(false, isIsomorphic("foo", "bar"), 2);
        TestCaseUtil.test(true, isIsomorphic("paper", "title"), 3);
        TestCaseUtil.test(false, isIsomorphic("badc", "baba"), 4);
    }
}
