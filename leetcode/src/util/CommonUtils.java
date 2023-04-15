package util;

import javax.sound.midi.Soundbank;

public class CommonUtils {

    public static void printArr(int[] arr, String message) {
        if (message != null) {
            System.out.print(message + ": ");
        }
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void printArr(int[] arr) {
        printArr(arr, null);
    }
}
