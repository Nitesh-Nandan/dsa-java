package challenge;

public class MaximumSubArray {

    public static int maxSubArray(int[] nums) {
        int currSum = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] + currSum < nums[i]) {
                currSum = nums[i];
            } else {
                currSum += nums[i];
            }
            maxSoFar = Math.max(maxSoFar, currSum);
        }
        return maxSoFar;
    }


}
