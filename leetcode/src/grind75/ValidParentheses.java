package grind75;

import util.TestCaseUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (char ch : str.toCharArray()) {
            if(map.containsKey(ch)) {
                char top = stack.isEmpty() ? '*' : stack.pop();
                if(top != map.get(ch)) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        TestCaseUtil.test(true, isValid("()"), 1);
    }

    private static void test2() {
        TestCaseUtil.test(true, isValid("()[]{}"), 2);

    }

    private static void test3() {
        TestCaseUtil.test(true, isValid("()"), 3);
    }
}
