package dp.lis;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IncreasingTripletSubsequence {
    // This can also be solved using LIS
    public boolean increasingTriplet(int[] nums) {

        LinkedList<Integer>  lis = new LinkedList<>();
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int num: nums) {
            if(min1 >= num) {
                min1 = num;
            } else if(min2 >= num) {
                min2 = num;
            } else {
                return true;
            }
        }
        return false;

    }
}
