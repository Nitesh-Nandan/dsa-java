package twopointers;

public class CountUniqueElements {
    public static void main(String[] args) {
        System.out.println(countUniqueElements(new int[]{2, 3, 3, 3, 6, 9, 9})); // 4
        System.out.println(countUniqueElements(new int[]{2, 2, 2, 11})); // 4
    }
    static int countUniqueElements(int[] arr) {
        int count = 1;
        for(int i = 1; i<arr.length; i++) {
            if(arr[i] != arr[i-1]) {
                count++;
            }
        }

        return count;
    }
}
