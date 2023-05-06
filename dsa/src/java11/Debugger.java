package java11;


import java.util.Arrays;
import java.util.Collections;

public class Debugger {

    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        int pos = -1;
        for(int i=len-2; i>=0; i--) {
            if(nums[i] < nums[i+1]) {
                pos = i;
                break;
            }
        }
        if(pos == -1) {
            Arrays.sort(nums);
        } else {
            int left = nums[pos];
            int swap = pos+1;

            for(int i=pos+1; i<len; i++) {
                if(nums[i] > left ) {
                    if(nums[swap] > nums[i]) {
                        swap = i;
                    }
                }
            }
            int tmp = nums[swap];
            nums[swap] = nums[pos];
            nums[pos] = tmp;

            Arrays.sort(nums, pos+1, len);
        }
    }

    public static void main(String[] args) {
//        int[] arr = {1, 2, 3};
//        nextPermutation(arr);

        int[] arr2 = new int[]{5,3,4,9,7, 6,};
        nextPermutation(arr2);
    }
}
