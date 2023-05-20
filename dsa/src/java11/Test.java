package java11;

import java.util.Stack;

/**
 * Given an array, print the Next Greater Element (NGE) for every element.
 *
 * The Next greater Element for an element x is the first greater element on the right side of x in the array. Elements for which no greater element exist, consider the next greater element as -1.
 *
 * Example:
 *
 * Input: arr[] = [ 4 , 5 , 2 , 25 ]
 * Output:        4      –>   5
 *                5      –>   25
 *                2      –>   25
 *               25     –>   -1
 *
 * Input: arr[] = [ 13 , 7, 6 , 12 ]
 * Output:        13      –>    -1
 *                 7       –>     12
 *                 6       –>     12
 *                12      –>     -1
 *
 *
 *   res - 5, 25, 25, -1
 *   stack -> 25 5 4

**/

public class Test {

    public static  void nextGreaterElement(int[] arr) {
        int[] ans  = new int[arr.length];
        ans[arr.length-1] = -1;

        Stack<Integer> st = new Stack<>();
        st.push(arr[ans.length-1]);


        for(int i = ans.length-2; i>=0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }

        for(int num : ans) {
            System.out.print(num + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[] {13 , 7, 6 ,12,1,2,3,5,8,10,11,20 };
        nextGreaterElement(arr);
    }


    /**
     * @Test
     * void testForNextGreaterElement() {
     *     int[] given = new int[] {13 , 7, 6 ,12,1,2,3,5,8,10,11,20 };
     *     int[] expected = new int[] {20 12 12 20 2 3 5 8 10 11 20 -1};
     *
     *     *
     *     *     *
     *
     *     *     *
     *
     *     *     *
     *     *     *
     *     *
     *     *
     * }
     * */
}

















