package dp.lis;

public class FindNumberOfLis {
    private static int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans = 1;

        return ans;
    }

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        boolean ans = true;
        System.out.println(ans&false);
        System.out.println(ans&&false);

        int[] arr = new int[]{2, 2, 2, 2, 2};
        System.out.println(findNumberOfLIS(arr));
    }
}
