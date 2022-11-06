package twopointers;

public class SquaringSortedArray {

    public static void main(String[] args) {
        printArray(squareSortedArray(new int[]{-2, -1, 0, 2, 3})); // [0, 1, 4, 4, 9]
        printArray(squareSortedArray(new int[]{-3, -1, 0, 1, 2})); // [0, 1, 1, 4, 9]
    }

    static int[] squareSortedArray(int[] array) {
        int[] ans = new int[array.length];
        return ans;
    }

    static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
