package cyclicsort;

import java.util.ArrayList;
import java.util.List;

public class FindAllMissingNumber {

   static List<Integer> findNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<nums.length; i++) {
            int val = Math.abs(nums[i]);
            nums[val-1] = -1 * Math.abs(nums[val-1]);
        }

        for(int i=0; i< nums.length; i++) {
            if(nums[i] > 0) {
                ans.add(i+1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        List<Integer> missing = findNumbers(new int[] { 2, 3, 1, 8, 2, 3, 5, 1 });
        System.out.println("Missing numbers: " + missing); // [4, 6, 7]

        missing = findNumbers(new int[] { 2, 4, 1, 2 });
        System.out.println("Missing numbers: " + missing); // [3]

        missing = findNumbers(new int[] { 2, 3, 2, 1 });
        System.out.println("Missing numbers: " + missing); // [4]
    }
}
