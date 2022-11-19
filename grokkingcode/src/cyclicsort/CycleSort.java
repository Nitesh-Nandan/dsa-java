package cyclicsort;

public class CycleSort {

    static void doCyclicSort2(int[] arr) {

    }

    static void doCyclicSort(int[] arr) {
       
    }

    public static void main(String[] args) {
        int[] arr = {4, 4, 4, 4, 4};
        doCyclicSort(arr);
        print(arr);

        int[] arr2 = {2, 6, 4, 3, 1, 5};
        doCyclicSort(arr2);
        print(arr2);

        int[] arr3 = {1, 5, 6, 4, 3, 2};
        doCyclicSort(arr3);
        print(arr3);
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
