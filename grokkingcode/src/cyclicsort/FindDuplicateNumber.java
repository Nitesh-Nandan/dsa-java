package cyclicsort;

public class FindDuplicateNumber {

    public static int findNumber(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }


    public static void main(String[] args) {
        System.out.println(findNumber(new int[]{1, 4, 4, 3, 2})); // 4
        System.out.println(findNumber(new int[]{2, 1, 3, 3, 5, 4})); // 3
        System.out.println(findNumber(new int[]{2, 4, 1, 4, 4})); // 4;
    }
}
