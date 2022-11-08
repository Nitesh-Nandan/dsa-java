package cyclicsort;

public class CycleSort {

    static void doCyclicSort2(int[] arr) {
        int itr = 0;
        while (itr < arr.length) {
            if (arr[itr] != itr + 1) {
                int curVal = arr[itr];
                arr[itr] = arr[arr[itr]-1];
                arr[curVal-1] = curVal;
            } else {
                itr++;
            }
        }
    }

    static void doCyclicSort(int[] arr) {
        int itr = 0;
        while (itr < arr.length) {
           if (arr[itr] != arr[arr[itr]-1]) {
               CyclicUtil.swap(arr, itr, arr[itr]-1);
           } else {
               itr++;
           }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 4, 4, 4, 4};
        doCyclicSort(arr);
        print(arr);

//        int[] arr2 = {2, 6, 4, 3, 1, 5};
//        doCyclicSort(arr2);
//        print(arr2);
//
//        int[] arr3 = {1, 5, 6, 4, 3, 2};
//        doCyclicSort(arr3);
//        print(arr3);
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
