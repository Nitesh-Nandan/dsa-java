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

        while (curr < right && left < right) {
            if (arr[curr] == 0) {
                arr[curr] = arr[left];
                arr[left++] = 0;
                if (curr < left) {
                    curr = left + 1;
                }
            } else if (arr[curr] == 2) {
                arr[curr] = arr[right];
                arr[right--] = 2;
            } else {
                curr++;
            }
        }
    }

    static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
