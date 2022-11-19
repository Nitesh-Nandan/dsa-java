package mergeInterval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {

    static List<Intervals> intervalsAfterMerge(List<Intervals> intervals) {
        return Collections.emptyList();
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
