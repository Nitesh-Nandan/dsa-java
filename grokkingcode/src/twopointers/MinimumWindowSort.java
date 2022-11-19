package twopointers;

public class MinimumWindowSort {

    public static void main(String[] args) {
        System.out.println(minimumLengthSort(new int[]{1, 2, 5, 3, 7, 10, 9, 12})); // 5
        System.out.println(minimumLengthSort(new int[]{1, 3, 2, 0, -1, 7, 10})); // 5
        System.out.println(minimumLengthSort(new int[]{1, 2, 3})); // 0
        System.out.println(minimumLengthSort(new int[]{3, 2, 1})); // 3
    }

    static int minimumLengthSort(int[] arr) {
        return -1;
    }
}
