package stack;

import util.TestCaseUtil;

import java.util.Stack;

public class ValidParenthesis {
    public static boolean isValid(String str) {
        Stack<Character> st = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                if (st.isEmpty()) return false;
                char top = st.pop();
                if ((top == '(' && ch != ')') || (top == '{' && ch != '}') || (top == '[' && ch != ']')) {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    static void test1() {
        String str = "(){[{()}]}";
        TestCaseUtil.test(true, isValid(str), 1);
    }

    static void test2() {
        String str = "(((((";
        TestCaseUtil.test(false, isValid(str), 2);
    }
}

