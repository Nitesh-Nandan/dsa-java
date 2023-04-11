package challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i <= nums.length - 4; i++) {
            for (int j = i + 1; j <= nums.length - 3; j++) {
                int tar = target - (nums[i] + nums[j]);
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    if (nums[left] + nums[right] == tar) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] < tar) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    static void test1() {
        System.out.println(fourSum(new int[]{-3, 9, -6, 0, 3, 6}, 0));
    }

    static void test2() {
        System.out.println(fourSum(new int[]{0, 0, 0, 0}, 0));
    }

}
