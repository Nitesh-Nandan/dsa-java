package subsets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhone {
    Map<Character, char[]> buttonKeyMap = new HashMap<>();

    public LetterCombinationsOfPhone() {
        buttonKeyMap.put('1', new char[]{});
        buttonKeyMap.put('2', new char[]{'a', 'b', 'c'});
        buttonKeyMap.put('3', new char[]{'d', 'e', 'f'});
        buttonKeyMap.put('4', new char[]{'g', 'h', 'i'});
        buttonKeyMap.put('5', new char[]{'j', 'k', 'l'});
        buttonKeyMap.put('6', new char[]{'m', 'n', 'o'});
        buttonKeyMap.put('7', new char[]{'p', 'q', 'r', 's'});
        buttonKeyMap.put('8', new char[]{'t', 'u', 'v'});
        buttonKeyMap.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    static void test1() {
        LetterCombinationsOfPhone phone = new LetterCombinationsOfPhone();
        System.out.println(phone.letterCombinations("23"));
    }

    static void test2() {
        LetterCombinationsOfPhone phone = new LetterCombinationsOfPhone();
        System.out.println(phone.letterCombinations("73"));
    }

    static void test3() {
        LetterCombinationsOfPhone phone = new LetterCombinationsOfPhone();
        System.out.println(phone.letterCombinations("426"));
    }

    static void test4() {
        LetterCombinationsOfPhone phone = new LetterCombinationsOfPhone();
        System.out.println(phone.letterCombinations("2"));
    }

    static void test5() {
        LetterCombinationsOfPhone phone = new LetterCombinationsOfPhone();
        System.out.println(phone.letterCombinations("2345"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        helper(digits, "", 0, ans);
        return ans;
    }

    private void helper(String digits, String str, int index, List<String> ans) {
        if (index == digits.length()) {
            ans.add(str);
        } else {
            char[] buttons = buttonKeyMap.get(digits.charAt(index));
            for (int i = 0; i < buttons.length; i++) {
                helper(digits, str + buttons[i], index + 1, ans);
            }
        }
    }
}