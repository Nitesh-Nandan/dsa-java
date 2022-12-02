package cyclicsort2;

public class FindCorruptPair {
    // {missing, repeating}
    public static int[] findCorruptPair(int[] nums) {
        int itr = 0;
        while (itr < nums.length) {
            if (nums[itr] <= nums.length && nums[itr] != nums[nums[itr] - 1]) {
                swap(nums, itr, nums[itr] - 1);
            } else {
                itr++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[]{i + 1, nums[i]};
            }
        }
        return new int[]{};
    }

    static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    static void test1() {
        int[] res = findCorruptPair(new int[]{4, 1, 3, 4, 5});
        System.out.println(res[0] + " " + res[1]); // 2 4
    }

    static void test2() {
        int[] res = findCorruptPair(new int[]{3, 1, 2, 5, 2});
        System.out.println(res[0] + " " + res[1]); // 2 4
    }

    static void test3() {
        int[] res = findCorruptPair(new int[]{5, 3, 5, 6, 2, 1});
        System.out.println(res[0] + " " + res[1]); // 4 5
    }
}
