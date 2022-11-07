package MergeInterval;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {

    static List<Intervals> intervalsAfterMerge(List<Intervals> intervals) {
        if (intervals.size() < 2) {
            return intervals;
        }
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        List<Intervals> ans = new ArrayList<>();
        ans.add(intervals.get(0));
        int left = 0;

        for (int i = 1; i < intervals.size(); i++) {
            Intervals cur = intervals.get(i);
            Intervals prev = ans.get(left);
            if (isOverlap(prev, cur)) {
                ans.remove(left);
                ans.add(left, new Intervals(prev.start, Math.max(prev.end, cur.end)));
            } else {
                ans.add(cur);
                left++;
            }
        }
        return ans;
    }

    static boolean isOverlap(Intervals left, Intervals right) {
        return left.end >= right.start;
    }


    public static void main(String[] args) {
        List<Intervals> intervals = new ArrayList<>();
        intervals.add(new Intervals(1, 4));
        intervals.add(new Intervals(2, 5));
        intervals.add(new Intervals(7, 9));
        System.out.println("After Merge: " + intervalsAfterMerge(intervals)); // [[1,5], [7,9]]

        intervals = new ArrayList<>();
        intervals.add(new Intervals(6, 7));
        intervals.add(new Intervals(2, 4));
        intervals.add(new Intervals(5, 9));
        System.out.println("After Merge: " + intervalsAfterMerge(intervals)); // [[2,4], [5,9]]

        intervals = new ArrayList<>();
        intervals.add(new Intervals(1, 4));
        intervals.add(new Intervals(2, 6));
        intervals.add(new Intervals(3, 5));
        System.out.println("After Merge: " + intervalsAfterMerge(intervals)); // [[1,6]]


    }
}
