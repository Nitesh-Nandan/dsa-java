package fastslowpointer;

public class CircularArray {

    public static void main(String[] args) {
        System.out.println(hasCircularArray(new int[]{2,-1,1,2,2})); // true
        System.out.println(hasCircularArray(new int[]{-1,-2,-3,-4,-5,6})); // false
        System.out.println(hasCircularArray(new int[]{1,-1,5,1,4})); // true
    }

    static boolean hasCircularArray(int[] arr) {
        return false;
    }

    static boolean doDfs(int[] arr, int[] color, int start) {
        return false;
    }
}
