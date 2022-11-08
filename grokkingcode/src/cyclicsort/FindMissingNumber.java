package cyclicsort;

public class FindMissingNumber {

    static int missingNumber(int[] arr) {
        int itr = 0;
        while (itr < arr.length) {
            if (arr[itr] < arr.length && itr != arr[itr]) {
                CyclicUtil.swap(arr, itr, arr[itr]);
            } else {
                itr++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i) {
                return i;
            }
        }

        return arr.length;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{4, 0, 3, 1}));
        System.out.println(missingNumber(new int[]{8, 3, 5, 2, 4, 6, 0, 1}));
    }
}
