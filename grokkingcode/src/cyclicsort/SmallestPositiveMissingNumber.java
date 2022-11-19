package cyclicsort;

public class SmallestPositiveMissingNumber {

    static int smallestMissingPositiveNumber(int[] arr) {
       return -1;
    }

    public static void main(String[] args) {
        System.out.println(smallestMissingPositiveNumber(new int[] { -3, 1, 5, 4, 2 })); // 3
        System.out.println(smallestMissingPositiveNumber(new int[] { 3, -2, 0, 1, 2 })); // 4
        System.out.println(smallestMissingPositiveNumber(new int[] { 3, 2, 5, 1 })); // 4
    }
}
