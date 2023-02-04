package stack;

import java.util.Stack;

public class BasicCalculator {
    public static int calculator(String expression) {
        Stack<String> st = new Stack<>();

        int num = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == ' ') {
                if (num != 0) st.push(String.valueOf(num));
                num = 0;
                continue;
            }
            if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                num = num * 10 + (expression.charAt(i) - '0');
            } else if (expression.charAt(i) == ')') {
                while (!st.empty()) {
                    String op = st.pop();
                    if(op.equals("(")) {
                        break;
                    }
                    if (op.equals("+")) {
                        num = num + Integer.parseInt(st.pop());
                    }
                    else if (op.equals("-")) {
                        num = Integer.parseInt(st.pop()) - num;
                    } else {
                        num = Integer.parseInt(op);
                    }
                }
                st.push(String.valueOf(num));
                num = 0;
            } else {
                st.push(String.valueOf(expression.charAt(i)));
            }
        }
        while (!st.empty()) {
            String op = st.pop();
            if(op.equals("(")) {
                break;
            }
            if (op.equals("+")) {
                num = num + Integer.parseInt(st.pop());
            }
            else if (op.equals("-")) {
                num = Integer.parseInt(st.pop()) - num;
            } else {
                num = Integer.parseInt(op);
            }
        }

        return num;
    }

    static void process(Stack<String> st) {
        int tres = 0;

    }

    public static void main(String[] args) {
        test1();
    }

    static void test1() {
        String exp = "(8 + 100) + (13 - 8 - (2 + 1))";
        System.out.println(calculator(exp));
    }

}
