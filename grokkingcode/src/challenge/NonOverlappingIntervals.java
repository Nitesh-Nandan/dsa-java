package challenge;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public int removeMinimumIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int left = 0;
        int right = 1;
        int ans = 0;

        while (right < intervals.length) {
            if (intervals[left][1] <= intervals[right][0]) {
                left = right;
                right = right + 1;
            } else if (intervals[left][1] <= intervals[right][1]) {
                ans += 1;
                right++;
            } else if (intervals[left][1] > intervals[right][1]){
                ans += 1;
                left = right;
                right += 1;
            }
        }

        return ans;
    }
}
