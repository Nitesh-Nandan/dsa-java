package mergeInterval;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersection {

    private static Intervals[] getIntervalIntersection(Intervals[] input1, Intervals[] input2) {
        List<Intervals> intersections = new ArrayList<>();
        return intersections.toArray(new Intervals[0]);
    }

    public static void main(String[] args) {
        Intervals[] input1 = new Intervals[]{new Intervals(1, 3), new Intervals(5, 6), new Intervals(7, 9)};
        Intervals[] input2 = new Intervals[]{new Intervals(2, 3), new Intervals(5, 7)};
        Intervals[] result = getIntervalIntersection(input1, input2);
        System.out.print("Intervalss Intersection: ");
        for (Intervals Intervals : result)
            System.out.print("[" + Intervals.start + "," + Intervals.end + "] ");
        System.out.println();

        input1 = new Intervals[]{new Intervals(1, 3), new Intervals(5, 7), new Intervals(9, 12)};
        input2 = new Intervals[]{new Intervals(5, 10)};
        result = getIntervalIntersection(input1, input2);
        System.out.print("Intervalss Intersection: ");
        for (Intervals Intervals : result)
            System.out.print("[" + Intervals.start + "," + Intervals.end + "] ");
    }

}
