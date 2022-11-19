package mergeInterval;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervals {

    static List<Intervals> insertIntervals(List<Intervals> intervals, Intervals newIntervals) {
        List<Intervals> ans = new ArrayList<>();
        int itr = 0;
        while (itr < intervals.size() && intervals.get(itr).end < newIntervals.start) {
           ans.add(intervals.get(itr++));
        }

        while (itr < intervals.size() && intervals.get(itr).start <= newIntervals.end) {
            newIntervals.start = Math.min(intervals.get(itr).start, newIntervals.start);
            newIntervals.end = Math.max(intervals.get(itr).end, newIntervals.end);
            itr++;
        }
        ans.add(newIntervals);
        while (itr < intervals.size()) {
            ans.add(intervals.get(itr++));
        }

        return ans;
    }

    public static void main(String[] args) {
        List<Intervals> input = new ArrayList<>();
        input.add(new Intervals(1, 3));
        input.add(new Intervals(5, 7));
        input.add(new Intervals(8, 12));
        System.out.print("Intervalss after inserting the new Intervals: ");
        System.out.println(insertIntervals(input, new Intervals(4, 6))); // [[1,3], [4,7], [8,12]]

        input = new ArrayList<>();
        input.add(new Intervals(1, 3));
        input.add(new Intervals(5, 7));
        input.add(new Intervals(8, 12));
        System.out.print("Intervalss after inserting the new Intervals: ");
        System.out.println(insertIntervals(input, new Intervals(4, 10))); // [[1,3], [4,12]]

        input = new ArrayList<>();
        input.add(new Intervals(2, 3));
        input.add(new Intervals(5, 7));
        System.out.print("Intervalss after inserting the new Intervals: ");
        System.out.println(insertIntervals(input, new Intervals(1, 4))); // [[1,4], [5,7]]

        input = new ArrayList<>();
        input.add(new Intervals(1, 3));
        input.add(new Intervals(8, 11));
        System.out.print("Intervalss after inserting the new Intervals: ");
        System.out.println(insertIntervals(input, new Intervals(5, 7))); // [[1,3], [5,7], [8,11]]
    }
}
