package debug;

class Solution {
    public boolean circularArrayLoop(int[] nums) {
        // 0 -> not traversed
        // 1-> is in progress
        // 2 -> processed
        int[] colors = new int[nums.length];

        for(int i=0;i<nums.length; i++) {
            if(colors[i] == 0) {
                if(doDfs(nums, colors, i)) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean doDfs(int[] nums, int[] colors, int start) {
        if(colors[start] == 2) return false;
        colors[start] = 1;

        int next = start + nums[start];
        next = (next % nums.length) + nums.length;
        next = next % nums.length;

        if(next == start || nums[next] * nums[start] < 0) {
            colors[start] = 2;
            return false;
        }

        if(colors[next] == 1) {
            colors[start] = 2;
            return true;
        }

        if(doDfs(nums, colors, next)) {
            return true;
        }

        colors[start] = 2;

        return false;
    }
}

public class LeetCode {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.circularArrayLoop(new int[]{-1,-2,-3,-4,-5,6}));
        System.out.println(solution.circularArrayLoop(new int[]{6,-2,-3,-4,-5,6}));
    }
}
