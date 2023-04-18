package util;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    public static <T> List<T> fromArrayToList(T[] arr) {
       return Arrays.stream(arr).collect(Collectors.toList());
    }

    public static <T, R> List<R> fromArrayToList(T[] arr, Function<T, R> mapper) {
        return Arrays.stream(arr)
                .map(mapper)
                .collect(Collectors.toList());
    }

    public static <T> Object[] listToArray(List<T> list) {
        Object[] arr  = new Object[list.size()];
        for(int i=0; i<list.size(); i++){
            arr[i] = list.get(i);
        }
        return arr;
    }

}
