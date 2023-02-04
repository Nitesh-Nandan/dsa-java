package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {
    public static String minRemoveParentheses(String str) {

        Stack<Integer> extraOpen = new Stack<>();
        List<Integer> extraClosing = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                extraOpen.push(i);
            }
            if (str.charAt(i) == ')') {
                if(extraOpen.isEmpty()) {
                    extraClosing.add(i);
                } else {
                    extraOpen.pop();
                }
            }
        }

        char[] chars = str.toCharArray();
        while (!extraOpen.isEmpty()) {
            chars[extraOpen.pop()] = '*';
        }
        extraClosing.stream().forEach(val -> chars[val]= '*');
        StringBuilder sb = new StringBuilder();
        for (char ch : chars) {
            if (ch != '*') {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        test1();
    }

    static void test1() {
        System.out.println(minRemoveParentheses("ab)ca(so)(sc(s)("));
    }
}
