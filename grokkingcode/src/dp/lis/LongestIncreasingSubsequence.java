package dp.lis;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {

        List<Integer> ans = new ArrayList<>();

        for(int num: nums) {
            insertInOrder(ans, num);
            System.out.println("Hold");
        }
        return ans.size();
    }

    private static void insertInOrder(List<Integer> lis, int num) {
        if(lis.isEmpty() || lis.get(lis.size()-1) < num) {
            lis.add(num);
            return;
        }

        int low = 0;
        int high = lis.size()-1;
        int pos = -1;

        while(low <= high) {
            int mid = low + (high-low)/2;

            if(lis.get(mid) >= num) {
                pos = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        lis.remove(pos);
        lis.add(pos, num);
    }



    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        int[] arr  = new int[] {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(arr));
    }
}
