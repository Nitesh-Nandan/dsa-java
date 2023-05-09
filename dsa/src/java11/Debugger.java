package java11;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        Map<Integer, List<Integer>> test = new HashMap<>();
        test.computeIfAbsent(1000, k -> {
            System.out.println(k);
            return new ArrayList<>();
        }).add(5);

        System.out.println(test);
    }
}
