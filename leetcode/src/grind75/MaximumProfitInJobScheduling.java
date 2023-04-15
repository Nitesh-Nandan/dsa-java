package grind75;

import util.TestCaseUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class MaximumProfitInJobScheduling {
    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len = profit.length;
        if (len == 0) return 0;
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }

        Collections.sort(jobs, (j1, j2) -> Integer.compare(j1.startTime, j2.startTime));

        int[] dp = new int[len];
        dp[0] = jobs.get(0).profit;

        for (int i = 1; i < len; i++) {
            Job curr = jobs.get(i);
            int currMax = 0;
            for (int j = i - 1; j >= 0; j--) {
                Job pre = jobs.get(j);
                if (curr.startTime >= pre.endTime) {
                    currMax = Math.max(currMax, dp[j]);
                }
            }
            dp[i] = currMax == 0 ? curr.profit : curr.profit + currMax;
        }

        int ans = 0;
        for (int value : dp) {
            ans = Math.max(ans, value);
        }

        return ans;
    }

    public static int jobScheduling2(int[] startTime, int[] endTime, int[] profit) {
        int len = profit.length;
        int[][] jobs = new int[len][3];

        for (int i = 0; i < len; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        Arrays.sort(jobs, (a, b) -> Integer.compare(a[1], b[1]));

        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0, 0);

        for (int i = 0; i < len; i++) {
            int include = jobs[i][2] + dp.floorEntry(jobs[i][0]).getValue();
            int exclude = dp.lastEntry().getValue();

            if (include > exclude) {
                dp.put(jobs[i][1], include);
            }
        }
        return dp.lastEntry().getValue();
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        int[] startTimes = new int[]{1, 2, 3, 3};
        int[] endTimes = new int[]{3, 4, 5, 6};
        int[] profits = new int[]{50, 10, 40, 70};

        TestCaseUtil.test(120, jobScheduling(startTimes, endTimes, profits), 1);
        TestCaseUtil.test(120, jobScheduling2(startTimes, endTimes, profits), 1);
    }

    private static void test2() {
        int[] startTimes = new int[]{1, 2, 3, 4, 6};
        int[] endTimes = new int[]{3, 5, 10, 6, 9};
        int[] profits = new int[]{20, 20, 100, 70, 60};

        TestCaseUtil.test(150, jobScheduling(startTimes, endTimes, profits), 2);
        TestCaseUtil.test(150, jobScheduling2(startTimes, endTimes, profits), 2);
    }

    private static void test3() {
        int[] startTimes = new int[]{1, 1, 1};
        int[] endTimes = new int[]{2, 3, 4};
        int[] profits = new int[]{5, 6, 4};

        TestCaseUtil.test(6, jobScheduling(startTimes, endTimes, profits), 3);
        TestCaseUtil.test(6, jobScheduling2(startTimes, endTimes, profits), 3);
    }

    static class Job {
        int startTime;
        int endTime;
        int profit;

        public Job(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }
}
