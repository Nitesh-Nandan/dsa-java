package javads;

import java.util.Stack;

public class JavaStackDemo {

    public static void main(String[] args) {
        stackDemo();
    }


    static void stackDemo() {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
