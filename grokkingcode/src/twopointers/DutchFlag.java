package twopointers;

public class DutchFlag {

    public static void main(String[] args) {
        int[] intput1 = {1, 0, 2, 1, 0};
        dutchSort(intput1);
        printArr(intput1);
        int[] input2 = {2, 2, 0, 1, 2, 0};
        dutchSort(input2);
        printArr(input2);
        int[] input3 = {2, 2, 0, 1, 2, 0, 2, 1, 0, 1, 1, 1, 1, 2, 2, 2, 0};
        dutchSort(input3);
        printArr(input3);
    }

    static void dutchSort(int[] arr) {
    }

    static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
