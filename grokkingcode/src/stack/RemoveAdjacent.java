package stack;

import java.util.Stack;

public class RemoveAdjacent {
    public static String removeDuplicates(String str) {
        Stack<Character> st = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            if(!st.empty() && st.peek() == str.charAt(i)) {
                st.pop();
            } else {
                st.push(str.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!st.empty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        test1();
    }

    static void test1() {
        System.out.println(removeDuplicates("xyyxxzx"));
        System.out.println(removeDuplicates("sadyydassa"));
    }
}
