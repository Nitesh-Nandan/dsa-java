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
        int left = 0;
        int right = arr.length - 1;
        int curr = 0;

        while (curr <= right) {
            if(arr[curr] == 0) {
                swap(arr, curr, left);
                left++;
                if(left > curr) curr = left;
            } else if (arr[curr] == 2) {
                swap(arr, curr, right);
                right--;
            } else {
                curr++;
            }
        }
    }

    static void swap(int[]arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
