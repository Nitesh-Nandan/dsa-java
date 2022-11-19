package mergeInterval;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervals {

    static List<Intervals> insertIntervals(List<Intervals> intervals, Intervals newIntervals) {
        List<Intervals> ans = new ArrayList<>();
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
