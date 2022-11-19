package cyclicsort;

public class FindMissingAndRepeatingNumber {

    static int[] findMissingAndRepeatingNumber(int[] arr) {
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = findMissingAndRepeatingNumber(new int[]{3, 1, 2, 5, 2});
        System.out.println(nums[0] + ", " + nums[1]); // 4, 2
        nums = findMissingAndRepeatingNumber(new int[]{3, 1, 2, 3, 6, 4});
        System.out.println(nums[0] + ", " + nums[1]); // 5, 3
    }
}
