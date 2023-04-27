package binarysearch;

public class BinarySearchUtil {

    private static int lowerBound(int[] arr, int num) {
        int low = 0;
        int high = arr.length - 1;

        if(num <= arr[low]) return 0;
        if(num >= arr[high]) return high;


        return 0;

    }
}
