package cyclicsort;

public class SmallestPositiveMissingNumber {

    static int smallestMissingPositiveNumber(int[] arr) {
        int itr = 0;

        while (itr < arr.length) {
           if(arr[itr] > 0 && arr[itr] <= arr.length && arr[itr] != arr[arr[itr]-1]) {
               CyclicUtil.swap(arr, itr, arr[itr]-1);
           } else {
               itr++;
           }
        }

        for(int i=0;i<arr.length; i++) {
            if(arr[i] != i+1) {
                return i+1;
            }
        }
        return arr.length+1;
    }

    public static void main(String[] args) {
        System.out.println(smallestMissingPositiveNumber(new int[] { -3, 1, 5, 4, 2 })); // 3
        System.out.println(smallestMissingPositiveNumber(new int[] { 3, -2, 0, 1, 2 })); // 4
        System.out.println(smallestMissingPositiveNumber(new int[] { 3, 2, 5, 1 })); // 4
    }
}
