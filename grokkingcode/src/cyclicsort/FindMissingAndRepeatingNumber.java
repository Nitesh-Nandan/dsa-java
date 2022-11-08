package cyclicsort;

public class FindMissingAndRepeatingNumber {

    static int[] findMissingAndRepeatingNumber(int[] arr) {
        int itr = 0;
        while (itr < arr.length) {
            if (arr[itr] != arr[arr[itr] - 1]) {
                CyclicUtil.swap(arr, itr, arr[itr] - 1);
            } else {
                itr++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                return new int[]{i + 1, arr[i]};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = findMissingAndRepeatingNumber(new int[]{3, 1, 2, 5, 2});
        System.out.println(nums[0] + ", " + nums[1]); // 4, 2
        nums = findMissingAndRepeatingNumber(new int[]{3, 1, 2, 3, 6, 4});
        System.out.println(nums[0] + ", " + nums[1]); // 5, 3
    }
}
